<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 기본 정보 입력 폼</title>
</head>
<body>
	<h2>회원 기본 정보 입력</h2>	
	<!-- form 태그의 method 속성을 지정하지 않으면 GET 방식 요청이 된다. -->
	<form name="fMember1" action="formData01" >
		<p>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름 : 
			<input type="text" name="name" /></p>
		<p>아&nbsp;&nbsp;이&nbsp;&nbsp;디 : 
			<input type="text" name="id" /></p>
		<p>비밀번호 : <input type="password" name="pass" /></p>		
		<!-- 라디오 버튼은 name 속성의 값을 동일하게 지정해야 그룹으로 묶인다. -->
		<p>성&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;별 :
			<input type="radio" name="gender" value="male"/>남&nbsp;&nbsp;&nbsp;
			<input type="radio" name="gender" value="female"/>여</p>		
		<!-- 
			체크박스는 name 속성의 값을  각각 지정할 수도 있고
			동일하게 지정할 수도 있다.
		-->
		<p>메일수신 :
			<input type="checkbox" name="nMail"/>
				공지메일 받음&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="aMail"/>
				광고메일 받음&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="iMail"/>
				정보메일 받음&nbsp;&nbsp;&nbsp;</p>		
		<!-- 
			<option> 태그에 value 속성을 지정하지 않으면 
			<option> 태그로 감싼 문자열이 value가 된다.
		-->
		<p>직&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;업 :	
			<select name="job">
				<option>회사원</option>
				<option>학생</option>
				<option>주부</option>
				<option>기타</option>
			</select></p>			
		<!-- 
			submit 버튼이 클릭되면 form 태그의 action 속성에서 
			지정한 URL로 무조건 폼 데이터를 전송한다.
		-->
		<p><input type="reset" value="다시쓰기" />
		<input type="submit" value="가입하기" /></p>
	</form>
</body>
</html>