/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of DefineHeightsForm.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package ui.controller;

import domain.model.personal.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefineHeightsForm extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int clientId = getDatabaseService().getClientId(((Client)request.getSession().getAttribute("client")).getName());
        if(getDatabaseService().getHeightsFromClient(clientId)!=null){
            response.sendRedirect("cientView.jsp");
        }else{
            request.getRequestDispatcher("defineHeightsForm.jsp").forward(request,response);
        }
    }
}
