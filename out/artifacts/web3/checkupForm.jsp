<%--
  Created by IntelliJ IDEA.
  User: Kalimath
  Date: 31/08/2019
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="addon" value="klant: ${client.name}"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Opmeting"/>

</jsp:include>
<main>
    <form method="post" action="#" class="red" validate>
        <div class="article-container">
            <article>

                <p style="padding: 0">
                <p class="row">
                <div class="col-25">
                    <label for="knieH" class="control-label">Knie:</label></div>
                <div class="col-75">
                    <input type="number" id="knieH" name="knieH" placeholder="in centimeter" min="0" step="1"
                           value="${previousValueKnieH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="dijH" class="control-label">Dij:</label></div>
                <div class="col-75"><input type="number" id="dijH" name="dijH" placeholder="in centimeter" min="0"
                                           step="1"
                                           value="${previousValueDijH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="tailleH" class="control-label">Taille:</label></div>
                <div class="col-75"><input type="number" id="tailleH" name="tailleH" placeholder="in centimeter" min="0"
                                           step="1"
                                           value="${previousValueTailleH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="armH" class="control-label">Arm:</label></div>
                <div class="col-75"><input type="number" id="armH" name="armH" placeholder="in centimeter" min="0"
                                           step="1"
                                           value="${previousValueArmH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="heupH" class="control-label">Heup:</label></div>
                <div class="col-75"><input type="number" id="heupH" name="heupH" placeholder="in centimeter" min="0"
                                           step="1"
                                           value="${previousValueHeupH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="kuitH" class="control-label">Kuit:</label></div>
                <div class="col-75"><input type="number" id="kuitH" name="kuitH" placeholder="in centimeter" min="0"
                                           step="1"
                                           value="${previousValueKuitH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="lengtePersoonH" class="control-label">Lengte persoon:</label></div>
                <div class="col-75"><input type="number" id="lengtePersoonH" name="lengtePersoonH"
                                           placeholder="in centimeter" min="0" step="1"
                                           value="${previousValueLengtePersoonH}"></div>
                </p>
                </fieldset>

            </article>
            <article>

                <p style="padding: 0">
                <p class="row">
                <div class="col-25">
                    <label for="knieH" class="control-label">Knie:</label></div>
                <div class="col-75">
                    <input type="number" id="knieH" name="knieH" placeholder="in centimeter" min="0" step="1"
                           value="${previousValueKnieH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="dijH" class="control-label">Dij:</label></div>
                <div class="col-75"><input type="number" id="dijH" name="dijH" placeholder="in centimeter" min="0"
                                           step="1"
                                           value="${previousValueDijH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="tailleH" class="control-label">Taille:</label></div>
                <div class="col-75"><input type="number" id="tailleH" name="tailleH" placeholder="in centimeter" min="0"
                                           step="1"
                                           value="${previousValueTailleH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="armH" class="control-label">Arm:</label></div>
                <div class="col-75"><input type="number" id="armH" name="armH" placeholder="in centimeter" min="0"
                                           step="1"
                                           value="${previousValueArmH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="heupH" class="control-label">Heup:</label></div>
                <div class="col-75"><input type="number" id="heupH" name="heupH" placeholder="in centimeter" min="0"
                                           step="1"
                                           value="${previousValueHeupH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="kuitH" class="control-label">Kuit:</label></div>
                <div class="col-75"><input type="number" id="kuitH" name="kuitH" placeholder="in centimeter" min="0"
                                           step="1"
                                           value="${previousValueKuitH}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="lengtePersoonH" class="control-label">Lengte persoon:</label></div>
                <div class="col-75"><input type="number" id="lengtePersoonH" name="lengtePersoonH"
                                           placeholder="in centimeter" min="0" step="1"
                                           value="${previousValueLengtePersoonH}"></div>
                </p>
                </fieldset>

            </article>
        </div>
        <article>
            <p class="row">
                <input type="submit" value="Verder" id="submit">
            </p>


        </article>
    </form>
</main>
</body>
</html>
