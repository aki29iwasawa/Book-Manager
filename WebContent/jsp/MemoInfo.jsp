<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>メモ詳細</title>
</head>
<body>
	<article>	
		<h1>メモ</h1>
		
		<form action="/bm/BmServlet" method="post">
		<button>マイページへ</button>
		<input type="hidden" name="action" value="toMypage">
		<input type="hidden" name="id" value="${MemoInfo.userID}">
		</form>
		
		<p>${MemoInfo.memoID}</p>
		<p>${MemoInfo.memo}</p>
		<p>${MemoInfo.create}</p>
		<p>${MemoInfo.update}</p>
		<p>${MemoInfo.userID}</p>
		
		<form action="/bm/BmServlet" method="post" name="form" onsubmit="return deleteCheck()">
		<button type="submit">削除</button>		
		<input type="hidden" name="action" value="deleteBook">
		<input type="hidden" name="bookID" value="${MemoInfo.memoID}">
		<input type="hidden" name="userID" value="${MemoInfo.userID}">
		</form>
				
		<form action="/bm/BmServlet" method="post" name="form">
		<button type="submit">編集</button>		
		<input type="hidden" name="action" value="editBook">
		<input type="hidden" name="bookID" value="${MemoInfo.memoID}">
		<input type="hidden" name="userID" value="${MemoInfo.userID}">
		
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