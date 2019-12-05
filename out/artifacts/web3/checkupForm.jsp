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
                <h2>Omtrek van:</h2>
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
                <h2>Meting:</h2>
                <p style="padding: 0">
                <p class="row">
                <div class="col-25">
                    <label for="gewicht" class="control-label">Gewicht:</label></div>
                <div class="col-75">
                    <input type="number" id="gewicht" name="gewicht" placeholder="in kg" min="0" step="0.01"
                           value="${previousValueGewicht}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="vetmassa" class="control-label">Vetmassa:</label></div>
                <div class="col-75"><input type="number" id="vetmassa" name="vetmassa" placeholder="in kg" min="0"
                                           step=0.01"
                                           value="${previousValueVetmassa}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="spiermassa" class="control-label">Spiermassa:</label></div>
                <div class="col-75"><input type="number" id="spiermassa" name="spiermassa" placeholder="in kg" min="0"
                                           step="0.01"
                                           value="${previousValueSpiermassa}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="lichaamsvocht" class="control-label">Lichaamsvocht:</label></div>
                <div class="col-75"><input type="number" id="lichaamsvocht" name="lichaamsvocht" placeholder="in kg" min="0"
                                           step="0.01"
                                           value="${previousValueLichaamsvocht}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="bmr" class="control-label">Bmr:</label></div>
                <div class="col-75"><input type="number" id="bmr" name="bmr" placeholder="in kJ" min="0"
                                           step="0.01"
                                           value="${previousValueBmr}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="metabolischeLeeftijd" class="control-label">Metabolische leeftijd:</label></div>
                <div class="col-75"><input type="number" id="metabolischeLeeftijd" name="metabolischeLeeftijd" placeholder="in jaar" min="0"
                                           step="0.01"
                                           value="${previousValueMetabolischeLeeftijd}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="idealeVetmassa" class="control-label">Ideale vetmassa:</label></div>
                <div class="col-75"><input type="number" id="idealeVetmassa" name="idealeVetmassa" placeholder="in kg" min="0"
                                           step="0.01"
                                           value="${previousValueIdealeVetmassa}"></div>
                </p>
                </fieldset>
                <p>er ontbreken nog inputs!!!</p>
            </article>
        </div>
        <article>
            <p class="row">
                <input type="submit" value="Bevestig" id="submit">
            </p>


        </article>
    </form>
</main>
</body>
</html>
