<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personal Blog</title>
</head>
<body>
	<h1>Update Article</h1>
	
	<form id="formUpdateArticle" action="/PersonalBlog/ArticleServlet" method="GET"">
		<input type="text" id="updateArticleTitle" name="updateArticleTitle" placeholder="Article Title"></input>
		<input type="text" id="updateArticleContent" name="updateArticleContent" placeholder="Content"></input>
		
		<div>
			<input type="submit" id="updateArticle_submit" name="updateArticle_submit" value="Update"></input>
		</div>
	</form>
	
	<button type="button" name="back" onclick="history.back()">Go back</button>
</body>
</html>