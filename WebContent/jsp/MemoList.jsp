<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>メモ一覧</title>
</head>
<body>
	<article>
				
		<form action="/bm/BmServlet" method="post">
		<button>マイページへ</button>
		<input type="hidden" name="action" value="toMypage">
		<input type="hidden" name="id" value="${uID}">
		</form>
	
		<p>aaaa ${uID}</p>
	
		<h2 class="center">あなたのメモ</h2>
		
		<form action="/bm/BmServlet" method="post">
		<button type="submit">メモを追加</button>
		<input type="hidden" name="action" value="addMemo">
		<input type="hidden" name="id" value="${uID}">
		</form>
		
				
		<form id="prev" action="/bm/BmServlet" method="post">
			<button type="submit">前へ</button>
			<input type="hidden" name="action" value="getPagedMemo">
			<input type="hidden" name="id" value="${uID}">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<input type="hidden" name="direction" value="0">
		</form>
		
		<form action="/bm/BmServlet" method="post">
			<button type="submit">次へ</button>
			<input type="hidden" name="action" value="getPagedMemo">
			<input type="hidden" name="id" value="${uID}">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<input type="hidden" name="direction" value="1">
		</form>
		

            		<c:forEach var="am" items="${aMemo}">
						<form action="/bm/BmServlet" method="post">
		                    <p>
		                    	${am.memo}
		                    	<button type="submit">詳細</button>
		                    </p>
		                    
		                    <input type="hidden" name="action" value="getBookInfo">
							<input type="hidden" name="bookID" value="${am.id}">
							<input type="hidden" name="userID" value="${am.userID}">
							</tr>
						</form>
					</c:forEach>			
	
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