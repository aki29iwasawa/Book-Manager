<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>書籍を検索</title>
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
						<input type="hidden" name="id" value="${uID}">
					</form>
				</li>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">新しくメモを追加</button>
						<input type="hidden" name="action" value="addMemo">
						<input type="hidden" name="id" value="${uID}">
					</form>
				</li>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">書籍を追加</button>
						<input type="hidden" name="action" value="addBook">
						<input type="hidden" name="id" value="${uID}">
					</form>			
				</li>
			</ul>
			<form action="/bm/BmServlet" method="post" onsubmit="return logOut()">
				<button class="btnB" type="submit">ログアウト</button>
				<input type="hidden" name="action" value="logOut">
				<input type="hidden" name="id" value="${uID}">
			</form>
		</div>
	</nav>
	<article class="scrolle">
		<h1>書籍検索・一覧</h1>
		<form action="/bm/BmServlet" method="post">
			<button class="btnW" type="submit">マイページへ</button>
			<input type="hidden" name="action" value="toMypage">
			<input type="hidden" name="id" value="${uID}">
		</form>
		<section>
			<h2>検索</h2>
			<form action="/bm/BmServlet" method="post">
				<button class="btnB" type="submit">検索</button>
				<input type="hidden" name="action" value="bookSearch">
				<input type="hidden" name="id" value="${uID}">
			</form>
		</section>
		<section>
			<h2 class="center">あなたの本棚</h2>
			
			<form action="/bm/BmServlet" method="post">
				<button class="btnB" type="submit">書籍を追加</button>
				<input type="hidden" name="action" value="addBook">
				<input type="hidden" name="id" value="${uID}">
			</form>
							
			<form id="prev" action="/bm/BmServlet" method="post">
				<button class="btnW" type="submit">前へ</button>
				<input type="hidden" name="action" value="getPaged">
				<input type="hidden" name="id" value="${uID}">
				<input type="hidden" name="pageNum" value="${pageNum}">
				<input type="hidden" name="direction" value="0">
			</form>
			
			<form action="/bm/BmServlet" method="post">
				<button class="btnW" type="submit">次へ</button>
				<input type="hidden" name="action" value="getPaged">
				<input type="hidden" name="id" value="${uID}">
				<input type="hidden" name="pageNum" value="${pageNum}">
				<input type="hidden" name="direction" value="1">
			</form>
			
			<table>
	        	<caption></caption>
				<thead>
	            	<tr>
	                    <th scope="col">タイトル</th>
	                    <th scope="col">作者</th>
	                   　<th scope="col">出版社</th>
	                    <th scope="col">書籍詳細</th>
	                 </tr>
				</thead>
	            <tbody>
	            		<c:forEach var="bk" items="${books}">
							<form action="/bm/BmServlet" method="post">
	            				<tr>
			                    <td>${bk.title}</td>
			                    <td>${bk.author}</td>
			                    <td>${bk.publisher}</td>
			                    <td><button class="btnW" type="submit">詳細</button></td>
			                    
			                    <input type="hidden" name="action" value="getBookInfo">
								<input type="hidden" name="bookID" value="${bk.id}">
								<input type="hidden" name="userID" value="${bk.userID}">
								</tr>
							</form>
						</c:forEach>			
				</tbody>
			</table>
		</section>	
	</article>
	<div id="msg" data-message="${info}">	
	</div>
	<script>
		
		window.onload = function() {
			var element = document.getElementById("msg");
			var mess = element.dataset.message||"";
			if(mess == "first"){
				const element = document.querySelector('prev')
				element.remove()
			}		
		};

	</script>

</body>
</html>