<%@page import="entity.BoardEntity"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	사용자 ID : <%= (String)session.getAttribute("ID") %>

	<%
		// Java 코드
		// 1. JSP에게 전달된 데이터를 뽑아낼거에요
		ArrayList<BoardEntity> list = (ArrayList<BoardEntity>)request.getAttribute("MYKey");
	%>
	<center>
	<table border=1>
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>글 작성자</th>
			<th>글 작성일</th>
		</tr>
		<% for(BoardEntity tmp : list) { %>
		<tr>
			<td><%=tmp.getArticleNum() %></td>
			<td><a href="detail?num=<%=tmp.getArticleNum()%>&id=<%=(String)session.getAttribute("ID") %>"><%=tmp.getArticleTitle() %></a></td>
			<td><%=tmp.getArticleWriter() %></td>
			<td><%=tmp.getArticleDate() %></td>
		</tr>
		<% } %>
	</table>
	</center>
	
	<a href="write.jsp">글 작성~</a>
</body>
</html>