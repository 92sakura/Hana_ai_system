<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
		<c:if test="${errors != null}">
    		<div id="flush_error">
        		<c:out value="${errors}" />
    		</div>
		</c:if>
		<c:if test="${flush_new != null}">
            <div id="flush_success">
                <c:out value="${flush_new}"></c:out>
            </div>
        </c:if>
        <form method="POST" action="<c:url value='/shohin/create' />">
            <c:import url="_form.jsp" />
        </form>
	<input type="hidden" name="_token" value="${_token}" />
    <p><a href="<c:url value="/shohin/index" />">一覧に戻る</a></p>
</c:param>
</c:import>
