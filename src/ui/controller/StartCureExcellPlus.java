package ui.controller;

import domain.model.cure.ExcellPlusCure;
import domain.model.visit.Visit;

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
            Visit newVisit = new Visit();
            cure.addVisit(newVisit);
            request.getSession().setAttribute("todaysVisit", newVisit);
            boolean needed = false;
            if((cure.getAllCheckUps().size()>=0&&/*getDatabaseService().>=1&&*/(cure.getTurnsLeft()==12||cure.getTurnsLeft()==4)) || ((cure.getLatestCheckup()==null||cure.checkupTooLongAgo())&&(cure.getTurnsLeft()>=12))){
                needed = true;
            }
            request.setAttribute("checkupNeeded", needed);
        }else{
            request.setAttribute("errorStart", "Voeg eerst beurten toe!");

            (new ControllerFactory().getController("ShowClient", getDatabaseService())).handleRequest(request,response);
        }





    }


}
