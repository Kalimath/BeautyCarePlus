package ui.controller;

import domain.model.cure.ExcellPlusCure;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowClient extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = (int) request.getSession().getAttribute("clientId");

        //Excell+
        if(request.getSession().getAttribute("clientCure")==null){
            ExcellPlusCure cure = getDatabaseService().getExcellPlusCureFromClientWithId(clientId);
            request.getSession().setAttribute("clientCure", cure);
        }

        //Heights
        request.getSession().setAttribute("clientHeights",getDatabaseService().getHeightsFromClient(clientId));

        request.getRequestDispatcher("clientView.jsp").forward(request, response);
    }
}
