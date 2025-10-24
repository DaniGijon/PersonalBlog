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
		<h3>Personal Blog</h3>
		<table>
			<c:forEach items="${listArticles}" var="article">
				<tr>
				    <td> <a href="/PersonalBlog/ArticleServlet?idArticle=${article.id}&action=detail">${article.title}</a></td>
				    <td>${article.createdAt}</td>
			    </tr>
			</c:forEach>
		</table>
		
		<div>
			<input type="submit" id="user_logout" name="user_logout" value="Logout"></input>
		</div>
	</form>
</body>
</html>