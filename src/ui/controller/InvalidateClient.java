/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of InvalidateClient.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InvalidateClient extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = (int) request.getSession().getAttribute("clientId");
        request.getSession().removeAttribute("client");
        request.getSession().removeAttribute("clientId");
        if(request.getSession().getAttribute("todaysVisit")!=null){
            request.getSession().removeAttribute("todaysVisit");
        }
        if(request.getSession().getAttribute("clientsCurrentCure")!=null){
            request.getSession().removeAttribute("clientsCurrentCure");
        }
        this.getControllerFactory().getController("Home", getDatabaseService()).handleRequest(request,response);
    }
}
