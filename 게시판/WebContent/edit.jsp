<%@page import="entity.BoardEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	BoardEntity article = (BoardEntity)request.getAttribute("Article");
%>
	<h1>새 글 작성!!!</h1>
	<form action="edit?num=<%=article.getArticleNum() %>" method="post">
		글 제목 : <input type="text" name="title" value="<%=article.getArticleTitle()%>"><br><br>
		작성자 : <%=(String)session.getAttribute("ID") %><br><br>
		글 내용 <br>
		<textarea cols=60 rows=10 name = "content"><%=article.getArticleContent() %></textarea><br><br>
		<input type = "submit" value="글 수정">
	</form>
</body>
</html>