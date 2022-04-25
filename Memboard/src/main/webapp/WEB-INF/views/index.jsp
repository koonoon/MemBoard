<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberBoard</title>
</head>
<body>

	<button onclick="location.href='joinForm'">회원가입</button>
	<input type="button" onclick="location.href='memberList'" value="회원목록">
	
	<c:choose>
		<c:when test="${not empty loginId}">
			<!-- 로그아웃 -->
			<button onclick="location.href='logout'">로그아웃</button>
		</c:when>
		
		<c:otherwise>
			<!-- 로그인 페이지로 이동 -->
			<button onclick="location.href='loginForm'">로그인</button>
		</c:otherwise>
	</c:choose>
	
	<button onclick="location.href='writeForm'">게시글 작성</button>
	<button onclick="location.href='boardList'">게시글 목록</button>
	<button onclick="location.href='pagingList'">페이징 목록</button>

	
	<h3>로그인ID : ${loginId}</h3>
	
</body>

<script>
	function mList(){
		location.href='mList';
	}
</script>
</html>