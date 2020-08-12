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
		<div id="header">
			<h1>愛フラワー　花屋システム
				<img src="<c:url value='/pic/APSPR_002.PNG' />" width="40" height="40" alt="ロゴ" id="cmp">
			</h1>
		</div>
		<div id = "popup" style = "visibility: hidden">
			<span>連絡先：999-999-9999</span>
			<!--<span>ＵＲＬ：999-999-9999</span>-->
		</div>
		<div id="content">
			${param.content}
		</div>
		<div id="footer">
			by ai_flower
		</div>
    </body>
    <script>
    var div = document.getElementById("cmp");
    div.addEventListener("mouseover",function(e) {
        var popup = document.getElementById("popup");
        popup.style="visibility: show"
    })
    div.addEventListener("mouseout",function(e) {
        var popup = document.getElementById("popup");
        popup.style="visibility: hidden"
    })
</script>
</html>