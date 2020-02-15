/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of Checkup.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package ui.controller;

import domain.model.measures.Circumferences;
import domain.model.measures.Weights;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Checkup extends RequestHandler {
    private List<String> errors = new ArrayList<>();
    private int clientId;
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "checkupForm.jsp";
        clientId = (int) request.getSession().getAttribute("clientId");

        Weights definedWeights = defineWeights(request,response);
        Circumferences definedCircumferences = defineCircumferences(request,response);

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher(dest).forward(request,response);
        } else {
            try {
                this.getDatabaseService().addCheckupToLatestVisit(definedWeights,definedCircumferences, (Integer) request.getSession().getAttribute("clientId"));

                request.getSession().setAttribute("clientHeights",getDatabaseService().getLatestVisit(clientId));
            } catch (Exception e) {
                e.printStackTrace();
            }
            dest = "ClientExcellPlusCure";
            getControllerFactory().getController(dest,getDatabaseService()).handleRequest(request,response);
        }

    }



    private Circumferences defineCircumferences(HttpServletRequest request, HttpServletResponse response){
        String knieO = request.getParameter("knieO");
        String dijO = request.getParameter("dijO");
        String tailleO = request.getParameter("tailleO");
        String armO = request.getParameter("armO");
        String heupO = request.getParameter("heupO");
        String kuitO = request.getParameter("kuitO");

        Circumferences temp = new Circumferences();
        List<String> errors = new ArrayList<>();

        try{
            double knee = Double.parseDouble(knieO);
            temp.setKnee(knee);
            request.setAttribute("previousValueKnieO",knee);
        }catch (Exception ex){
            errors.add("Omtrek van knie is ongeldig!");
            ex.printStackTrace();
        }


        try{
            double thigh = Double.parseDouble(dijO);
            temp.setThigh(thigh);
            request.setAttribute("previousValueDijO",thigh);
        }catch (Exception ex){
            errors.add("Omtrek van dij is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double waist = Double.parseDouble(tailleO);
            temp.setWaist(waist);
            request.setAttribute("previousValueTailleO",waist);
        }catch (Exception ex){
            errors.add("Omtrek van taille is ongeldig!");
            ex.printStackTrace();
        }
        try{
            double arm = Double.parseDouble(armO);
            temp.setArm(arm);
            request.setAttribute("previousValueArmO",arm);
        }catch (Exception ex){
            errors.add("Omtrek van arm is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double hip = Double.parseDouble(heupO);
            temp.setThigh(hip);
            request.setAttribute("previousValueHeupO",hip);
        }catch (Exception ex){
            errors.add("Omtrek van heup is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double calf = Double.parseDouble(kuitO);
            temp.setCalf(calf);
            request.setAttribute("previousValueKuitO",calf);
        }catch (Exception ex){
            errors.add("Omtrek van kuit is ongeldig!");
            ex.printStackTrace();
        }

        if(temp!=null) {
            return temp;

        }else{
            throw new NullPointerException("Cirumferences from "+getDatabaseService().getClientWithId(clientId).getName()+"are defined as null!");
        }
    }

    private Weights defineWeights(HttpServletRequest request, HttpServletResponse response){
        String weightString = request.getParameter("gewicht");
        String fatmassString = request.getParameter("vetmassa");
        String musclemassString = request.getParameter("spiermassa");
        String moisturemassString = request.getParameter("vochtmassa");
        String bmrString = request.getParameter("bmr");
        String bonemassString = request.getParameter("botmassa");
        String metabolicAgeString = request.getParameter("metabolischeLeeftijd");
        String visceralFatmassString = request.getParameter("visceraleVetwaarde");
        String idealFatmassStartString = request.getParameter("idealeVetmassaBegin");
        String idealFatmassEndString = request.getParameter("idealeVetmassaEinde");

        Weights temp = new Weights();
        List<String> errors = new ArrayList<>();

        try{
            double weight = Double.parseDouble(weightString);
            temp.setWeight(weight);
            request.setAttribute("previousValueGewicht",weight);
        }catch (Exception ex){
            errors.add("Gewicht is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double fatmass = Double.parseDouble(fatmassString);
            temp.setFatmass(fatmass);
            request.setAttribute("previousValueVetmassa",fatmass);
        }catch (Exception ex){
            errors.add("Vetmassa is ongeldig!");
            ex.printStackTrace();
        }
        try{
            double musclemass = Double.parseDouble(musclemassString);
            temp.setMusclemass(musclemass);
            request.setAttribute("previousValueSpiermassa",musclemass);
        }catch (Exception ex){
            errors.add("Spiermassa is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double moisturemass = Double.parseDouble(moisturemassString);
            temp.setMoisturemass(moisturemass);
            request.setAttribute("previousValueVochtmassa",moisturemass);
        }catch (Exception ex){
            errors.add("Vochtmassa is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double bmr = Double.parseDouble(bmrString);
            temp.setBmr(bmr);
            request.setAttribute("previousValueBmr",bmr);
        }catch (Exception ex){
            errors.add("BMR is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double bonemass = Double.parseDouble(bonemassString);
            temp.setBonemass(bonemass);
            request.setAttribute("previousValueBotmassa",bonemass);
        }catch (Exception ex){
            errors.add("Botmassa is ongeldig!");
            ex.printStackTrace();
        }

        try{
            int metabolicAge = Integer.parseInt(metabolicAgeString);
            temp.setMetabolicAge(metabolicAge);
            request.setAttribute("previousValueMetabolischeLeeftijd",metabolicAge);
        }catch (Exception ex){
            errors.add("Metabolische leeftijd is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double visceralFatmass = Double.parseDouble(visceralFatmassString);
            temp.setVisceralFat(visceralFatmass);
            request.setAttribute("previousValueVisceraleVetwaarde",visceralFatmass);
        }catch (Exception ex){
            errors.add("Viscerale vetwaarde is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double idealFatmassStart = Double.parseDouble(idealFatmassStartString);
            temp.setIdealFatMassBegin(idealFatmassStart);
            request.setAttribute("previousValueIdealeVetmassaBegin",idealFatmassStart);
        }catch (Exception ex){
            errors.add("Begin ideale vetwaarde is ongeldig!");
            ex.printStackTrace();
        }

        try{
            double idealFatmassEnd = Double.parseDouble(idealFatmassEndString);
            temp.setVisceralFat(idealFatmassEnd);
            request.setAttribute("previousValueIdealeVetmassaEinde",idealFatmassEnd);
        }catch (Exception ex){
            errors.add("Einde ideale vetwaarde is ongeldig!");
            ex.printStackTrace();
        }

        if(temp!=null) {
            return temp;

        }else{
            throw new NullPointerException("Cirumferences from "+getDatabaseService().getClientWithId(clientId).getName()+"are defined as null!");
        }
    }
}
