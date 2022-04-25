<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
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
	<caption>${view.fId}님 회원정보</caption>
	<tr>
	<th>아이디</th>
	<td>${view.fId}</td>
	</tr>
	
	<tr>
	<th>비밀번호</th>
	<td>${view.fPw}</td>
	</tr>
	
	<tr>
	<th>이름</th>
	<td>${view.fName}</td>
	</tr>
	
	<tr>
	<th>생년월일</th>
	<td>${view.fBirth}</td>
	</tr>
	
	<tr>
	<th>성별</th>
	<td>${view.fGen}</td>
	</tr>
	
	<tr>
	<th>연락처</th>
	<td>${view.fPhone}</td>
	</tr>
	
	<tr>
	<th>주소</th>
	<td>${view.fAddr}</td>
	</tr>
	
	<tr>
	<th>이메일</th>
	<td>${view.fEmail}</td>
	</tr>
				
	</table>
</body>
</html>