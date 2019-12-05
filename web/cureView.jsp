<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Client: Kalimath
  Date: 31/08/2019
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>

</head>
<jsp:include page="header.jsp">
    <jsp:param name="" value=""/>
</jsp:include>
<body>
<main>

    <article><h1 id="title">Excell+</h1></article>
    <div class="article-container">
        <c:choose>
            <c:when test="${todaysVisit!=null}">
                <article>
                    <h2>In behandeling</h2>
                    <img src="/images/therapy.png" alt="therapy image">
                    <form method="post" action="Controller?command=EndExcellPlusCure">
                        <input type="submit" value=" Beïndig "
                               id="submitEndCure">
                    </form>
                </article>
                <p>meethoggtes krijg ik nog niet uit de database</p>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${checkupNeeded}">
                        <article>
                            <h2>Opmeting aangeraden</h2>
                            <form method="post" action="Controller?command=CureStartedWithCheckup">
                                <input type="submit" value="Start nieuwe behandeling met opmeting"
                                       id="submitStartCureWithCheckup">
                            </form>
                            <form method="post" action="Controller?command=CureStarted">
                                <input type="submit" value="Start nieuwe behandeling zonder opmeting"
                                       id="submitStartCureWithoutCheckup">
                            </form>
                        </article>
                    </c:when>
                    <c:otherwise>

                        <article>
                            <h2>Nieuwe behandeling</h2>
                            <form method="post" action="Controller?command=StartExcellPlusCure">
                                <input type="submit" value=" Start " id="submitStartCure">
                            </form>
                            <c:if test="${errorMessage!=null}">
                                <div class="alertContainer">
                                    <div class="alertIcon"><img src="images/info%20(1).png" alt="alert icon red"></div>
                                    <div>
                                        <ul id="error">
                                            <p id="errorMessage" style="color: red; text-align: left"
                                               class="error-message">${errorMessage}</p>
                                        </ul>
                                    </div>
                                </div>
                            </c:if>
                        </article>

                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        <c:if test="${clientCure.turnsLeft<12}">
            <article>
                <h2>Beurten toevoegen</h2>
                <form method="post" action="Controller?command=AddTurnsToExcellPlusCure">

                    <input type="radio" name="turns" value="12" id="radio2" class="form-radio">
                    <label for="radio2">12 beurten</label>

                    <input type="radio" name="turns" value="20" id="radio3" class="form-radio">
                    <label for="radio3">20 beurten</label>
                    <p>
                        <input type="submit" value=" Voeg toe " class="button">
                    </p>
                </form>
            </article>
        </c:if>
        <article>
            <h2>Beurten resterend</h2>
            <h3 class="h3NumberField">${clientCure.turnsLeft}</h3>
        </article>
        <c:if test="${clientCure.latestCheckup!=null}">
            <article>
                <h2>Laatste opmeting</h2>
                <h3>${clientCure.latestCheckup}</h3>
            </article>
        </c:if>
        <div>

            <article>
                <h2>Meethoogtes</h2>
                <c:choose>
                    <c:when test="${clientHeights==null}">
                        <h3><a href="Controller?command=DefineHeightsForm">Definieer hoogtes (eenmalig)</a></h3>
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="heightsTable.jsp">
                            <jsp:param name="fullLength" value="false"/>
                        </jsp:include>
                    </c:otherwise>
                </c:choose>
            </article>

        </div>

    </div>
</main>
</body>
</html>
