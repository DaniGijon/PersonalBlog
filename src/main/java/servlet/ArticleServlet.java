package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import business.bsLoadArticles;
import entities.BlogEnArticle;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final File folder = new File("/home/konka/eclipse-workspace/PersonalBlog/src/main/webapp/articles");
	List <BlogEnArticle> listArticles = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession();
	    
	    String idArticle = request.getParameter("idArticle");
	   
	    listArticles = bsLoadArticles.loadArticles();
	    
	    for (BlogEnArticle article : listArticles) {
	    	if (idArticle.equals(String.valueOf(article.getId()))) {
	    		session.setAttribute("titleArticleSess", article.getTitle());
	    		session.setAttribute("contentArticleSess", article.getContent());
	    		session.setAttribute("createdAtArticleSess", article.getCreatedAt());
	    	}
	    }
	    
        String destination = "/jsps/articleDetail.jsp";
        

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
