package ui.controller;

import domain.model.cure.ExcellPlusCure;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartCureExcellPlus extends RequestHandler {
    int clientId = (int) request.getSession().getAttribute("clientId");
    ExcellPlusCure cure = getDatabaseService().getExcellPlusCureFromClientWithId(clientId);

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if(cure.getTurnsLeft()>0){
            cure.startCureOneTime();
            request.setAttribute("checkupNeeded", isCheckupNeeded());
        }else{
            request.setAttribute("errorStart", "Voeg eerst beurten toe!");

            (new ControllerFactory().getController("ShowClient", getDatabaseService())).handleRequest(request,response);
        }

    }

    public boolean isCheckupNeeded(){
        boolean needed = false;
        if((cure.getAllCheckUps().size()>=0&&/*getDatabaseService().>=1&&*/(cure.getTurnsLeft()==12||cure.getTurnsLeft()==4)) || ((cure.getLatestCheckup()==null||cure.checkupTooLongAgo())&&(cure.getTurnsLeft()>=12))){
            needed = true;
        }
        return needed;
    }
}
