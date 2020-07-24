<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="code">商品コード</label><br />
<input type="text" name="code" value="${shohin.getHanaCode()}" />
<br /><br />

<label for="bun">分類</label><br />
<input type="text" name="bun" value="${shohin.getHanaBun()}" />
<br /><br />

<label for="name">商品名</label><br />
<input type="text" name="name" value="${shohin.getHanaName()}" />
<br /><br />

<label for="kana">商品名（カナ）</label><br />
<input type="text" name="kana" value="${shohin.getHanaKana()}" />
<br /><br />

<label for="tank">単価</label><br />
<input type="text" name="tank" value="${shohin.getHanaTank()}" />
<br /><br />

<label for="biko">備考</label><br />
<textarea name="biko" rows="5" cols="50">${shohin.getHanaBiko()} </textarea>
<br /><br />


<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>