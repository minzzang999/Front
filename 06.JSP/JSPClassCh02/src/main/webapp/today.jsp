<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%
	Calendar today = Calendar.getInstance();
	System.out.println(today.get(Calendar.YEAR));
%>
<!DOCTYPE html> 
	<html>
	<head>
		<title>오늘의 날짜</title> 
	</head>
	<body>
	오늘은 <%= today.get(Calendar.YEAR) %>년 
	<%= today.get(Calendar.MONTH) + 1 %>월
	<%= today.get(Calendar.DAY_OF_MONTH) %>일 입니다.<br/> 
	</body>
</htm>