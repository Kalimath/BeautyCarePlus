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
    <p class="navTitle">${client.name}</p>
    <ul>
        <li><a href="clientView.jsp">Overzicht</a></li>
        <li><a href="clientData.jsp">Klantgegevens</a></li>
        <c:if test="${clientsCurrentCure!=null}">
            <li><a href="#">Excell+</a></li>
        </c:if>
        <li><a href="#">Laatste meting</a></li>
    </ul>
</nav>
