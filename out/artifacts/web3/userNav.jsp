<%--
  ~ Created with IntelliJ IDEA Ultimate.
  ~ Copyright (c) 2019. All Rights Reserved
  ~ Unauthorized copying of userNav.jsp, via any medium is strictly prohibited
  ~ Proprietary and confidential
  ~ Written by MB-Development (Kalimath), Month Year
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Kalimath
  Date: 22/10/2019
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="hc">
    <p class="navTitle">Gebruiker</p>
    <ul>
        <li><a href="Controller">Profiel</a></li>
        <li><a href="Controller?command=LogOffUser">Uitloggen</a></li>
        <c:if test="${user.role=='ADMIN'}">
            <li><a href="Controller?command=ShowAllClients">Klanten</a></li>
            <li><a href="userForm.jsp">Add User</a></li>
        </c:if>
    </ul>
</nav>
