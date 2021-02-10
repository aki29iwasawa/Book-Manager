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
		
		<form action="/bm/BmServlet" method="post">
		<button>戻る</button>
		<input type="hidden" name="action" value="getBookInfo">
		<input type="hidden" name="bookID" value="${BookInfo.id}">
		<input type="hidden" name="userID" value="${BookInfo.userID}">
		</form>
		
		<form action="/bm/BmServlet" method="post" name="form">
		<p>タイトル</p>
		<input type="text" name="title" id="title" value="${BookInfo.title}">
		<p>著者</p>
		<input type="text" name="author" id="author" value="${BookInfo.author}">
		<p>出版社</p>
		<input type="text" name="publisher" id="publisher" value="${BookInfo.publisher}">			
		<p><button type="submit">保存</button></p>
		<input type="hidden" name="action" value="updateBook">
		<input type="hidden" name="bookID" value="${BookInfo.id}">
		<input type="hidden" name="userID" value="${BookInfo.userID}">	
		</form>
		
	</article>

</body>
</html>