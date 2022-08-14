<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form method="post" action="login">
		<input type="text" name="id" placeholder="ID"><br>
		<input type="password" name="password" placeholder="PW"><br>
		<input type="submit" value="로그인">
	</form>
	<a href="/">메인 페이지</a>
</body>
</html>