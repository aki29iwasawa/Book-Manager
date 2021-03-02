<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mypage.css">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<ul>
			<li>アカウント情報</li>
			<li>メモ一覧</li>
			<li>書籍一覧</li>
		</ul>
	</nav>
	<article id="scrolle">
		<h1>マイページ</h1>
		
		<h2 class="center">アカウント情報</h2>
		<p>${mess}</p>
		
		<form action="/bm/BmServlet" method="post">
		<button class="btnW" type="submit">アカウント情報の編集・削除</button>
		<input type="hidden" name="action" value="toEditUserPage">
		<input type="hidden" name="id" value="${uInfo.id}">
		</form>
		
		<form action="/bm/BmServlet" method="post" onsubmit="return logOut()">
		<button class="btnB" type="submit">ログアウト</button>
		<input type="hidden" name="action" value="logOut">
		<input type="hidden" name="id" value="${uInfo.id}">
		</form>
		
		<p>ユーザーID</p>
		<p>${uInfo.id}</p>
		<p>メールアドレス</p>
		<p>${uInfo.mail}</p>
		
		<h2 class="center">新規メモ</h2>
		
		<form action="/bm/BmServlet" method="post">
		<button class="btnW" type="submit">新しくメモを追加</button>
		<input type="hidden" name="action" value="addMemo">
		<input type="hidden" name="id" value="${uInfo.id}">
		</form>
		
		<c:forEach var="memo" items="${aMemo}">
			<p>${memo.memo}</p>
		</c:forEach>
		
		<form action="/bm/BmServlet" method="post">
		<button class="btnB" type="submit">全てのメモを見る</button>
		<input type="hidden" name="action" value="memoList">
		<input type="hidden" name="id" value="${uInfo.id}">
		</form>

		
		<h2 class="center">最近追加した本</h2>
		
		<form action="/bm/BmServlet" method="post">
		<button class="btnW" type="submit">書籍を追加</button>
		<input type="hidden" name="action" value="addBook">
		<input type="hidden" name="id" value="${uInfo.id}">
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
		
				
		<form action="/bm/BmServlet" method="post">
		<button class="btnB" type="submit">もっと見る<br>書籍一覧・検索画面へ</button>
		<input type="hidden" name="action" value="bookList">
		<input type="hidden" name="id" value="${uInfo.id}">
		</form>		
	
	</article>
	<div id="msg" data-message="${aMess}">	
	</div>
	<script>
		window.onload = function() {
			var element = document.getElementById("msg");
			var mess = element.dataset.message||"";
			if(mess != ""){
				alert(mess);
			}		
		};
		
		function logOut(){
			var result = window.confirm("ログアウトしてトップページに戻ります");
	    	
	    	if(result){
	    		document.form.submit();
	    	}else{
	    		return false;
	    	}
		}
	</script>
</body>
</html>