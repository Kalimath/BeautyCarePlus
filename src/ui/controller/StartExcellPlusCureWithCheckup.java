package ui.controller;

import domain.model.cure.ExcellPlusCure;
import domain.model.visit.Visit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class StartExcellPlusCureWithCheckup extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = (int) request.getSession().getAttribute("clientId");
        ExcellPlusCure cure = getDatabaseService().getExcellPlusCureFromClientWithId(clientId);
        boolean checkupNeeded = false;
        if (/*request.getSession().getAttribute("todaysVisit") != null||*/getDatabaseService().getHeightsFromClient(clientId)==null) {
            if(getDatabaseService().getHeightsFromClient(clientId)==null){
                request.setAttribute("errorMessage", "Meethoogtes zijn nog niet gedefinieerd!");
                request.getRequestDispatcher("cureView.jsp").forward(request, response);
            }else{
                request.setAttribute("errorMessage", "Er is reeds een behandeling bezig!");
                request.getRequestDispatcher("cureView.jsp").forward(request, response);
            }
        } else {
            if (cure.getTurnsLeft() > 0) {
                if(request.getSession().getAttribute("todaysVisit")==null){
                    Visit newVisit = new Visit();
                    newVisit.setMoment(new Timestamp(System.currentTimeMillis()));
                    getDatabaseService().addVisit(newVisit,clientId);
                    cure.startNewVisit(newVisit);
                    request.getSession().setAttribute("todaysVisit", newVisit);
                }

                getDatabaseService().updateExcellPlusCure(cure,clientId);
                request.getSession().setAttribute("clientsCurrentCure", cure);
                request.getRequestDispatcher("checkupForm.jsp").forward(request, response);

            } else {
                request.setAttribute("errorMessage", "Voeg eerst beurten toe!");
                this.getControllerFactory().getController("ShowClient", getDatabaseService()).handleRequest(request, response);
            }


        }


    }
}
