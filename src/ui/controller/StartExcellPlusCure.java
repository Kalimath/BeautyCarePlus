package ui.controller;

import domain.model.cure.ExcellPlusCure;
import domain.model.visit.Visit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartExcellPlusCure extends RequestHandler {


    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = (int) request.getSession().getAttribute("clientId");
        ExcellPlusCure cure = getDatabaseService().getExcellPlusCureFromClientWithId(clientId);
        if (request.getSession().getAttribute("todaysVisit") != null||getDatabaseService().getHeightsFromClient(clientId)==null) {
            if(getDatabaseService().getHeightsFromClient(clientId)==null){
                request.setAttribute("errorMessage", "Meethoogtes zijn nog niet gedefinieerd!");
                request.getRequestDispatcher("cureView.jsp").forward(request, response);
            }else{
                request.setAttribute("errorMessage", "Er is reeds een behandeling bezig!");
                request.getRequestDispatcher("cureView.jsp").forward(request, response);
            }
        } else {
            if (cure.getTurnsLeft() > 0) {
                Visit newVisit = new Visit();

                /*if ((cure.getAllCheckUps().size() >= 0 &&*//*getDatabaseService().>=1&&*//*(cure.getTurnsLeft() == 12 || cure.getTurnsLeft() == 4)) || ((cure.getLatestCheckup() == null || cure.checkupTooLongAgo()) && (cure.getTurnsLeft() >= 12))) {
                    checkupNeeded = true;
                }*/
                cure.startNewVisit(newVisit);
                getDatabaseService().updateExcellPlusCure(cure,clientId);
                request.getSession().setAttribute("clientsCurrentCure", cure);
                request.getSession().setAttribute("todaysVisit", newVisit);

            } else {
                request.setAttribute("errorMessage", "Voeg eerst beurten toe!");
            }

            this.getControllerFactory().getController("ShowClient", getDatabaseService()).handleRequest(request, response);
        }


    }


}
