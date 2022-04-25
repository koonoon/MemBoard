<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정 페이지</title>
</head>
<body>
	<h1>회원수정 페이지</h1>
	
	<form action="memberModify" method="POST">
	
	아이디 : ${modi.fId}<br/>
	<input type="hidden" name="fId" value="${modi.fId}">
	비밀번호 : <input type="password" name="fPw"/> <br/>
	이름 : <input type="text" name="fName" placeholder="${modi.fName}"/> <br/>
	생년월일 : <input type="date" name="fBirth"/> <br/>
	성별 : 남자<input type="radio" name="fGender" value="남"/> 
		  여자<input type="radio" name="fGender" value="여"/> <br/>
	연락처 : <input type="text" name="fPhone"/> <br/>
	주소 : <input type="text" name="fAddr"/> <br/>
	이메일 : <input type="email" name="fEmail" placeholder="${modi.fEmail}"/> <br/>
	
	<input type="submit" value="수정"/>
	<input type="reset" value="다시작성"/>
	
	</form>
	
</body>
</html>