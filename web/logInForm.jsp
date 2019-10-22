<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Created with IntelliJ IDEA Ultimate.
  ~ Copyright (c) 2019. All Rights Reserved
  ~ Unauthorized copying of logInForm.jsp, via any medium is strictly prohibited
  ~ Proprietary and confidential
  ~ Written by MB-Development (Kalimath), October 2019
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="nl">
<jsp:include page="head.jsp">
    <jsp:param name="addon" value=" - klantenbestand"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Log in"/>
</jsp:include>
<main>

    <article>
        <h2 id="pageTitle">Log in</h2>
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

        <form action="Controller?command=UserLogIn" method="post">
            <fieldset>

                <p class="row">
                <div class="col-25"><label for="email" class="control-label">Email:</label></div>
                <div class="col-75"><input type="email" id="email" name="email"
                                           value="${previousValueEmail}"></div>
                </p>

                <p class="row">
                <div class="col-25"><label for="password" class="control-label">Wachtwoord:</label></div>
                <div class="col-75"><input type="password" id="password" name="password"></div>
                </p>

                <div class="col-75">
                    <input type="checkbox" onclick="showPassWord()" class="checkboxFormItem">Toon wachtwoord
                </div>

                    <input type="submit" value="Log in" id="submit">

            </fieldset>
        </form>
    </article>
</main>
<script>
    function showPassWord() {
        var x = document.getElementById("password");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>
</body>
</html>
