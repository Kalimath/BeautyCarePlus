package ui.controller;

import domain.model.cure.ExcellPlusCure;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTurnsToCureExcellPlus extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = (int) request.getSession().getAttribute("clientId");
        ExcellPlusCure cure = getDatabaseService().getExcellPlusCureFromClientWithId(clientId);
        getDatabaseService().updateExcellPlusCure(cure);

        if (cure.getTurnsLeft() == 1 || cure.getTurnsLeft() == 12 || cure.getTurnsLeft() == 20) {
            response.sendRedirect("clientForm.jsp");
        } else {
            (new ControllerFactory().getController("ShowClient", getDatabaseService())).handleRequest(request, response);
        }


    }
}
