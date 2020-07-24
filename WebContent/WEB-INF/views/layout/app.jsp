<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>愛フラワー　花屋システム</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
		<div id="wrapper">
			<div id="header">
				<h1>愛フラワー　花屋システム
				<img src="<c:url value='/pic/APSPR_002.PNG' />" width="40" height="40" alt="ロゴ">
				</h1>
			</div>
			<div id="content">
				${param.content}
			</div>
			<div id="footer">
				by ai_flower
			</div>
		</div>
    </body>
</html>