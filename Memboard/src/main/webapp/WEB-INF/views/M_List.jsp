<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<style>
	table,tr,td,th{
	 	border : 1px solid;
	 	border-collapse : collapse;
	 	padding : 10px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var="memberList" items="${memberList}">
		<tr>
			<td><a href="memberView?fId=${memberList.fId}">${memberList.fId}</a></td>
			<td>${memberList.fName}</td>
			<td>${memberList.fBirth}</td>
			<td><button type="button" class="btn btn-success rounded-pill" onclick="location.href='memberModiForm?fId=${memberList.fId}'">수정</button></td>
			<td><button type="button" class="btn btn-danger rounded-pill" onclick="memDel('${memberList.fId}')">삭제</button></td>
		</tr>
		</c:forEach>
	</table>
	
</body>


</html>