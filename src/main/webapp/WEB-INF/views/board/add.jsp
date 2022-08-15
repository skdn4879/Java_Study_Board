<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>
	<h1>글 작성 페이지</h1>
	<form method="post" action="add">
		<input type="text" name="title" placeholder="글 제목" required="required"><br>
		<textarea rows="20" cols="50" name="contents" placeholder="글 내용" required="required"></textarea><br>
		<input type="text" name="writer" value="<%=session.getAttribute("id") %>" readonly="readonly"><br>
		<input type="submit" value="작성">
	</form>
	<hr>
	<a href="/board/">메인페이지</a>
	<a href="./list">이전페이지</a>
</body>
</html>