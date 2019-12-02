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

       <article><h2 id="title">Excell+</h2></article>
        <div class="article-container">
            <c:choose>
                <c:when test="${checkupNeeded}">
                <article>
                    <h2>Opmeting aangeraden</h2>
                    <form method="post" action="Controller?command=CureStartedWithCheckup">
                        <input type="submit" value="Start nieuwe behandeling opmeting" id="submitStartCureWithCheckup">
                    </form>
                    <form method="post" action="Controller?command=CureStarted">
                        <input type="submit" value="Start nieuwe behandeling zonder opmeting" id="submitStartCureWithoutCheckup">
                    </form>
                </article>
                </c:when>
                <c:otherwise>
                    <article>
                        <h2>Nieuwe behandeling</h2>
                        <form method="post" action="Controller?command=StartCureExcellPlus">
                            <input type="submit" value=" Start " id="submitStartCure">
                        </form>
                    </article>
                </c:otherwise>
            </c:choose>
            <article>
                <h2>Beurten resterend</h2>
                <h3>${clientsCurrentCure.turnsLeft}</h3>
            </article>
            <c:if test="${clientsCurrentCure.latestCheckup!=null}">
                <article>
                    <h2>Laatste opmeting</h2>
                    <h3>${clientsCurrentCure.latestCheckup}</h3>
                </article>
            </c:if>

        </div>
    </main>
</body>
</html>
