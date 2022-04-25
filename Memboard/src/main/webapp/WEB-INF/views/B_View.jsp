<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
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
	<caption>${view.bNum}번 게시글정보</caption>
	
	<tr>
	<th>작성자</th>
	<td>${view.bWriter}</td>
	</tr>
	
	<tr>
	<th>비밀번호</th>
	<td>${view.bPassword}</td>
	</tr>
	
	<tr>
	<th>제목</th>
	<td>${view.bTitle}</td>
	</tr>
	
	<tr>
	<th>내용</th>
	<td>${view.bContents}</td>
	</tr>
	
	<tr>
	<th>조회수</th>
	<td>${view.bHit}</td>
	</tr>
	
	<tr>
	<th>첨부파일</th>
	<td><img src="resources/fileUpload/${view.bFileName}" width="200px">
	</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<button onclick="boardModify()">수정</button>
			<button onclick="boardDelete(${view.bNum},${view.bPassword})">삭제</button>
		</td>
	
	</tr>
	
				
	</table>
</body>

<script>
	function boardModify(){
		// 비밀번호를 입력받아서 게시글의 비밀번호와 비교한 후 
		// 일치하면 게시글 번호를 Controller로 넘긴다.
		// 일치하지 않으면 아무런 작업도 하지 않는다. 
		
		// 게시글 번호, 게시글 비밀번호, 입력하는 비밀번호
		let bNum = ${view.bNum};
		let bPassword = ${view.bPassword};
		
		let pw = prompt('비밀번호를 입력해주세요.');
		
		if(bPassword==pw){
			location.href="modiForm?bNum="+bNum;
		} else{
			alert('비밀번호가 일치하지 않습니다!')
		}
		
	}
	
	function boardDelete(bNum,bPassword){
		// 게시글 번호, 게시글 비밀번호, 입력하는 비밀번호
		
		console.log("bNum : " + bNum);
		console.log("bPassword : " + bPassword);
		
		let pw = prompt('비밀번호를 입력해주세요.');
		
		if(bPassword==pw){
			location.href="boardDelete?bNum="+bNum;
		} else{
			alert('비밀번호가 일치하지 않습니다!')
		}
	}
	


</script>




</html>