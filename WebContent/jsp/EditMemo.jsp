<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>メモを編集</title>
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
						<input type="hidden" name="id" value="${uInfo.id}">
					</form>
				</li>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">新しくメモを追加</button>
						<input type="hidden" name="action" value="addMemo">
						<input type="hidden" name="id" value="${uInfo.id}">
					</form>
				</li>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">書籍を追加</button>
						<input type="hidden" name="action" value="addBook">
						<input type="hidden" name="id" value="${uInfo.id}">
					</form>			
				</li>
			</ul>
			<form action="/bm/BmServlet" method="post" onsubmit="return logOut()">
				<button class="btnB" type="submit">ログアウト</button>
				<input type="hidden" name="action" value="logOut">
				<input type="hidden" name="id" value="${uInfo.id}">
			</form>
		</div>
	</nav>
	<article class="scrolle">
		<h1>メモを編集</h1>
		<form action="/bm/BmServlet" method="post">
			<button class="btnW" type="submit">マイページへ</button>
			<input type="hidden" name="action" value="toMypage">
			<input type="hidden" name="id" value="${uInfo.id}">
		</form>
		<section>
			<form action="/bm/BmServlet" method="post" name="form">
				<p>メモ</p>
				<input type="text" name="memo" id="memo" value="${aMemo}">
								
				<p><button class="btnB" type="submit">メモを保存</button></p>
				<input type="hidden" name="action" value="updateMemo">
				<input type="hidden" name="id" value="${uInfo.id}">
			</form>
		</section>
	</article>
</body>
</html>