<%--
  Created by IntelliJ IDEA.
  User: Kalimath
  Date: 20/09/2019
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${errors!=null}">
    <c:forEach var="error" items="${errors}">
        <div class="ac">
            <table>
                <tr>
                    <th>Naam</th>
                    <th>E-mail</th>
                    <th>Geboortedatum</th>
                </tr>

                <tr>
                    <td><c:out value="${error.cause}"/></td>
                    <td><c:out value="${error.}"/></td>
                    <td><c:out value="${error.birthdate}"/></td>
                </tr>

            </table>
        </div>
    </c:forEach>
</c:if>
</body>
</html>
