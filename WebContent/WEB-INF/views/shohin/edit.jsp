<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
		<c:if test="${errors != null}">
    		<div id="flush_error">
        	<c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        	</c:forEach>
    		</div>
		</c:if>
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>

        <c:choose>
            <c:when test="${shohin != null}">
                <form method="POST" action="<c:url value='/shohin/update' />">
                    <c:import url="_form.jsp" />
                </form>
            </c:when>
            <c:otherwise>
                <h2>商品マスタ　データエラー</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/shohin/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>