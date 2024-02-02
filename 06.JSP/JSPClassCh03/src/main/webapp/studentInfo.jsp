<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="com.jspstudych03.vo.Student" %>
<%
	Student s2 = new Student("어머나", 33, "여자");
	
	pageContext.forward("studentInfoResult.jsp");
%>
이름<%= s2.getName() %>
