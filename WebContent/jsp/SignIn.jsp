<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Management</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sanitize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
    <article>
    <div class="center">
	    <img src="${pageContext.request.contextPath}/img/logo.jpg" alt="ロゴ画像">
    
        <h1>Sign In</h1>

        <form action="/bm/BmServlet" method="post" name="form">

            <p><label for="mail">メールアドレス</label></p>
            <input class="box" type="email" name="mail" id="mail" placeholder="Email">

            <p><label for="password">パスワード</label></p>
            <input class="box" type="password" name="password" id="password" placeholder="●●●●●●">

            <input class="button" type="submit" value="Sign in" id="button">
            <input type="hidden" name="action" value="SignIn">
        </form>

        <p class="link"><a href="${pageContext.request.contextPath}/jsp/SignUp.jsp">新しくアカウントを作成</a></p>
    </div>
	</article>
</body>
</html>