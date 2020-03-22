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

        //client
        request.getSession().removeAttribute("client");

        //client id
        request.getSession().removeAttribute("clientId");

        //visit
        if(request.getSession().getAttribute("todaysVisit")!=null){
            request.getSession().removeAttribute("todaysVisit");
        }

        //Excell+
        if(request.getSession().getAttribute("clientCure")!=null){
            request.getSession().removeAttribute("clientCure");
        }

        //Heights
        if(request.getSession().getAttribute("clientHeights")!=null){
            request.getSession().removeAttribute("clientHeights");
        }
        this.getControllerFactory().getController("Home", getDatabaseService()).handleRequest(request,response);
    }
}
