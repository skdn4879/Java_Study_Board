<%@page import="kr.co.board.board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h1>게시글 리스트</h1>
	
	<%ArrayList<BoardDto> ar = (ArrayList<BoardDto>)request.getAttribute("list");
	String visitedCookie = (String)request.getAttribute("visitedCookie");
	Integer pageCount = (Integer)request.getAttribute("pageCount"); %>
	
	<h3>총 게시글 수 : <%=(Integer)request.getAttribute("boardCount") %></h3>
	
	<h3>오늘의 모든 이용자 방문 횟수 : <%=visitedCookie %></h3>
	
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<%for(BoardDto boardDto : ar){ %>
				<tr>
					<td><%=boardDto.getBoardNum() %></td>
					<td><a href="./detail?boardNum=<%=boardDto.getBoardNum()%>"><%=boardDto.getTitle() %></a></td>
					<td><%=boardDto.getWriter() %></td>
					<td><%=boardDto.getWriteDate() %></td>
					<td><%=boardDto.getViewCount() %></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<hr>
	<%for(int i = 0; i < pageCount; i++){ %>
	<a href="./list?start=<%=i * 5 %>"><%=i + 1 %></a>
	<%} %>
	<hr>
	<br>
	<a href="/board/">메인페이지</a>
	<hr>
	<br>
	<a href="./add">글 작성</a>
</body>
</html>