<%--
  ~ Created with IntelliJ IDEA Ultimate.
  ~ Copyright (c) 2019. All Rights Reserved
  ~ Unauthorized copying of checkup2Form.jsp, via any medium is strictly prohibited
  ~ Proprietary and confidential
  ~ Written by MB-Development (Kalimath), Month Year
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Kalimath
  Date: 7/12/2019
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
    <article>
        <h1>Opmeting 2/2</h1>
    </article>
    <form method="post" action="#" class="red" validate>
        <div class="article-container">
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
                <p class="row">
                    <input type="submit" value="Bevestig" id="submit">
                </p>
                </fieldset>
                <p>er ontbreken nog inputs!!!</p>
            </article>
        </div>
    </form>
</main>
</body>
</html>
