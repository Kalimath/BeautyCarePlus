<%--Created with IntelliJ IDEA Ultimate.
    Copyright (c) 2019. All Rights Reserved
    Unauthorized copying of allClientsView.jsp, via any medium is strictly prohibited
    Proprietary and confidential
    Written by MB-Development (Kalimath), October 2019
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<jsp:include page="head.jsp">
    <jsp:param name="addon" value=" - klantenbestand"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Klanten"/>
</jsp:include>
<main>
    <article><h2 id="pageTitle">Klanten</h2></article>
    <article>
            <c:if test="${clients!=null}">


                    <table style="margin-left: auto; margin-right: auto">
                        <thead>
                        <tr>
                            <th>Naam</th>
                            <th>E-mail</th>
                            <th>Geboortedatum</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="client" items="${clients}">
                            <tr>
                                <td><c:out value="${client.name}"/></td>
                                <td><c:out value="${client.email}"/></td>
                                <td><c:out value="${client.birthDate}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

            </c:if>



    </article>
    <article>
        <h3><a href="Controller">Terug</a></h3>
    </article>
</main>
</body>
</html>
