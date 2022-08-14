<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	
	<%if(session.getAttribute("id") == null){%>
		<a href="/board/member/login">로그인</a>
	<%} else{ %>
		<a href="/board/list">리스트 보기</a>
		<a href="/board/member/logout">로그아웃</a>
	<%} %>	
	
	<a href="/board/member/join">회원가입</a>
	
	<br>
	<%=session.getAttribute("id") %>
	<br>
	<%=session.getAttribute("name") %>
	
</body>
</html>
