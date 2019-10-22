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
    <article>
        <h2>Error</h2>
        <p class="error-message">(<c:out value="${pageContext.exception.message}"/>)</p>
		<h3><a href="Controller?command=Home">Keer terug</a></h3>

    </article>
</main>
</body>
</html>