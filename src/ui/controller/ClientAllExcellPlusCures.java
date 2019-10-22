package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientAllExcellPlusCures extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("excellPlusCure", getDatabaseService().getAllExcellPlusCuresFromClientWithId((Integer) request.getSession().getAttribute("clientId")));
        request.getRequestDispatcher("clientExcellPlusCure.jsp").forward(request,response);
    }
}
