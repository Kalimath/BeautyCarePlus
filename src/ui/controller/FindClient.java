package ui.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindClient extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "index.jsp";
        String clientName = request.getParameter("name");
        try {
            int clientId = getDatabaseService().getClientId(clientName);
            dest = "clientView.jsp";
            request.getSession().setAttribute("clientId", clientId);
            request.getSession().setAttribute("client", getDatabaseService().getClientWithId(clientId));
            request.getSession().setAttribute("clientAddress", getDatabaseService().getAddress(clientId));
            this.getControllerFactory().getController("ShowClient", getDatabaseService()).handleRequest(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Geen resultaten voor opgegeven naam: \""+clientName+"\"");
            request.setAttribute("clientNames", getDatabaseService().getClientnames());
            RequestDispatcher view = request.getRequestDispatcher(dest);
            view.forward(request, response);
        }
    }
}
