<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personal Blog</title>
</head>
<body>
	<h1>${ titleArticleSess }</h1>
	<h3>${ createdAtArticleSess }</h3>
	<h5>${ contentArticleSess }</h5>
	
	<button type="button" name="back" onclick="history.back()">Go back</button>
</body>
</html>