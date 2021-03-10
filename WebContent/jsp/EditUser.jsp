<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>ユーザー情報を編集</title>
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
		<h1>ユーザー情報を編集</h1>
		
		<form action="/bm/BmServlet" method="post">
			<button class="btnW" type="submit">マイページへ</button>
			<input type="hidden" name="action" value="toMypage">
			<input type="hidden" name="id" value="${uInfo.id}">
		</form>
		
		<form action="/bm/BmServlet" method="post" name="form">
			<p>ユーザーID</p>
			<p>${uInfo.id}</p>
			<p>メールアドレス</p>
			<input type="text" name="mail" id="mail" value="${uInfo.mail}">
			<p>パスワード</p>
			<input type="password" name="password" id="password" value="${uInfo.pass}" placeholder="●●●●●●">
					
			<p><button class="btnB" type="submit">保存</button></p>
			<input type="hidden" name="action" value="updateUser">
			<input type="hidden" name="id" value="${uInfo.id}">	
		</form>
		
		
		<form action="/bm/BmServlet" method="post" name="form" onsubmit="return deleteCheck();">
		<button type="submit">アカウントを削除する</button>		
		<input type="hidden" name="action" value="deleteUser">
		<input type="hidden" name="id" value="${uInfo.id}">
		</form>
	</article>
	
<script>
    function deleteCheck(){
    	var result = window.confirm("『アカウント情報を完全に削除しますか？\n削除を実行すると元には戻せません。");
    	
    	if(result){
    		document.form.submit();
    	}else{
    		alert("削除をキャンセルしました。")
    		return false;
    	}
    }
</script>


</body>
</html>