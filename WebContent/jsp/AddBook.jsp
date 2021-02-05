<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>書籍情報を編集</title>
</head>
<body>
	<article>
		<h1>書籍情報を編集</h1>
		
		<p>ユーザーID</p>
		<p>${id}</p>
		
		<form action="/bm/BmServlet" method="post" name="form">
		
		<p>タイトル</p>
		<input type="text" name="title" id="title">
		<p>著者</p>
		<input type="text" name="author" id="author">
		<p>出版社</p>
		<input type="text" name="publisher" id="publisher">
				
		<p><button type="submit">保存</button></p>
		<input type="hidden" name="action" value="addNewBook">
		<input type="hidden" name="userID" value="${userID}">	
		</form>
	</article>

</body>
</html>