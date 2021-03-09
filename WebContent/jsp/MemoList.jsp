<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>メモ一覧</title>
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
						<input type="hidden" name="id" value="${am.userID}">
					</form>
				</li>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">新しくメモを追加</button>
						<input type="hidden" name="action" value="addMemo">
						<input type="hidden" name="id" value="${am.userID}">
					</form>
				</li>
				<li>
					<form action="/bm/BmServlet" method="post">
						<button class="btnW" type="submit">書籍を追加</button>
						<input type="hidden" name="action" value="addBook">
						<input type="hidden" name="id" value="${am.userID}">
					</form>			
				</li>
			</ul>
			<form action="/bm/BmServlet" method="post" onsubmit="return logOut()">
				<button class="btnB" type="submit">ログアウト</button>
				<input type="hidden" name="action" value="logOut">
				<input type="hidden" name="id" value="${am.userID}">
			</form>
		</div>
	</nav>
	<article class="scrolle">
		<h1 class="center">アカウントメモ</h1>
		<form action="/bm/BmServlet" method="post">
			<button class="btnW">マイページへ</button>
			<input type="hidden" name="action" value="toMypage">
			<input type="hidden" name="id" value="${am.userID}">
		</form>
		<section>
			<form action="/bm/BmServlet" method="post">
				<button class="btnB" type="submit">新規メモを追加</button>
				<input type="hidden" name="action" value="addMemo">
				<input type="hidden" name="id" value="${am.userID}">
			</form>
			
					
			<form id="prev" action="/bm/BmServlet" method="post">
				<button class="btnW" type="submit">前へ</button>
				<input type="hidden" name="action" value="getPagedMemo">
				<input type="hidden" name="id" value="${am.userID}">
				<input type="hidden" name="pageNum" value="${pageNum}">
				<input type="hidden" name="direction" value="0">
			</form>
			
			<form action="/bm/BmServlet" method="post">
				<button class="btnW" type="submit">次へ</button>
				<input type="hidden" name="action" value="getPagedMemo">
				<input type="hidden" name="id" value="${am.userID}">
				<input type="hidden" name="pageNum" value="${pageNum}">
				<input type="hidden" name="direction" value="1">
			</form>
				
			<table>
	        	<caption></caption>
				<thead>
	            	<tr>
	                    <th scope="col">ID</th>
	                    <th scope="col">memo</th>
	                   　<th scope="col">作成日</th>
	                    <th scope="col">更新日</th>
	                    <th scope="col">詳細</th>	                    
	                 </tr>
				</thead>
	            <tbody>
	            		<c:forEach var="am" items="${aMemo}">
							<form action="/bm/BmServlet" method="post">
	            				<tr>
			                    <td>${am.memoID}</td>
			                    <td>${am.memo}</td>
			                    <td>${am.create}</td>
			                    <td>${am.update}</td>
			                    <td><button class="btnW" type="submit">詳細</button></td>
			                    
			                    <input type="hidden" name="action" value="getMemoInfo">
								<input type="hidden" name="bookID" value="${am.memoID}">
								<input type="hidden" name="userID" value="${am.userID}">
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