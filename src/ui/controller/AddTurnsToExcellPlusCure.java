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

        if (cure.getTurnsLeft() == 1 || cure.getTurnsLeft()>=12) {
            System.out.println("Redirected, turns left is higher than 11!");
            response.sendRedirect("cureView.jsp");
        } else {
            LocalDate lastUpdate = TurnsleftUpdateControllerSingleton.getInstance().getLastUpdateTime();
            LocalDate today = LocalDate.now();

            if(lastUpdate==null||lastUpdate.getDayOfWeek()!=today.getDayOfWeek()){
                int turns = Integer.parseInt(request.getParameter("turns"));
                System.out.println("turns = "+turns);
                cure.addTurnsToCure(turns);
                getDatabaseService().updateExcellPlusCure(cure, (Integer) request.getSession().getAttribute("clientId"));
                request.getSession().setAttribute("clientCure",cure);
                this.getControllerFactory().getController("ShowClient", getDatabaseService()).handleRequest(request, response);
            }else{
               response.sendRedirect("cureView.jsp");
            }

        }


    }
}
