<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>새 글 작성!!!</h1>
	<form action="write?id=<%=(String)session.getAttribute("ID")%>" method="post">
		글 제목 : <input type="text" name="title"><br><br>
		글 내용 <br>
		<textarea cols=60 rows=10 placeholder="내용을 입력하세요" name = "content"></textarea><br><br>
		<input type = "submit" value="글 저장">
	</form>
</body>
</html>