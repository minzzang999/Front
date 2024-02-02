<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--jsp주석 지시자(Drective) page 지시자 --%>
    <%@ page import = "java.util.*" %>
    <%--! 붙으면 선언부 - 현재 페이지 전체에서 사용하는 전역변수, 메서드 정의하기 위해서 --%>
    <%! %> 
    <%
  		//스크립틀릿(Scriptlet) - 자바 코드를 작성하는 곳 
	    int sum = 0;
	    for(int i = 1; i <= 10; i++) {
	    sum += i; 
	    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 jsp이다!</h1>
	<%-- = 붙으면 표현식(Expression) --%>
	<%= sum %><br>
	<%
		//스크립틀릿(Scriptlet) - 자바 코드를 작성하는 곳 
		for(int i = 0; i <= 10; i++){
	%>
		<%= i %><br>
	<%
		}
	
		sum = 100;
	%>
	sum: <%= sum %>
</body>
</html>