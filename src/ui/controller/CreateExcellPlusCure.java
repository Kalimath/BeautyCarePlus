package ui.controller;

import domain.model.cure.ExcellPlusCure;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateExcellPlusCure extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("clientsCurrentCure")!=null) {
            response.sendRedirect("clientView.jsp");
        } else {
            int clientId = (int) request.getSession().getAttribute("clientId");
            ExcellPlusCure newCure = new ExcellPlusCure();
            //Client client = (Client)request.getSession().getAttribute("client");
            getDatabaseService().addExcellPlusCure(clientId, newCure);
            request.getSession().setAttribute("cureId",getDatabaseService().getCurrentExcellPlusCureId());
            request.getSession().setAttribute("clientsCurrentCure", newCure);
            request.getRequestDispatcher("clientView.jsp").forward(request,response);
        }

    }
}
