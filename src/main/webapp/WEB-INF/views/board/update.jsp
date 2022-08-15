<%@page import="kr.co.board.board.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<h1>글 수정 페이지</h1>
	
	<%BoardDto boardDto = (BoardDto)request.getAttribute("boardDto"); %>
	
	<form method="post" action="update">
		<input type="hidden" name="boardNum" value="<%=boardDto.getBoardNum() %>">
		<input type="text" name="title" placeholder="글 제목" value="<%=boardDto.getTitle()%>"><br>
		<textarea rows="20" cols="50" name="contents" placeholder="글 내용"><%=boardDto.getContents()%></textarea><br>
		<input type="submit" value="작성">
	</form>
	<hr>
	<a href="/board/">메인페이지</a>
	<a href="./list">이전페이지</a>
	
</body>
</html>