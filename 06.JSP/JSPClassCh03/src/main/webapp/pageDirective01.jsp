<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- page 지시자 (@가 붙는형태)는 현재 JSP 페이지에 대한 설정하는 곳 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int sum = 0;
	for(int i = 0; i<= 100; i++){
		sum += i;
	}
%>
	1~100 합 : <%= sum %>
</body>
</html>