<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personal Blog</title>
</head>
<body>
	<form id="formLength" action="/PersonalBlog/HomepageServlet" method="GET"">
		<h3>Hi there!</h3>
	
		<div>
			<input type="submit" id="blog_submit" name="blog_submit" value="Submit"></input>
		</div>
		
	</form>
	
	<h5>
		
		<% 
			
	       // Object listArticles = request.getAttribute("listArticles");
		
	        //out.println(listArticles);
            
        %>
        <table>
			<c:forEach items="${listArticles}" var="article">
			    ${article.title}<br>
			    ${article.content}<br>
			</c:forEach>

		</table>
     </h5>
     
</body>
</html>