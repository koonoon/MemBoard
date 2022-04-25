<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 페이지</title>
</head>
<body>
<form action="boardWrite" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="bWriter"/></td>
		</tr>
			
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="bPassword"/></td>
			
		</tr>
		
		<tr>
			<th>제목</th>
			<td><input type="text" name="bTitle" size="38"/></td>
		</tr>
			
		<tr>
			<th>내용</th>
			<td><textarea rows="20" cols="40" name="bContents"></textarea></td>
		</tr>
		
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="bFile"></td>
		</tr>
		
			<tr>
				<td colspan="2">
				<input type="submit" value="등록"/>
				</td>
			</tr>
	</table>
	</form>
</body>
</html>