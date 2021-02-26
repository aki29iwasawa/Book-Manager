<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/forward.css">
<title>Book Management</title>
</head>
<body>
	<div class="content">
		<div>
			<img class="logo" src="${pageContext.request.contextPath}/img/BMlogo.png" alt="ロゴ画像">
	    </div>
	    
		<div class="main">
			<div class="text">
				<h1>Book Manager</h1>
				<p class="link"><a href="/bm/jsp/SignIn.jsp">アカウントにサインイン</a></p>
				<p class="link"><a href="/bm/jsp/SignUp.jsp">新しくアカウントを作成</a></p>
			</div>
		</div>
		
		<div id="msg" data-message="${deleteMess}">	
		</div>
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