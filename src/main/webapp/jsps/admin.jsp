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
		<h3>Personal Blog</h3>
		<h5>Welcome, ${ userRole } user.</h5>
		<table>
			<c:forEach items="${listArticles}" var="article">
				<tr>
				    <td> <a href="/PersonalBlog/ArticleServlet?idArticle=${article.id}">${article.title}</a></td>
				    <td>${article.createdAt}</td>
			    </tr>
			</c:forEach>
		</table>
		
		<button type="button" name="back" onclick="history.back()">Logout</button>
</body>
</html>