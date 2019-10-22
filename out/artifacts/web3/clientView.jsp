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
    <article>
        <h2 id="pageTitle"><em style="font-weight: bolder">Overzicht</em></h2>
    </article>
    <div class="article-container">
        <article>
            <h2>Gegevens</h2>
            <table>
                <tr>
                    <th>Naam</th>
                    <td><c:out value="${client.name}"/></td>
                </tr>
                <tr>
                    <th>E-mail</th>
                    <td><c:out value="${client.email}"/></td>
                </tr>
                <tr>
                    <th>Geboortedatum</th>
                    <td><c:out value="${client.birthDateString}"/></td>
                </tr>
                <tr>
                    <th>Telefoon</th>
                    <td><c:out value="${client.phone}"/></td>
                </tr>
                <c:if test="${clientAddress!=null}">
                    <tr>
                        <th>Adres</th>
                        <td><c:out value="${clientAddress.street}"/> <c:out value="${clientAddress.number}"/> <br>
                            <c:out value="${clientAddress.zip}"/> <c:out value="${clientAddress.place}"/></td>
                    </tr>
                </c:if>

            </table>

        </article>
        <div>
            <c:choose>
                <c:when test="${clientsCurrentCure!=null}">

                    <article>
                        <h2>Beurten resterend</h2>
                        <h3>${clientsCurrentCure.turnsLeft}</h3>
                    </article>
                    <c:choose>
                        <c:when test="${clientsCurrentCure.turnsLeft>0}">
                            <article class="cure">
                                <h2>Behandeling starten</h2>
                                <c:if test="${errorStart!=null}">
                                    <p class="error-message"> ${errorStart}</p>
                                </c:if>
                                <form method="post" action="Controller?command=StartCureExcellPlus">
                                    <input type="submit" value=" Starten " class="button">
                                </form>
                            </article>
                        </c:when>
                    </c:choose>

                    <c:if test="${clientsCurrentCure.latestCheckup!=null}">
                        <article>
                            <h2>Laatste opmeting</h2>
                            <h3>${clientsCurrentCure.latestCheckup}</h3>
                        </article>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <article>
                        <a href="Controller?command=CreateExcellPlusCure"><h2>Creër kuur</h2></a>
                    </article>
                </c:otherwise>
            </c:choose>
            <article>
                <h2>Beurten toevoegen</h2>
                <form method="post" action="Controller?command=AddTurnsToCureExcellPlus">

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
    </div>
</main>
</body>
</html>
