package ui.controller;

import domain.model.DatabaseService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;



@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DatabaseService databaseService;
    private ControllerFactorySingleton controllerFactorySingleton = ControllerFactorySingleton.getInstance();

    public Controller() {
        super();
    }

    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();

        Properties properties = new Properties();
        Enumeration<String> parameterNames = context.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String propertyName = parameterNames.nextElement();
            properties.setProperty(propertyName, context.getInitParameter(propertyName));
        }

        databaseService = new DatabaseService(properties);
    }


    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("command");
        System.out.println(action);
        if((request.getSession()==null&&!action.equals("UserLogIn"))||(request.getSession().getAttribute("user")==null&&!action.equals("UserLogIn"))){
            request.getRequestDispatcher("logInForm.jsp").forward(request,response);
        }else{
            if (action != null) {
                RequestHandler handler;
                handler = controllerFactorySingleton.getController(action, databaseService);
                handler.handleRequest(request, response);
            }else{
                controllerFactorySingleton.getController("Home", databaseService).handleRequest(request,response);
            }
        }


    }


}
