<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>ユーザー情報を編集</title>
</head>
<body>
	<article>
		<h1>ユーザー情報を編集</h1>
		
		<form action="/bm/BmServlet" method="post" name="form">
		
		<p>ユーザーID</p>
		<p>${id}</p>
		<p>メールアドレス</p>
		<input type="text" name="mail" id="mail" value="${mail}">
		<p>パスワード</p>
		<input type="password" name="password" id="password" value="${pass}" placeholder="●●●●●●">
				
		<p><button type="submit">保存</button></p>
		<input type="hidden" name="action" value="updateUser">
		<input type="hidden" name="id" value="${id}">	
		</form>
	</article>

</body>
</html>