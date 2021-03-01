<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Management</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/front.css">
</head>
<body>
	<div class="content">
		<div class="mainLogo">
			<img class="logo" src="${pageContext.request.contextPath}/img/logoW.png" alt="ロゴ画像">
	    </div>
	    
		<div class="main">
			<div class="text">
				<img class="logo" src="${pageContext.request.contextPath}/img/logoB.png" alt="ロゴ画像">
				<h1>Sign In</h1>
					<form action="/bm/BmServlet" method="post" name="form">
            			<p><label for="mail">メールアドレス</label></p>
            			<input class="input-text" type="email" name="mail" id="mail" placeholder="Email">
			
			            <p><label for="password">パスワード</label></p>
			            <input class="input-text" type="password" name="password" id="password" placeholder="●●●●●●">
			
			            <p><input class="btn btn-B" type="submit" value="Sign in" id="button"></p>
			            <input type="hidden" name="action" value="SignIn">
        			</form>

					<p><a class="btn" href="${pageContext.request.contextPath}/jsp/SignUp.jsp">新しくアカウントを作成</a></p>
			</div>
		</div>
	</div>
</body>
</html>