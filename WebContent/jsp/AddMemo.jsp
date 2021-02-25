<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>新規メモを追加</title>
</head>
<body>
	<article>
		<h1>新規メモを追加</h1>

		<form action="/bm/BmServlet" method="post">
		<button>マイページへ</button>
		<input type="hidden" name="action" value="toMypage">
		<input type="hidden" name="id" value="${uID}">
		</form>
		
		<form action="/bm/BmServlet" method="post">
		<button type="submit">メモ一覧へ戻る</button>
		<input type="hidden" name="action" value="memoList">
		<input type="hidden" name="id" value="${uID}">
		</form>
		
		<p>ユーザーID</p>
		<p>${uID}</p>
		
		<form action="/bm/BmServlet" method="post" name="form">
		
		<p>メモ</p>
		<input type="text" name="memo" id="memo">

				
		<p><button type="submit">保存</button></p>
		<input type="hidden" name="action" value="addNewMemo">
		<input type="hidden" name="id" value="${uID}">	
		</form>
	</article>

</body>
</html>