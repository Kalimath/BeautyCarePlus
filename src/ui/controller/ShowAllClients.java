/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of ShowAllClients.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowAllClients extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = "allClientsView.jsp";
        if(request.getAttribute("clients")!=null){
            response.sendRedirect(destination);
        }else{
            request.setAttribute("clients",getDatabaseService().getAllClients());
            request.getRequestDispatcher("allClientsView.jsp").forward(request,response);
        }
    }
}
