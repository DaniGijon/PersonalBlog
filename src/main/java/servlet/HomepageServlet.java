package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.BlogEnArticle;

@WebServlet("/HomepageServlet")
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BlogEnArticle article1 = new BlogEnArticle("My first article", "Content of my first article");
	BlogEnArticle article2 = new BlogEnArticle("My second article", "Content of my second article");
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
		listArticles.add(article1);
		listArticles.add(article2);
		   
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

}
