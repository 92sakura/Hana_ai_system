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
        <h2>商品マスタメンテ</h2>
        <table id="shohin_list">
            <tbody>
                <tr>
                    <th class="shohin_code">商品コード</th>
                    <th class="shohin_bun">分類</th>
                    <th class="shohin_name">商品名</th>
                    <th class="shohin_kana">商品名(カナ)</th>
                    <th class="shohin_tank">単価</th>
                    <th class="shohin_biko">備考</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="shohin" items="${shodisp}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${shohin.getHanaCode()}" /></td>
                        <td><c:out value="${shohin.getHanaBun()}" /></td>
                        <td><c:out value="${shohin.getHanaName()}" /></td>
                        <td><c:out value="${shohin.getHanaKana()}" /></td>
                        <td><c:out value="${shohin.getHanaTank()}" /></td>
                        <td><c:out value="${shohin.getHanaBiko()}" /></td>
                        <td>
                            <a href="<c:url value='/shohin/edit?cd=${shohin.getHanaCode()}&flg=${1}' />">編集  </a>
                            <a href="<c:url value='/shohin/destroy?cd=${shohin.getHanaCode()}&flg=${2}' />">削除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${shodisp_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((shodisp_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/shohin/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/shohin/new?flg=${0}' />">商品の登録</a></p>






		<p><a href="${pageContext.request.contextPath}/index.html">トップ頁に戻る</a></p>
	</c:param>
</c:import>