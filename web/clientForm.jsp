<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Client: Kalimath
  Date: 10/06/2019
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="addon" value=" - klant toevoegen"/>
</jsp:include>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Voeg klant toe"/>
</jsp:include>
<main>

    <article>
        <h1 style="font-weight: bolder">Nieuwe klant toevoegen</h1>
    </article>
    <c:if test="${errors!=null}">
        <article class="alertContainer">
            <div class="alertIcon"><img src="images/info%20(1).png" alt="alert icon red"></div>
            <div>
                <ul id="errorList">
                    <c:forEach items="${errors}" var="message">
                        <li id="error" style="color: red; list-style: circle; text-align: left"
                            class="error-message">${message}</li>
                    </c:forEach>
                </ul>
            </div>
        </article>
    </c:if>

    <form method="post" action="Controller?command=AddClient" class="red" validate>
        <div class="article-container">
            <article>
                <p>
                <p class="row">
                <div class="col-25">
                    <label for="name" class="control-label">Naam:</label></div>
                <div class="col-75">
                    <input type="text" id="name" name="name" placeholder="Maria Galland"
                           value="${previousValueName}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="email" class="control-label">Email:</label></div>
                <div class="col-75"><input type="email" id="email" name="email" placeholder="info@beautycare.be"
                                           value="${previousValueEmail}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="phone" class="control-label">Telefoon:</label></div>
                <div class="col-75"><input type="tel" id="phone" name="phone" placeholder="015765432"
                                           value="${previousValuePhone}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="birthday" class="control-label">Geboortedatum:</label></div>
                <div class="col-75"><input type="date" id="birthday" name="birthday"
                                           value="${previousValueBirthday}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="comment" class="control-label">Opmerkingen:</label></div>
                <div class="col-75"><textarea type="text" id="comment" name="comment" placeholder="nieuw adres"
                                              value="${previousValueComment}" class="textarea"></textarea></div>
                </p>
            </article>
            <article>
                <p class="row">
                <div class="col-25"><label for="place" class="control-label">Woonplaats:</label></div>
                <div class="col-75"><input type="text" id="place" name="place" placeholder="Peulis"
                                           value="${previousValuePlace}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="zip" class="control-label">Postcode:</label></div>
                <div class="col-75"><input type="number" id="zip" name="zip" placeholder="2580"
                                           value="${previousValueZip}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="street" class="control-label">Straat:</label></div>
                <div class="col-75"><input type="text" id="street" name="street" placeholder="Peulisbaan"
                                           value="${previousValueStreet}"></div>
                </p>
                <p class="row">
                <div class="col-25"><label for="number" class="control-label">Huisnummer:</label></div>
                <div class="col-75"><input type="text" id="number" name="number" placeholder="124F"
                                           value="${previousValueNumber}"></div>
                </p>
                </fieldset>

            </article>
        </div>
        <article>
            <p class="row">
                <input type="submit" value="Voeg klant toe" id="submit">
            </p>
        </article>
    </form>

</main>
</body>
</html>

<script>
    var x, i, j, selElmnt, a, b, c;
    /*look for any elements with the class "custom-select":*/
    x = document.getElementsByClassName("custom-select");
    for (i = 0; i < x.length; i++) {
        selElmnt = x[i].getElementsByTagName("select")[0];
        /*for each element, create a new DIV that will act as the selected item:*/
        a = document.createElement("DIV");
        a.setAttribute("class", "select-selected");
        a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
        x[i].appendChild(a);
        /*for each element, create a new DIV that will contain the option list:*/
        b = document.createElement("DIV");
        b.setAttribute("class", "select-items select-hide");
        for (j = 1; j < selElmnt.length; j++) {
            /*for each option in the original select element,
            create a new DIV that will act as an option item:*/
            c = document.createElement("DIV");
            c.innerHTML = selElmnt.options[j].innerHTML;
            c.addEventListener("click", function (e) {
                /*when an item is clicked, update the original select box,
                and the selected item:*/
                var y, i, k, s, h;
                s = this.parentNode.parentNode.getElementsByTagName("select")[0];
                h = this.parentNode.previousSibling;
                for (i = 0; i < s.length; i++) {
                    if (s.options[i].innerHTML == this.innerHTML) {
                        s.selectedIndex = i;
                        h.innerHTML = this.innerHTML;
                        y = this.parentNode.getElementsByClassName("same-as-selected");
                        for (k = 0; k < y.length; k++) {
                            y[k].removeAttribute("class");
                        }
                        this.setAttribute("class", "same-as-selected");
                        break;
                    }
                }
                h.click();
            });
            b.appendChild(c);
        }
        x[i].appendChild(b);
        a.addEventListener("click", function (e) {
            /*when the select box is clicked, close any other select boxes,
            and open/close the current select box:*/
            e.stopPropagation();
            closeAllSelect(this);
            this.nextSibling.classList.toggle("select-hide");
            this.classList.toggle("select-arrow-active");
        });
    }

    function closeAllSelect(elmnt) {
        /*a function that will close all select boxes in the document,
        except the current select box:*/
        var x, y, i, arrNo = [];
        x = document.getElementsByClassName("select-items");
        y = document.getElementsByClassName("select-selected");
        for (i = 0; i < y.length; i++) {
            if (elmnt == y[i]) {
                arrNo.push(i)
            } else {
                y[i].classList.remove("select-arrow-active");
            }
        }
        for (i = 0; i < x.length; i++) {
            if (arrNo.indexOf(i)) {
                x[i].classList.add("select-hide");
            }
        }
    }

    /*if the client clicks anywhere outside the select box,
    then close all select boxes:*/
    document.addEventListener("click", closeAllSelect);
</script>
