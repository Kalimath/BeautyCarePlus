<%--
  ~ Created with IntelliJ IDEA Ultimate.
  ~ Copyright (c) 2019. All Rights Reserved
  ~ Unauthorized copying of defineHeightsForm.jsp, via any medium is strictly prohibited
  ~ Proprietary and confidential
  ~ Written by MB-Development (Kalimath), Month Year
  --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Client: Kalimath
  Date: 10/06/2019
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="addon" value=" - klant toevoegen"/>
</jsp:include>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Voeg klant toe"/>
</jsp:include>
<main>

    <article>
        <h1 style="font-weight: bolder">Hoogtes definiëren</h1>
    </article>
    <c:if test="${errors!=null}">
        <article class="alertContainer">
            <div class="alertIcon"><img src="images/info%20(1).png" alt="alert icon red"></div>
            <div>
                <ul id="errorList">
                    <c:forEach items="${errors}" var="message">
                        <li id="error" style="color: red; list-style: circle; text-align: left"
                            class="error-message">${message}</li>
                    </c:forEach>
                </ul>
            </div>
        </article>
    </c:if>
    <article>
        <form method="post" action="Controller?command=DefineHeights" class="red" validate>
            <p style="padding: 0">
            <p class="row">
            <div class="col-25"><label for="isLeftSide" class="control-label">Kant van meting:</label></div>
            <div class="col-75">
                <input type="radio" name="vorst" id="isRightSide" checked="" value="Rechts">
                <input type="radio" name="vorst" id="isLeftSide" checked="" value="Links"></div>
            </p>
            <p class="row">
            <div class="col-25">
                <label for="knieH" class="control-label">Knie:</label></div>
            <div class="col-75">
                <input type="number" id="knieH" name="knieH" placeholder="in centimeter" min="0" step="0.01"
                       value="${previousValueKnieH}"></div>
            </p>
            <p class="row">
            <div class="col-25"><label for="dijH" class="control-label">Dij:</label></div>
            <div class="col-75"><input type="number" id="dijH" name="dijH" placeholder="in centimeter" min="0" step="0.01"
                                       value="${previousValueDijH}"></div>
            </p>
            <p class="row">
            <div class="col-25"><label for="tailleH" class="control-label">Taille:</label></div>
            <div class="col-75"><input type="number" id="tailleH" name="tailleH" placeholder="in centimeter" min="0" step="0.01"
                                       value="${previousValueTailleH}"></div>
            </p>
            <p class="row">
            <div class="col-25"><label for="armH" class="control-label">Arm:</label></div>
            <div class="col-75"><input type="number" id="armH" name="armH" placeholder="in centimeter" min="0" step="0.01"
                                       value="${previousValueArmH}"></div>
            </p>
            <p class="row">
            <div class="col-25"><label for="heupH" class="control-label">Heup:</label></div>
            <div class="col-75"><input type="number" id="heupH" name="heupH" placeholder="in centimeter" min="0" step="0.01"
                                       value="${previousValueHeupH}"></div>
            </p>
            <p class="row">
            <div class="col-25"><label for="kuitH" class="control-label">Kuit:</label></div>
            <div class="col-75"><input type="number" id="kuitH" name="kuitH" placeholder="in centimeter" min="0" step="0.01"
                                       value="${previousValueKuitH}"></div>
            </p>
            <p class="row">
            <div class="col-25"><label for="lengtePersoonH" class="control-label">Lengte persoon:</label></div>
            <div class="col-75"><input type="number" id="lengtePersoonH" name="lengtePersoonH" placeholder="in centimeter" min="0" step="0.01"
                                       value="${previousValueLengtePersoonH}"></div>
            </p>

            <p class="row">
                <input type="submit" value="Verder" id="submit">
            </p>
            </fieldset>
        </form>
        <h3>Vul een 0 (nul) in als de klant een bepaalde meting weigert.</h3>
    </article>
</main>
</body>
</html>
