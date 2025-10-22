package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.BlogEnArticle;

@WebServlet("/HomepageServlet")
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final File folder = new File("/home/konka/eclipse-workspace/PersonalBlog/src/main/webapp/articles");
	
//	BlogEnArticle article1 = new BlogEnArticle("My first article", "Content of my first article");
//	BlogEnArticle article2 = new BlogEnArticle("My second article", "Content of my second article");
	List <BlogEnArticle> listArticles = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomepageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		listArticles = loadArticles();
		
	    request.setAttribute("listArticles", listArticles);
		
        // Dispatch the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/index.jsp");
        dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        listArticles.clear();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private List<BlogEnArticle> loadArticles () {
		List <BlogEnArticle> storedArticles = new ArrayList<>();
		for (final File fileEntry : folder.listFiles()) {
			Path file_path = Path.of("/home/konka/eclipse-workspace/PersonalBlog/src/main/webapp/articles/" + fileEntry.getName());
			if (Files.exists(file_path)){
				try {
		            String jsonContent = Files.readString(file_path);
		            String[] articleList = jsonContent.replace("[", "")
		                                            .replace("]", "")
		                                            .split("},");
		            for (String articleJSON : articleList){
		                if (!articleJSON.endsWith("}")){
		                	articleJSON = articleJSON + "}";
		                	storedArticles.add(convertJSONtoBlogEnArticle(articleJSON));
		                } else {
		                	storedArticles.add(convertJSONtoBlogEnArticle(articleJSON));
		                }
		            }
		        } catch (IOException e){
		            e.printStackTrace();
		        }
	        }
	    }
		
		return storedArticles;
	}
	
	private BlogEnArticle convertJSONtoBlogEnArticle (String articleJSON) {
		articleJSON = articleJSON.replace("{", "").replace("}", "").replace("\"", "");
        String[] json1 = articleJSON.split(",");

        String id = json1[0].split(":")[1].strip();
        String title = json1[1].split(":")[1].strip();
        String content = json1[2].split(":")[1].strip();
        String createdAtStr = json1[3].split(":")[1].strip() + ", " + json1[4].strip();

        BlogEnArticle article = new BlogEnArticle(Integer.valueOf(id), title, content);
  
        article.setCreatedAt(createdAtStr);

        return article;
	    
	}

}
