<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>メモを編集</title>
</head>
<body>
	<article>
		<h1>メモを編集</h1>
		
		<form action="/bm/BmServlet" method="post">
		<button>マイページへ</button>
		<input type="hidden" name="action" value="toMypage">
		<input type="hidden" name="id" value="${uInfo.id}">
		</form>
		
		<form action="/bm/BmServlet" method="post" name="form">
		<p>メモ</p>
		<input type="text" name="memo" id="memo" value="${aMemo}">
		
			
		<p><button type="submit">メモを保存</button></p>
		<input type="hidden" name="action" value="updateMemo">
		<input type="hidden" name="id" value="${uInfo.id}">
		</form>
		
	</article>

</body>
</html>