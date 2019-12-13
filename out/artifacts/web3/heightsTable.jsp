<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Created with IntelliJ IDEA Ultimate.
  ~ Copyright (c) 2019. All Rights Reserved
  ~ Unauthorized copying of heightsTable.jsp, via any medium is strictly prohibited
  ~ Proprietary and confidential
  ~ Written by MB-Development (Kalimath), Month Year
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Kalimath
  Date: 5/12/2019
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${clientHeights!=null}">
    <table>
        <tr>
            <th>Arm</th>
            <td><c:out value="${clientHeights.arm}"/></td>
        </tr>
        <tr>
            <th>dij</th>
            <td><c:out value="${clientHeights.thigh}"/></td>
        </tr>
        <tr>
            <th>taille</th>
            <td><c:out value="${clientHeights.waist}"/></td>
        </tr>
        <tr>
            <th>heup</th>
            <td><c:out value="${clientHeights.hip}"/></td>
        </tr>
        <tr>
            <th>knie</th>
            <td><c:out value="${clientHeights.knee}"/></td>
        </tr>
        <tr>
            <th>kuit</th>
            <td><c:out value="${clientHeights.calf}"/></td>
        </tr>
        <c:if test="${param.fullLength==true}">
            <tr>
                <th>lengte</th>
                <td><c:out value="${clientHeights.fullLength}"/></td>
            </tr>
        </c:if>
    </table>
</c:if>

