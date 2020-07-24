<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${shohin != null}">
                <h2>商品の詳細</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>コード</th>
                            <td><c:out value="${shohin.getHanaCode()}" /></td>
                        </tr>
                        <tr>
                            <th>分類</th>
                            <td><c:out value="${shohin.getHanaBun()}" /></td>
                        </tr>
                        <tr>
                            <th>商品名</th>
                            <td>
                                <c:out value="${shohin.getHanaName()}" />
                            </td>
                        </tr>
                        <tr>
                            <th>商品名（カナ）</th>
                            <td>
                                <c:out value="${shohin.getHanaKana()}" />
                            </td>
                        </tr>
                        <tr>
                            <th>単価</th>
                            <td>
                                <c:out value="${shohin.getHanaTank()}" />
                            </td>
                        </tr>
                        <tr>
                            <th>備考</th>
                            <td>
                                <c:out value="${shohin.getHanaBiko()}" />
                            </td>
                        </tr>
                    </tbody>
                </table>

                    <p><a href="<c:url value="/shohin/edit?id=${shohin.getHanaCode()}" />">この商品を編集する</a></p>

            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/shohin/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>