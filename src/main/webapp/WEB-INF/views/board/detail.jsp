<%@page import="kr.co.board.board.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<h1>글 상세 페이지</h1>
	
	<%BoardDto boardDto = (BoardDto)request.getAttribute("detail"); %>
	
	<h3>글 번호 : <%=boardDto.getBoardNum() %></h3>
	<h3>글 제목 : <%=boardDto.getTitle() %></h3>
	<h3>글 내용 : <%=boardDto.getContents() %></h3>
	<h3>작성자 : <%=boardDto.getWriter() %></h3>
	<h3>작성일자 : <%=boardDto.getWriteDate() %></h3>
	<h3>조회수 : <%=boardDto.getViewCount() %></h3>
	<hr>
	<a href="/board/">메인페이지</a>
	<a href="./list">리스트 페이지</a>
	<br>
	<%if(session.getAttribute("id").equals(boardDto.getWriter())){ %>
		<a href="./update?boardNum=<%=boardDto.getBoardNum()%>">글 수정</a>
		<a href="./delete?boardNum=<%=boardDto.getBoardNum()%>">글 삭제</a>
	<%} %>
</body>
</html>