/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of DefineHeights.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 *//*


package ui.controller;

import domain.model.measures.Heights;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefineHeights extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String knieH = request.getParameter("knieH");
        String dijH = request.getParameter("dijH");
        String tailleH = request.getParameter("tailleH");
        String armH = request.getParameter("armH");
        String heupH = request.getParameter("heupH");
        String kuitH = request.getParameter("kuitH");
        String lengtePersoonH = request.getParameter("lengtePersoonH");

        Heights temp = new Heights();
        List<String> errors = new ArrayList<>();

        try{
            double knee = Double.parseDouble(knieH);
            temp.setKnee(knee);
            request.setAttribute("previousValueKnieH",knee);
        }catch (Exception ex){
            errors.add("meethoogte voor knie is ongeldig!");
            ex.printStackTrace();
        }


        try{
            double thigh = Double.parseDouble(dijH);
            temp.setThigh(thigh);
            request.setAttribute("previousValueDijH",thigh);
        }catch (Exception ex){
            errors.add("meethoogte voor dij is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double waist = Double.parseDouble(tailleH);
            temp.setWaist(waist);
            request.setAttribute("previousValueTailleH",waist);
        }catch (Exception ex){
            errors.add("meethoogte voor taille is ongeldig!");
            ex.printStackTrace();
        }
        try{
            double arm = Double.parseDouble(armH);
            temp.setArm(arm);
            request.setAttribute("previousValueArmH",arm);
        }catch (Exception ex){
            errors.add("meethoogte voor arm is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double hip = Double.parseDouble(heupH);
            temp.setThigh(hip);
            request.setAttribute("previousValueHeupH",hip);
        }catch (Exception ex){
            errors.add("meethoogte voor heup is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double calf = Double.parseDouble(kuitH);
            temp.setCalf(calf);
            request.setAttribute("previousValueKuitH",calf);
        }catch (Exception ex){
            errors.add("meethoogte voor kuit is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double fullLength = Double.parseDouble(lengtePersoonH);
            temp.setFullLength(fullLength);
            request.setAttribute("previousValueLengtePersoonH",fullLength);
        }catch (Exception ex){
            errors.add("meethoogte voor volledige lengte is ongeldig!");
            ex.printStackTrace();
        }


        String dest = "defineHeightsForm.jsp";

        if(getDatabaseService().getHeightsFromClient((Integer) request.getSession().getAttribute("clientId"))!=null){
            errors.add("De hoogtes van deze klant zijn al gedefineerd!");
            request.setAttribute("errors", errors);
            request.getRequestDispatcher(dest).forward(request,response);
        }else if(temp!=null) {
            if (errors.size() > 0) {
                request.setAttribute("errors", errors);
                request.getRequestDispatcher(dest).forward(request,response);
            } else {
                try {
                    this.getDatabaseService().addHeightsFromClient(temp, (Integer) request.getSession().getAttribute("clientId"));
                    request.getSession().setAttribute("clientHeights",temp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dest = "ClientExcellPlusCure";
                getControllerFactory().getController(dest,getDatabaseService()).handleRequest(request,response);
            }

        }



    }
}
*/
