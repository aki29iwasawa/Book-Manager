<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>書籍詳細情報</title>
</head>
<body>
	<article>
		<h1>書籍詳細情報</h1>
		<p>${BookInfo.id}</p>
		<p>${BookInfo.title}</p>
		<p>${BookInfo.author}</p>
		<p>${BookInfo.publisher}</p>
		
		<form action="/bm/BmServlet" method="post" name="form" onsubmit="return deleteCheck();">
		<button type="submit">削除</button>		
		<input type="hidden" name="action" value="deleteBook">
		<input type="hidden" name="bookID" value="${BookInfo.id}">
		<input type="hidden" name="userID" value="${BookInfo.userID}">
		</form>
				
		<form action="/bm/BmServlet" method="post" name="form">
		<button type="submit">編集</button>		
		<input type="hidden" name="action" value="editBookInfo">
		<input type="hidden" name="bookID" value="${BookInfo.id}">
		<input type="hidden" name="userID" value="${BookInfo.userID}">
		
		</form>
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