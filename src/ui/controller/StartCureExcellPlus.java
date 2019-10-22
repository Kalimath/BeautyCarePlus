package ui.controller;

import domain.model.cure.ExcellPlusCure;
import domain.model.personal.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartCureExcellPlus extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = (int) request.getSession().getAttribute("clientId");
        ExcellPlusCure cure = getDatabaseService().getExcellPlusCureFromClientWithId(clientId);

        if(cure.getTurnsLeft()>0){
            cure.startCureOneTime();
            boolean checkupNeeded = cure.isCheckupNeeded();
            request.setAttribute("checkupNeeded", checkupNeeded);
        }else{
            request.setAttribute("errorStart", "Voeg eerst beurten toe!");

            (new ControllerFactory().getController("ShowClient", getDatabaseService())).handleRequest(request,response);
        }

    }
}
