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
                <h1>Omtrek van:</h1>
                <p style="padding: 0">
                <p class="row">
                <div class="col-25">
                    <label for="knieO" class="control-label">Knie:</label></div>
                <div class="col-75">
                    <input type="number" id="knieO" name="knieO" placeholder="in centimeter" min="0" step="0.1"
                           value="${previousValueKnieO}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="dijO" class="control-label">Dij:</label></div>
                <div class="col-75"><input type="number" id="dijO" name="dijO" placeholder="in centimeter" min="0"
                                           step="0.1"
                                           value="${previousValueDijO}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="tailleO" class="control-label">Taille:</label></div>
                <div class="col-75"><input type="number" id="tailleO" name="tailleO" placeholder="in centimeter" min="0"
                                           step="0.1"
                                           value="${previousValueTailleO}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="armO" class="control-label">Arm:</label></div>
                <div class="col-75"><input type="number" id="armO" name="armO" placeholder="in centimeter" min="0"
                                           step="0.1"
                                           value="${previousValueArmO}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="heupO" class="control-label">Heup:</label></div>
                <div class="col-75"><input type="number" id="heupO" name="heupO" placeholder="in centimeter" min="0"
                                           step="0.1"
                                           value="${previousValueHeupO}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="kuitO" class="control-label">Kuit:</label></div>
                <div class="col-75"><input type="number" id="kuitO" name="kuitO" placeholder="in centimeter" min="0"
                                           step="0.1"
                                           value="${previousValueKuitO}"></div>
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
