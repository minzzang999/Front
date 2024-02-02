<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>로또 당첨번호 리스트</h2>
    <c:if test="${not empty lottoList}">
        <ul>
            <c:forEach var="lotto" items="${lottoList}">
                <li>${lotto.times}차 - ${lotto.num1}, ${lotto.num2}, ${lotto.num3}, ${lotto.num4}, ${lotto.num5}, ${lotto.num6} + <span>보너스 번호</span>${lotto.bonusNum}</li>
            </c:forEach>
        </ul>
    </c:if>

    <c:if test="${empty lottoList}">
        로또 번호가 존재하지 않습니다.
    </c:if>
</body>
</html>
