/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of ExcellPlusCureView.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package ui.controller;

import domain.model.cure.ExcellPlusCure;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcellPlusCureView extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = (int) request.getSession().getAttribute("clientId");
        ExcellPlusCure cure = getDatabaseService().getExcellPlusCureFromClientWithId(clientId);
        request.getSession().setAttribute("clientCure", cure);
        if ((cure.getAllCheckUps().size() >= 0 &&/*getDatabaseService().>=1&&*/(cure.getTurnsLeft() == 12 || cure.getTurnsLeft() == 4)) || ((cure.getLatestCheckup() == null || cure.checkupTooLongAgo()) && (cure.getTurnsLeft() >= 12))) {
            request.getSession().setAttribute("checkupNeeded","true");
        }else{
            request.getSession().setAttribute("checkupNeeded","false");
        }

        int turns = cure.getTurnsLeft();
        System.out.println("turns = "+turns);
        request.getSession().setAttribute("turnsleft", turns);
        request.getSession().setAttribute("lastCheckup", cure.getLatestCheckup());
        request.getSession().setAttribute("clientHeights",getDatabaseService().getHeightsFromClient((Integer) request.getSession().getAttribute("clientId")));

        request.getRequestDispatcher("cureView.jsp").forward(request,response);
    }
}
