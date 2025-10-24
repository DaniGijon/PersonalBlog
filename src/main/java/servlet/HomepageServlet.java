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

@WebServlet("/HomepageServlet")
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final File folder = new File("/home/konka/eclipse-workspace/PersonalBlog/src/main/webapp/articles");
	
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/index.jsp");
		HttpSession session = request.getSession();
		
		String myRole = "";
		
		String [] user_logout = request.getParameterValues("user_logout");
		if (null != user_logout && user_logout.length > 0) {
			session.removeAttribute("userRole");
		} else {
		
			if (null != session.getAttribute("userRole")) {
				myRole = (String) session.getAttribute("userRole");
			} else {
				myRole = (String) request.getParameter("userRoles");	
			}
			
			if (myRole.equals("admin")) {
				session.setAttribute("userRole", myRole);
				dispatcher = request.getRequestDispatcher("/jsps/admin.jsp");
			} else {
				session.setAttribute("userRole", "standard");
				dispatcher = request.getRequestDispatcher("/jsps/home.jsp");
			}
			
			listArticles = bsLoadArticles.loadArticles();
			
		    request.setAttribute("listArticles", listArticles);
		}
		
        dispatcher.forward(request, response);
        
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
