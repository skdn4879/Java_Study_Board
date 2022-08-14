<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="join">
		<input type="text" name="id" placeholder="ID"><br>
		<input type="password" name="password" placeholder="PW"><br>
		<input type="text" name="name" placeholder="NAME"><br>
		<input type="submit" value="가입">
	</form>
	<a href="/board/">메인 페이지</a>
</body>
</html>