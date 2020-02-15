<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--
  ~ Created with IntelliJ IDEA Ultimate.
  ~ Copyright (c) 2019. All Rights Reserved
  ~ Unauthorized copying of error404.jsp, via any medium is strictly prohibited
  ~ Proprietary and confidential
  ~ Written by MB-Development (Kalimath), Month Year
  --%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="addon" value=" - error 404"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Beauty Care +"/>
</jsp:include>
<main>
    <jsp:include page="errorHeader.jsp">
        <jsp:param name="message" value="pagina bestaat niet"/>
    </jsp:include>
</main>
</body>
</html>
