package ui.controller;

import domain.model.cure.ExcellPlusCure;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientExcellPlusCure extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExcellPlusCure cure = (ExcellPlusCure) request.getSession().getAttribute("clientCure");

        if ((cure.getAllCheckUps().size() >= 0 &&/*getDatabaseService().>=1&&*/(cure.getTurnsLeft() == 12 || cure.getTurnsLeft() == 4)) || ((cure.getLatestCheckup() == null || cure.checkupTooLongAgo()) && (cure.getTurnsLeft() >= 12))) {
            request.getSession().setAttribute("checkupNeeded","true");
        }else{
            request.getSession().setAttribute("checkupNeeded","false");
        }

        int turns = cure.getTurnsLeft();
        System.out.println("turns = "+turns);
        request.getSession().setAttribute("turnsleft", turns);
        request.getSession().setAttribute("latestCheckup", cure.getLatestCheckup());
        request.getSession().setAttribute("clientHeights",getDatabaseService().getHeightsFromClient((Integer) request.getSession().getAttribute("clientId")));
        request.getRequestDispatcher("cureView.jsp").forward(request,response);
    }

    //deze handler is het niet, gebruik ExcellPlusCureView !!!
}
