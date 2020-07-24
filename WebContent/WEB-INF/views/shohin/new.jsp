<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:import url="../layout/app.jsp">
	<c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>商品マスタ　新規登録</h2>

        <form method="POST" action="<c:url value='/shohin/create' />">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="<c:url value='/shohin/index' />">一覧に戻る</a></p>

	</c:param>
</c:import>