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
		<div>
			<label for="userRoles">Choose your role:</label>
			<select name="userRoles" id="userRoles" form="formLength">
			  <option value="standard">Standard</option>
			  <option value="admin">Admin</option>
			</select>
		</div>
		
		<div>
			<input type="submit" id="blog_submit" name="blog_submit" value="Continue"></input>
		</div>
	</form>
</body>
</html>