<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
		<input type="hidden" name="id" value="${am.userID}">
		</form>
	
		<h2 class="center">アカウントメモ</h2>
		
		<form action="/bm/BmServlet" method="post">
		<button type="submit">新規メモを追加</button>
		<input type="hidden" name="action" value="addMemo">
		<input type="hidden" name="id" value="${am.userID}">
		</form>
		
				
		<form id="prev" action="/bm/BmServlet" method="post">
			<button type="submit">前へ</button>
			<input type="hidden" name="action" value="getPagedMemo">
			<input type="hidden" name="id" value="${am.userID}">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<input type="hidden" name="direction" value="0">
		</form>
		
		<form action="/bm/BmServlet" method="post">
			<button type="submit">次へ</button>
			<input type="hidden" name="action" value="getPagedMemo">
			<input type="hidden" name="id" value="${am.userID}">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<input type="hidden" name="direction" value="1">
		</form>
		
		<c:forEach var="memo" items="${aMemo}">
			<p>${memo.memo}</p>
		</c:forEach>
			
		<table>
        	<caption></caption>
			<thead>
            	<tr>
                    <th scope="col">ID</th>
                    <th scope="col">memo</th>
                   　<th scope="col">作成日</th>
                    <th scope="col">更新日</th>
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
		                    <td><button type="submit">詳細</button></td>
		                    
		                    <input type="hidden" name="action" value="getMemoInfo">
							<input type="hidden" name="bookID" value="${am.memoID}">
							<input type="hidden" name="userID" value="${am.userID}">
							</tr>
						</form>
					</c:forEach>			
			</tbody>
		</table>
 
	
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