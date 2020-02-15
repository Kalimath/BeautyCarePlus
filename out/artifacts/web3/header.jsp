<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kalimath
  Date: 30/08/2019
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<header class="containerHeader">

    <logoText>Beauty Care<em style="color: #B38D59">+</em></logoText>


    <c:choose>
        <c:when test="${user!=null}">
            <nav class="hc" he>
                <p class="navTitle">Algemeen</p>
                <ul>
                    <li><a href="Controller">Home</a></li>
                    <li><a href="Controller?command=AddClientForm">Voeg klant toe</a></li>
                </ul>
            </nav>

            <c:choose>
                <c:when test="${client!=null}">
                    <jsp:include page="clientNav.jsp">
                        <jsp:param name="" value=""/>
                    </jsp:include>
                </c:when>
                <c:otherwise>
                    <div class="hc">
                            <%--<h2>Klant:</h2>
                    <h3>${param.name}</h3>--%>
                    </div>
                </c:otherwise>
            </c:choose>


            <jsp:include page="userNav.jsp">
                <jsp:param name="" value=""/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="hc">

            </div>
            <div class="hc">

            </div>
            <div class="hc">

            </div>
        </c:otherwise>
    </c:choose>

    <nav class="hc">
        <a href="www.MBDevelopment.vlaanderen">© MB-Development</a>

    </nav>
    <%--<jsp:include page="Foot.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>--%>

</header>

</html>
