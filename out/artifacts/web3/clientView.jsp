<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
    <article><h1 id="clientName">${client.name}</h1></article>
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
        <c:if test="${client.comment!=null||client.comment!=''}">
            <article>
                <h2>Commentaar</h2>
                <p>${client.comment}</p>
            </article>
        </c:if>

        <c:if test="${clientCure==null}">
            <article>
                <h2>Excell+ kuur aanmaken</h2>
                <form method="post" action="Controller?command=CreateExcellPlusCureWithTurns">

                    <input type="radio" name="turns" value="1" id="radio1" class="form-radio" checked>
                    <label for="radio1">testbeurt</label>

                    <input type="radio" name="turns" value="12" id="radio2" class="form-radio">
                    <label for="radio2">12 beurten</label>

                    <input type="radio" name="turns" value="20" id="radio3" class="form-radio">
                    <label for="radio3">20 beurten</label>
                    <p>
                        <input type="submit" value="maak aan" class="button">
                    </p>
                </form>
            </article>
        </c:if>
    </div>
</main>
</body>
</html>
