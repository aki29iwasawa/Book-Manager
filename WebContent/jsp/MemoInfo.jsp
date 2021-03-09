<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>メモ詳細</title>
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
						<input type="hidden" name="id" value="${MemoInfo.userID}">
					</form>
				</li>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">新しくメモを追加</button>
						<input type="hidden" name="action" value="addMemo">
						<input type="hidden" name="id" value="${MemoInfo.userID}">
					</form>
				</li>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">書籍を追加</button>
						<input type="hidden" name="action" value="addBook">
						<input type="hidden" name="id" value="${MemoInfo.userID}">
					</form>			
				</li>
			</ul>
			<form action="/bm/BmServlet" method="post" onsubmit="return logOut()">
				<button class="btnB" type="submit">ログアウト</button>
				<input type="hidden" name="action" value="logOut">
				<input type="hidden" name="id" value="${MemoInfo.userID}">
			</form>
		</div>
	</nav>
	<article class="scrolle">
		<h1>メモ</h1>
		<form action="/bm/BmServlet" method="post">
			<button class="btnW" type="submit">マイページへ</button>
			<input type="hidden" name="action" value="toMypage">
			<input type="hidden" name="id" value="${MemoInfo.userID}">
		</form>
		<section>
			<p>${MemoInfo.memoID}</p>
			<p>${MemoInfo.memo}</p>
			<p>${MemoInfo.create}</p>
			<p>${MemoInfo.update}</p>
			<p>${MemoInfo.userID}</p>
			
			<form action="/bm/BmServlet" method="post" name="form">
				<button class="btnW" type="submit">編集</button>		
				<input type="hidden" name="action" value="editBook">
				<input type="hidden" name="bookID" value="${MemoInfo.memoID}">
				<input type="hidden" name="userID" value="${MemoInfo.userID}">
			</form>
					
			<form action="/bm/BmServlet" method="post" name="form" onsubmit="return deleteCheck()">
				<button class="btnB" type="submit">削除</button>		
				<input type="hidden" name="action" value="deleteBook">
				<input type="hidden" name="bookID" value="${MemoInfo.memoID}">
				<input type="hidden" name="userID" value="${MemoInfo.userID}">
			</form>
		</section>
	</article>
	
<script>
    function deleteCheck(){
    	var result = window.confirm("『${BookInfo.title}』の情報を完全に削除しますか？\n削除を実行すると元には戻せません。");
    	
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