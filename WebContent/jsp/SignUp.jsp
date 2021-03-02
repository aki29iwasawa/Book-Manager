<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/front.css">
</head>
<body>
		<div class="mainLogo">
			<img class="logo" src="${pageContext.request.contextPath}/img/logoW.png" alt="ロゴ画像">
	    </div>
	    
		<article>
			<div class="text">
				<img class="logo" src="${pageContext.request.contextPath}/img/logoB.png" alt="ロゴ画像">
				<h1>Sign UP</h1>
					<form action="/bm/BmServlet" method="post" name="form">
            			<p><label for="mail">アカウントID</label></p>
            			<input class="input-text" type="email" name="mail" id="mail" placeholder="Email">
			
			            <p><label for="password">パスワード</label></p>
			            <input class="input-text" type="password" name="password" id="password" placeholder="●●●●●●">
			
						<p><button class="btnB" type="submit" id="button">Sign Up</button></p>
			            <input type="hidden" name="action" value="SignUn">
        			</form>
					<p><a class="btnW" href="${pageContext.request.contextPath}/jsp/SignIn.jsp">既存アカウントにサインイン</a></p>
        			<p><a class="btnW" href="${pageContext.request.contextPath}/WEB-INF/jsp/FrontBm.jsp">トップへ戻る</a></p>
			</div>
		</article>
</body>
</html>
