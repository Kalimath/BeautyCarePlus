package ui.controller;

import domain.model.TurnsleftUpdateControllerSingleton;
import domain.model.cure.ExcellPlusCure;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class AddTurnsToExcellPlusCure extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = (int) request.getSession().getAttribute("clientId");
        ExcellPlusCure cure = getDatabaseService().getExcellPlusCureFromClientWithId(clientId);

        if (cure.getTurnsLeft() == 1 || cure.getTurnsLeft() == 12 || cure.getTurnsLeft() == 20) {
            response.sendRedirect("cureView.jsp");
        } else {
            LocalDate lastUpdate = TurnsleftUpdateControllerSingleton.getInstance().getLastUpdateTime();
            LocalDate today = LocalDate.now();

            if(lastUpdate==null||lastUpdate.getDayOfWeek()!=today.getDayOfWeek()){
                int cureId = (int) request.getSession().getAttribute("cureId");
                System.out.println("turns = "+request.getParameter("turns"));
                cure.addTurnsToCure(Integer.parseInt(request.getParameter("turns")));
                getDatabaseService().updateExcellPlusCure(cure,cureId);
                this.getControllerFactory().getController("ShowClient", getDatabaseService()).handleRequest(request, response);
            }else{
               response.sendRedirect("cureView.jsp");
            }

        }


    }
}
