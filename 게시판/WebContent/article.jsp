<%@page import="entity.BoardEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BoardEntity article = (BoardEntity)request.getAttribute("Article");
		boolean equal = (Boolean)request.getAttribute("Equal");
	%>
	<h1>게시물을 보아봅시다~</h1>
	작성자 : <%=article.getArticleWriter() %><br><br>
	제목 : <%=article.getArticleTitle() %><br><br>
	<%=article.getArticleContent() %><br><br>
	
	작성 날짜 : <%=article.getArticleDate() %><br>
	<% if(equal) { %>
	<a href="edit?num=<%=article.getArticleNum()%>">수정</a> <a href="delete?num=<%=article.getArticleNum()%>">삭제</a>
	<% } %>
	
</body>
</html>