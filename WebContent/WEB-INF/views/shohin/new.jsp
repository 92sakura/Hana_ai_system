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
		<c:if test="${errors != null}">
    		<div id="flush_error">
        		登録済みの商品コードです。<br />
        	<c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        	</c:forEach>
    		</div>
		</c:if>
        <c:choose>
            <c:when test="${shohin != null}">
                <form onsubmit="return false;" method="POST" action="<c:url value='/shohin/create' />">
                    <c:import url="_form.jsp" />
                </form>
            </c:when>
            <c:otherwise>
                <h2>商品マスタ　データエラー</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/shohin/index' />">一覧に戻る</a></p>

	</c:param>
</c:import>