<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jspstudych03.vo.LottoNum" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<LottoNum> lottoList = (ArrayList<LottoNum>) request.getAttribute("lottoList");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>로또 당첨번호 리스트 - 스크립틀릿</h2>
<%
    if(!lottoList.isEmpty()) {
%>
    <ul>
    <% // for (int i = 0; i < lottoList.size(); i++) {
        for(LottoNum lotto : lottoList) {
        // LottoNum lotto = lottoList.get(i);
    %>
        <li>
            <%= lotto.getTimes() %>차 - <%= lotto.getNum1() %>, <%= lotto.getNum2() %>,
            <%= lotto.getNum3() %>, <%= lotto.getNum4() %>, <%= lotto.getNum5() %>,
            <%= lotto.getNum6() %> + <span>보너스 번호</span><%= lotto.getBonusNum() %>
        </li>
    <% } %>
    </ul>
<%
    }
%>
<%
    if(lottoList.isEmpty()) {
%>
    로또 번호가 존재하지 않습니다.
<%
    }
%>
</body>
</html>
