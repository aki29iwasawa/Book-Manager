<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Management</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/front.css">
</head>
<body>

		<div class="mainLogo">
			<img  class="logo" src="${pageContext.request.contextPath}/img/logoW.png" alt="ロゴ画像">
	    </div>
	    
		<article>
			<div class="text">
				<img class="logo" src="${pageContext.request.contextPath}/img/logoB.png" alt="ロゴ画像">
				<h1>Book<br>Management</h1>
				<p><a class="btnW" href="/bm/jsp/SignIn.jsp">アカウントにサインイン</a></p>
				<p><a class="btnW" href="/bm/jsp/SignUp.jsp">新しくアカウントを作成</a></p>
			</div>
		</article>
		
		<div id="msg" data-message="${deleteMess}">	
		</div>

	
	
	<script>
		window.onload = function() {
			var element = document.getElementById("msg");
			var mess = element.dataset.message||"";
			if(mess != ""){
				alert(mess);
			}		
		};
	</script>

</body>
</html>