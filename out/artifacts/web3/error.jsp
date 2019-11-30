<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="addon" value=" - error"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Beauty Care +"/>
</jsp:include>
<main>
    <jsp:include page="errorHeader.jsp">
        <jsp:param name="message" value="er ging iets fout"/>
    </jsp:include>
    <article>
        <h3>Oorzaak:</h3>
        <p><c:out value="${pageContext.exception}"/></p>
    </article>
</main>
</body>
</html>