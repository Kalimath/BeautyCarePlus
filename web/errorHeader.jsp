<%--
  ~ Created with IntelliJ IDEA Ultimate.
  ~ Copyright (c) 2019. All Rights Reserved
  ~ Unauthorized copying of errorHeader.jsp, via any medium is strictly prohibited
  ~ Proprietary and confidential
  ~ Written by MB-Development (Kalimath), Month Year
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Kalimath
  Date: 30/11/2019
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<article>
    <img src="images/info%20(1).png" alt="alert icon">
    <h1 id="error" style="color: red; text-align: center; font-size: 200%">Waarschuwing: ${param.message}</h1>
</article>
<article>
    <h2>Keer terug naar:</h2>
    <h3><a href="Controller?command=Home">Startpagina</a></h3>
    <h3><a href="Controller?command=ClientView">Klantenoverzicht</a></h3>
</article>
