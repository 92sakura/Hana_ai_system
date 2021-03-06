<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	function confirmDestroy() {
		if(confirm("本当に削除してよろしいですか？")) {
           			document.forms[0].submit();
		}
	}
</script>

<c:choose>
	<c:when test="${flg=='0' || shohin!=null}">
		<c:choose>
			<c:when test="${flg=='0'}">
				<h2>商品の登録</h2>
			</c:when>
			<c:when test="${flg=='1'}">
				<h2>商品の編集</h2>
			</c:when>
			<c:when test="${flg=='2'}">
				<h2>商品の削除</h2>
			</c:when>
		</c:choose>
		<table>
			<tbody>
				<tr>
					<th>商品コード<span class= "validation"> (半角4桁) </span></th>
					<td>
						<c:choose>
							<c:when test="${flg=='0'}">
								<input type="text" name="code" value="${shohin.getHanaCode()}" />
							</c:when>
							<c:otherwise>
								<input type="text" name="code" value="${shohin.getHanaCode()}" readonly>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<th>分類</th>
					<td><c:choose>
							<c:when test="${flg=='2'}">
								<c:out value="${shohin.getHanaBun()}" />
							</c:when>
							<c:otherwise>
								<select name="bun">
									<option value="A" <c:out value="${shohin.getHanaBun()}" /> >A</option>
									<option value="B" <c:out value="${shohin.getHanaBun()}" /> >B</option>
									<option value="C" <c:out value="${shohin.getHanaBun()}" /> >C</option>
									<option value="D" <c:out value="${shohin.getHanaBun()}" /> >D</option>
									<option value="E" <c:out value="${shohin.getHanaBun()}" /> >E</option>
								</select>
<!--<input type="text" name="bun" value="${shohin.getHanaBun()}" />-->
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<th>商品名<span class= "validation"> (全角20桁) </span></th>
					<td><c:choose>
							<c:when test="${flg=='2'}">
								<c:out value="${shohin.getHanaName()}" />
							</c:when>
							<c:otherwise>
								<input type="text" name="name" value="${shohin.getHanaName()}" />
							</c:otherwise>
						</c:choose></td>
				<tr>
					<th>商品名（カナ）<span class= "validation"> (半角20桁) </span></th>
					<td><c:choose>
							<c:when test="${flg=='2'}">
								<c:out value="${shohin.getHanaKana()}" />
							</c:when>
							<c:otherwise>
								<input type="text" name="kana" value="${shohin.getHanaKana()}" />
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<th>単価</th>
					<td><c:choose>
							<c:when test="${flg=='2'}">
								<c:out value="${shohin.getHanaTank()}" />
							</c:when>
							<c:otherwise>
								<input type="text" name="tank" value="${shohin.getHanaTank()}" />
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<th>備考<span class= "validation"> (全角40桁) </span></th>
					<td><c:choose>
							<c:when test="${flg=='2'}">
								<c:out value="${shohin.getHanaBiko()}" />
							</c:when>
							<c:otherwise>
								<textarea name="biko" rows="5" cols="50">${shohin.getHanaBiko()} </textarea>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<h2>商品マスタ データエラー</h2>
	</c:otherwise>
</c:choose>
<input type="hidden" name="_token" value="${_token}" />
<br>
<c:choose>
	<c:when test="${flg=='0'}">
		<input type="button" value="登録" onclick="submit();">
	</c:when>
		<c:when test="${flg=='1'}">
		<input type="button" value="更新" onclick="submit();">
	</c:when>
		<c:when test="${flg=='2'}">
		<input type="button" onclick="confirmDestroy();" value="削除" >
	</c:when>

</c:choose>



