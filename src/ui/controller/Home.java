package ui.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Home extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession()!=null&&request.getSession().getAttribute("user")!=null){
            List<String> names = getDatabaseService().getClientnames();
            request.setAttribute("clientNames", names);
            System.out.println("#clientNames= "+ getDatabaseService().getClientnames().size());
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }else{
            response.sendRedirect("logInForm.jsp");
        }

    }
}
