<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personal Blog</title>
</head>
<body>
	<h1>New Article</h1>
	
	<form id="formNewArticle" action="/PersonalBlog/ArticleServlet" method="GET"">
		<input type="text" id="newArticleTitle" name="newArticleTitle" placeholder="Article Title"></input>
		<input type="text" id="newArticleContent" name="newArticleContent" placeholder="Content"></input>
	
		<div>
			<input type="submit" id="newArticle_submit" name="newArticle_submit" value="Publish"></input>
		</div>
	</form>
	
	<button type="button" name="back" onclick="history.back()">Go back</button>
</body>
</html>