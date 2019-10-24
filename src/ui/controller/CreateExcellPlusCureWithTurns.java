/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of CreateExcellPlusCureWithTurns.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package ui.controller;

import domain.model.cure.ExcellPlusCure;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class CreateExcellPlusCureWithTurns extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("clientsCurrentCure")!=null) {
            response.sendRedirect("clientView.jsp");
        } else {
            int clientId = (int) request.getSession().getAttribute("clientId");
            ExcellPlusCure newCure = new ExcellPlusCure(new Timestamp(System.currentTimeMillis()),Integer.parseInt(request.getParameter("turns")),Integer.parseInt(request.getParameter("turns")));
            //Client client = (Client)request.getSession().getAttribute("client");
            getDatabaseService().addExcellPlusCure(clientId, newCure);
            request.getSession().setAttribute("cureId",getDatabaseService().getCurrentExcellPlusCureId(clientId));
            request.getSession().setAttribute("clientsCurrentCure", newCure);
            request.getRequestDispatcher("clientView.jsp").forward(request,response);
        }
    }
}
