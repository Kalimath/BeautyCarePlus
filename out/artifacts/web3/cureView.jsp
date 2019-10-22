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
       <article><h2>Behandeling Excell+</h2></article>
            <c:choose>
                <c:when test="${checkupNeeded}">
                <article>
                    <h2>Opmeting aangeraden</h2>
                    <form method="post" action="Controller?command=CureStartedWithCheckup">
                        <input type="submit" value="Start opmeting">
                    </form>
                    <form method="post" action="Controller?command=CureStarted">
                        <input type="submit" value="Start zonder opmeting">
                    </form>
                </article>
                </c:when>
                <c:otherwise>
                    <article>
                        <form method="post" action="Controller?command=CureStarted">
                            <input type="submit" value="Start">
                        </form>
                    </article>
                </c:otherwise>
            </c:choose>

    </main>
</body>
</html>
