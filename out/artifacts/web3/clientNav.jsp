<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Created with IntelliJ IDEA Ultimate.
  ~ Copyright (c) 2019. All Rights Reserved
  ~ Unauthorized copying of clientNav.jsp, via any medium is strictly prohibited
  ~ Proprietary and confidential
  ~ Written by MB-Development (Kalimath), Month Year
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Kalimath
  Date: 22/10/2019
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="hc">
    <p class="navTitle"><a href="clientView.jsp">${client.name}</a></p>
    <ul>
        <li><a href="#">Gezondheidsfiche</a></li>
        <c:if test="${clientsCurrentCure!=null}">
            <li><a href="cureView.jsp">Excell+</a></li>
        </c:if>
        <c:if test="${clientsCurrentCure.getLatestCheckup()!=null}">
        <li><a href="#">Laatste meting</a></li>
        </c:if>
    </ul>
</nav>
