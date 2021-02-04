<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/SignIn.css">
</head>
<body>
    <article>
    <div class="center">
	    <img src="${pageContext.request.contextPath}/img/logo.jpg" alt="ロゴ画像">
    
        <h1>Sign Up</h1>

        <form action="/bm/BmServlet" method="post" name="form">

            <p><label for="mail">アカウントID</label></p>
            <input class="box" type="email" name="mail" id="mail" placeholder="Email">

            <p><label for="password">パスワード</label></p>
            <input class="box" type="password" name="password" id="password" placeholder="●●●●●●">

            <input class="button" type="submit" value="Sign Up" id="button">
            
            <input type="hidden" name="action" value="SignUp">
        </form>
    </div>
	</article>
</body>
</html>