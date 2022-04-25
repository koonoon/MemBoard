<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<c:forEach var="boardList" items="${boardList}">
					<tr>
						<td>${boardList.bNum}</td>
						<td><a href="boardView?bNum=${boardList.bNum}">${boardList.bTitle}</a></td>
						<td>${boardList.bWriter}</td>
						<td>${boardList.bDate}</td>
						<td>${boardList.bHit}</td>
					</tr>
				</c:forEach>
		</tbody>
</table>
</body>
</html>