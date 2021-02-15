<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>書籍を検索</title>
</head>
<body>
	<article>
	
		<p>aaaa ${uID}</p>
	
		<h2 class="center">あなたの本棚</h2>
		
		<form action="/bm/BmServlet" method="post">
		<button type="submit">書籍を追加</button>
		<input type="hidden" name="action" value="addBook">
		<input type="hidden" name="id" value="${uInfo.id}">
		</form>
		
				
		<form>
			<button type="submit">前へ</button>
			<input type="hidden" name="action" value="getPaged">
			<input type="hidden" name="id" value="${uInfo.id}">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<input type="hidden" name="direction" value="0">
		</form>
		
		<form>
			<button type="submit">次へ</button>
			<input type="hidden" name="action" value="getPaged">
			<input type="hidden" name="id" value="${uInfo.id}">
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
		                    <td><button type="submit">詳細</button></td>
		                    
		                    <input type="hidden" name="action" value="getBookInfo">
							<input type="hidden" name="bookID" value="${bk.id}">
							<input type="hidden" name="userID" value="${bk.userID}">
							</tr>
						</form>
					</c:forEach>			
			</tbody>
		</table>

	
	
	</article>

</body>
</html>