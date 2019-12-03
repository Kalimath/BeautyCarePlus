<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="addon" value="klant: ${client.name}"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Klant"/>

</jsp:include>
<main>
    <article><h1 style="font-weight: bolder">Excell+</h1></article>
    <div class="article-container">
        <article>
            <h2>Beurten resterend</h2>
            <h3>${turnsleft}</h3>
        </article>
        <article class="cure">
            <h2>Behandeling starten</h2>
            <c:if test="${errorStart!=null}">
                <p class="error-message"> ${errorStart}</p>
            </c:if>
            <form method="post" action="Controller?command=StartCureExcellPlus">
                <input type="submit" value=" Starten " class="button">
            </form>
        </article>

        <article>
            <h2>Laatste opmeting</h2>
            <h3>${lastCheckup}</h3>
        </article>
        <article>
            <h2>Beurten toevoegen</h2>
            <form method="post" action="Controller?command=AddTurnsToCureExcellPlus&id=${clientId}">

                <input type="radio" name="turns" value="1" id="radio1" class="form-radio" checked>
                <label for="radio1">testbeurt</label>

                <input type="radio" name="turns" value="12" id="radio2" class="form-radio">
                <label for="radio2">12 beurten</label>

                <input type="radio" name="turns" value="20" id="radio3" class="form-radio">
                <label for="radio3">20 beurten</label>


                <p>
                    <input type="submit" value="Voeg toe" class="button">
                </p>
            </form>
        </article>


    </div>
</main>
</body>
</html>
