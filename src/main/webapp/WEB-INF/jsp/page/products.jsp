<%-- Created by: Denys Filatov--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
    <c:forEach var="p" items="${products}">
        <h2>${fn:toUpperCase(p.name)}</h2>
        <fmt:formatNumber value="${p.price}" type="currency" currencyCode="USD"/>
        <fmt:formatDate value="${p.created}" pattern="yyyy-MM-dd"/>
        <fmt:formatDate value="${p.created}" dateStyle="long" type="date"/>
    </c:forEach>
</body>
</html>
