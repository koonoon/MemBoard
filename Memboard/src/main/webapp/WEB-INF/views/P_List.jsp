<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 페이징 처리 페이지</title>
<style>
	table,th,td,th{
		border : 1px solid;
		border-collapse : collapse;
		padding : 3px;
	}
</style>
</head>
<body>
<!-- 게시판 번호, 제목, 작성자, 작성일, 조회수 -->
<form action="pagingList" method="get">
	<p>한 페이지에 출력할 게시글 갯수</p>
	<c:if test="${paging.limit==3}">
	<select name="limit">
		<option value="3" selected>3</option>
		<option value="5">5</option>
		<option value="10">10</option>
	</select>
	</c:if>
	
	<c:if test="${paging.limit==5}">
	<select name="limit">
		<option value="3">3</option>
		<option value="5" selected>5</option>
		<option value="10">10</option>
	</select>
	</c:if>
	
	
	<c:if test="${paging.limit==10}">
	<select name="limit">
		<option value="3">3</option>
		<option value="5">5</option>
		<option value="10" selected>10</option>
	</select>
	</c:if>
	
	<input type="submit" value="선택"/>
</form>

<table>
		<thead>
			<tr>
				<th>게시판 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pl" items="${plist}">
					<tr>
						<td>${pl.bNum}</td>
						<td><a href="boardView?bNum=${pl.bNum}">${pl.bTitle}</a></td>
						<td>${pl.bWriter}</td>
						<td>${pl.bDate}</td>
						<td>${pl.bHit}</td>
					</tr>
				</c:forEach>
		</tbody>
</table>

<!-- 페이징 처리 -->
	<!-- [이전]페이지로 에 대한 페이징 처리 -->
	<c:if test="${paging.page <= 1}">[이전] </c:if>
	<c:if test="${paging.page > 1}">
		<a href="pagingList?page=${paging.page-1}&limit=${paging.limit}">[이전] </a>
	</c:if>


	<!-- [페이지번호]에 대한 페이징 처리 -->
	<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}"
		step="1">
		<c:choose>

			<c:when test="${paging.page eq i}"> [${i}] </c:when>

			<c:otherwise>
				<a href="pagingList?page=${i}&limit=${paging.limit}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>


	<!-- [다음]페이지로 에 대한 페이징 처리 -->
	<c:if test="${paging.page >= paging.maxPage}"> [다음]</c:if>
	<c:if test="${paging.page < paging.maxPage}">
		<a href="pagingList?page=${paging.page+1}&limit=${paging.limit}"> [다음]</a>
	</c:if>
</body>
</html>