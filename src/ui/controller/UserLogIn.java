/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of UserLogIn.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package ui.controller;

import domain.model.User;
import domain.model.debug.DomainException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserLogIn extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = "logInForm.jsp";
        String email = request.getParameter("email");
        List<String> errors = new ArrayList<>();
        User u = new User();

            try{
                u = getDatabaseService().getUser(email);
                if(u==null){
                    throw new DomainException("Email is ongeldig!");
                }
                request.setAttribute("previousValueEmail",email);
            }catch (Exception e){
                errors.add(e.getMessage());

            }
            try{
                String password = request.getParameter("password");
                if(u!=null){
                    if (u.isPasswordCorrect(password)){
                        request.getSession().setAttribute("user", u);
                    }else{
                        throw new DomainException("Wachtwoord is incorrect!");
                    }
                }else{
                    throw new DomainException("Wachtwoord is ongeldig!");
                }

            }catch (Exception e){
                errors.add(e.getMessage());

            }
            if(errors.size()>0){
                request.setAttribute("errorMessage","email/wachtwoord onjuist");
                System.out.println("Errors bij login: "+errors.size());
                for (String errorMessage: errors) System.out.println(errorMessage);
                request.getRequestDispatcher(destination).forward(request,response);
            }else{
                this.getControllerFactory().getController("Home",this.getDatabaseService()).handleRequest(request,response);
            }





    }
}
