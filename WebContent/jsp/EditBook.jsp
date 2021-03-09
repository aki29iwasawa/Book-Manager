<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>書籍情報を編集</title>
</head>
<body>
	<nav>
		<img  class="logo" src="${pageContext.request.contextPath}/img/logoB.png" alt="ロゴ画像">
		<div>
			<ul>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">アカウント情報の編集・削除</button>
						<input type="hidden" name="action" value="toEditUserPage">
						<input type="hidden" name="id" value="${BookInfo.userID}">
					</form>
				</li>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">新しくメモを追加</button>
						<input type="hidden" name="action" value="addMemo">
						<input type="hidden" name="id" value="${BookInfo.userID}">
					</form>
				</li>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">書籍を追加</button>
						<input type="hidden" name="action" value="addBook">
						<input type="hidden" name="id" value="${BookInfo.userID}">
					</form>			
				</li>
			</ul>
			<form action="/bm/BmServlet" method="post" onsubmit="return logOut()">
				<button class="btnB" type="submit">ログアウト</button>
				<input type="hidden" name="action" value="logOut">
				<input type="hidden" name="id" value="${BookInfo.userID}">
			</form>
		</div>
	</nav>
	<article class="scrolle">
		<h1>書籍情報を編集</h1>
			<form action="/bm/BmServlet" method="post">
			<button class="btnW">書籍一覧へ戻る</button>
			<input type="hidden" name="action" value="getBookInfo">
			<input type="hidden" name="bookID" value="${BookInfo.id}">
			<input type="hidden" name="userID" value="${BookInfo.userID}">
			</form>
		<section>	
			<form action="/bm/BmServlet" method="post" name="form">
				<p>タイトル</p>
				<input type="text" name="title" id="title" value="${BookInfo.title}">
				<p>著者</p>
				<input type="text" name="author" id="author" value="${BookInfo.author}">
				<p>出版社</p>
				<input type="text" name="publisher" id="publisher" value="${BookInfo.publisher}">			
				<p><button class="btnB" type="submit">保存</button></p>
				<input type="hidden" name="action" value="updateBook">
				<input type="hidden" name="bookID" value="${BookInfo.id}">
				<input type="hidden" name="userID" value="${BookInfo.userID}">	
			</form>
		</section>
	</article>

</body>
</html>