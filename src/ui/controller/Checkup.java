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
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String dest = "checkupForm.jsp";
        clientId = (int) request.getSession().getAttribute("clientId");
        Weights definedWeights = null;
        Circumferences definedCircumferences = null;
        try {
            definedWeights = defineWeights(request, response);
        } catch (Exception e) {
        }

        try {
            definedCircumferences = defineCircumferences(request, response);
        } catch (Exception e) {
        }

        if(errors.size() > 0){
            request.setAttribute("errors", errors);
            request.getRequestDispatcher(dest).forward(request, response);
        }else{
            try {
                this.getDatabaseService().addVisitWithCheckup(definedWeights, definedCircumferences, (Integer) request.getSession().getAttribute("clientId"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            dest = "ClientExcellPlusCure";
            getControllerFactory().getController("ClientExcellPlusCure", getDatabaseService()).handleRequest(request, response);
        }

    }


    private Circumferences defineCircumferences(HttpServletRequest request, HttpServletResponse response){
        Circumferences temp = new Circumferences();
        List<String> errors = new ArrayList<>();

        try {
            double knee = 0;
            try {
                String knieO = request.getParameter("knieO");
                knee = Double.parseDouble(knieO);
            } catch (Exception e) {
                System.out.println("1/6: knee is set to 0");
            }
            if(knee >= 0){
                temp.setKnee(knee);
            }else{
                throw new IllegalArgumentException("knee circumference is lower than 0");
            }
            request.setAttribute("previousValueKnieO", knee);
            System.out.println("1/6: knee is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Omtrek van knie is ongeldig!");
            ex.printStackTrace();
        }


        try {
            double thigh = 0;
            try {
                String dijO = request.getParameter("dijO");
                thigh = Double.parseDouble(dijO);
            } catch (Exception e) {
                System.out.println("2/6: thigh is set to 0");
            }
            if(thigh >= 0){
                temp.setThigh(thigh);
            }else{
                throw new IllegalArgumentException("thigh circumference is lower than 0");
            }
            request.setAttribute("previousValueDijO", thigh);
            System.out.println("2/6: thigh is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Omtrek van dij is ongeldig!");
            ex.printStackTrace();
        }

        try {
            double waist = 0;
            try {
                String tailleO = request.getParameter("tailleO");
                waist = Double.parseDouble(tailleO);
            } catch (Exception e) {
                System.out.println("3/6: waist is set to 0");
            }
            if(waist >= 0){
                temp.setWaist(waist);
            }else{
                throw new IllegalArgumentException("waist circumference is lower than 0");
            }
            request.setAttribute("previousValueTailleO", waist);
            System.out.println("3/6: waist is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Omtrek van taille is ongeldig!");
            ex.printStackTrace();
        }
        try {
            double arm = 0;
            try {
                String armO = request.getParameter("armO");
                arm = Double.parseDouble(armO);
            } catch (Exception e) {
                System.out.println("4/6: arm is set to 0");
            }
            if(arm >= 0){
                temp.setArm(arm);
            }else{
                throw new IllegalArgumentException("arm circumference is lower than 0");
            }
            request.setAttribute("previousValueArmO", arm);
            System.out.println("4/6: arm is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Omtrek van arm is ongeldig!");
            ex.printStackTrace();
        }

        try {
            double hip = 0;
            try {
                String heupO = request.getParameter("heupO");
                hip = Double.parseDouble(heupO);
            } catch (Exception e) {
                System.out.println("5/6: hip is set to 0");
            }
            if(hip >= 0){
                temp.setHip(hip);
            }else{
                throw new IllegalArgumentException("hip circumference is lower than 0");
            }
            request.setAttribute("previousValueHeupO", hip);
            System.out.println("5/6: hip is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Omtrek van de heup is ongeldig!");
            ex.printStackTrace();
        }

        try {
            double calf = 0;
            try {
                String kuitO = request.getParameter("kuitO");
                calf = Double.parseDouble(kuitO);
            } catch (Exception e) {
                System.out.println("6/6: calf is set to 0");
            }
            if(calf >= 0){
                temp.setCalf(calf);
            }else{
                throw new IllegalArgumentException("calf circumference is lower than 0");
            }
            request.setAttribute("previousValueKuitO", calf);
            System.out.println("6/6: calf is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Omtrek van kuit is ongeldig!");
            ex.printStackTrace();
        }

        if(temp != null){
            System.out.println("Circumferences succesfully initialised");
            return temp;

        }else{
            System.out.println("Circumferences object equals null");
            throw new NullPointerException("Cirumferences from " + getDatabaseService().getClientWithId(clientId).getName() + "are defined as null!");
        }
    }

    private Weights defineWeights(HttpServletRequest request, HttpServletResponse response){
        Weights temp = new Weights();

        try {
            double weight = 0;
            try {
                String weightString = request.getParameter("gewicht");
                weight = Double.parseDouble(weightString);
            } catch (Exception e) {
                System.out.println("1/10: weight is set to 0");
            }
            if(weight >= 0){
                temp.setWeight(weight);
            }else{
                throw new IllegalArgumentException("weight is lower than 0");
            }
            request.setAttribute("previousValueGewicht", weight);
            System.out.println("1/10: weight is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Gewicht is ongeldig!");
            ex.printStackTrace();
        }

        try {
            double fatmass = 0;
            try {
                String fatmassString = request.getParameter("vetmassa");
                fatmass = Double.parseDouble(fatmassString);
            } catch (Exception e) {
                System.out.println("2/10: fatmass is set to 0");
            }
            if(fatmass >= 0){
                temp.setFatmass(fatmass);
            }else{
                throw new IllegalArgumentException("fatmass circumference is lower than 0");
            }
            request.setAttribute("previousValueVetmassa", fatmass);
            System.out.println("2/10: fatmass is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Vetmassa is ongeldig!");
            ex.printStackTrace();
        }
        try {
            double musclemass = 0;
            try {
                String musclemassString = request.getParameter("spiermassa");
                musclemass = Double.parseDouble(musclemassString);
            } catch (Exception e) {
                System.out.println("3/10: musclemass is set to 0");
            }
            if(musclemass >= 0){
                temp.setMusclemass(musclemass);
            }else{
                throw new IllegalArgumentException("musclemass circumference is lower than 0");
            }
            request.setAttribute("previousValueSpiermassa", musclemass);
            System.out.println("3/10: musclemass is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Spiermassa is ongeldig!");
            ex.printStackTrace();
        }

        try {
            double moisturemass = 0;
            try {
                String moisturemassString = request.getParameter("vochtmassa");
                moisturemass = Double.parseDouble(moisturemassString);
            } catch (Exception e) {
                System.out.println("4/10: moisturemass is set to 0");
            }
            if(moisturemass >= 0){
                temp.setMoisturemass(moisturemass);
            }else{
                throw new IllegalArgumentException("moisturemass circumference is lower than 0");
            }
            request.setAttribute("previousValueVochtmassa", moisturemass);
            System.out.println("4/10: moisturemass is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Vochtmassa is ongeldig!");
            ex.printStackTrace();
        }

        try {
            double bmr = 0;
            try {
                String bmrString = request.getParameter("bmr");
                bmr = Double.parseDouble(bmrString);
            } catch (Exception e) {
                System.out.println("5/10: bmr is set to 0");
            }
            if(bmr >= 0){
                temp.setBmr(bmr);
            }else{
                throw new IllegalArgumentException("bmr circumference is lower than 0");
            }
            request.setAttribute("previousValueBmr", bmr);
            System.out.println("5/10: bmr is parsed succesfully");
        } catch (Exception ex) {
            errors.add("BMR is ongeldig!");
            ex.printStackTrace();
        }

        try {
            double bonemass = 0;
            try {
                String bonemassString = request.getParameter("botmassa");
                bonemass = Double.parseDouble(bonemassString);
            } catch (Exception e) {
                System.out.println("6/10: bonemass is set to 0");
            }
            if(bonemass >= 0){
                temp.setBonemass(bonemass);
            }else{
                throw new IllegalArgumentException("bonemass circumference is lower than 0");
            }
            request.setAttribute("previousValueBotmassa", bonemass);
            System.out.println("6/10: bonemass is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Botmassa is ongeldig!");
            ex.printStackTrace();
        }

        try {
            int metabolicAge = 0;
            try {
                String metabolicAgeString = request.getParameter("metabolischeLeeftijd");
                metabolicAge = Integer.parseInt(metabolicAgeString);
            } catch (Exception e) {
                System.out.println("7/10: metabolic age is set to 0");
            }
            if(metabolicAge >= 0){
                temp.setMetabolicAge(metabolicAge);
            }else{
                throw new IllegalArgumentException("metabolicAge circumference is lower than 0");
            }
            request.setAttribute("previousValueMetabolischeLeeftijd", metabolicAge);
            System.out.println("7/10: metabolic age is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Metabolische leeftijd is ongeldig!");
            ex.printStackTrace();
        }

        try {
            double visceralFatmass = 0;
            try {
                String visceralFatmassString = request.getParameter("visceraleVetwaarde");
                visceralFatmass = Double.parseDouble(visceralFatmassString);
            } catch (Exception e) {
                System.out.println("8/10: visceral fatmass is set to 0");
            }
            if(visceralFatmass >= 0){
                temp.setVisceralFat(visceralFatmass);
            }else{
                throw new IllegalArgumentException("visceralFatmass circumference is lower than 0");
            }
            request.setAttribute("previousValueVisceraleVetwaarde", visceralFatmass);
            System.out.println("8/10: visceral fatmass is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Viscerale vetwaarde is ongeldig!");
            ex.printStackTrace();
        }

        try {
            double idealFatmassStart = 0;
            try {
                String idealFatmassStartString = request.getParameter("idealeVetmassaBegin");
                idealFatmassStart = Double.parseDouble(idealFatmassStartString);
            } catch (Exception e) {
                System.out.println("9/10: idealFatmassStart is set to 0");
            }
            if(idealFatmassStart >= 0){
                temp.setIdealFatMassBegin(idealFatmassStart);
            }else{
                throw new IllegalArgumentException("idealFatmassStart circumference is lower than 0");
            }
            request.setAttribute("previousValueIdealeVetmassaBegin", idealFatmassStart);
            System.out.println("9/10: ideal fatmass start is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Begin ideale vetwaarde is ongeldig!");
            ex.printStackTrace();
        }

        try {
            double idealFatmassEnd = 0;
            try {
                String idealFatmassEndString = request.getParameter("idealeVetmassaEinde");
                idealFatmassEnd = Double.parseDouble(idealFatmassEndString);
            } catch (Exception e) {
                System.out.println("9/10: idealFatmassEnd is set to 0");
            }
            if(idealFatmassEnd >= 0){
                temp.setIdealFatMassEnd(idealFatmassEnd);
            }else{
                throw new IllegalArgumentException("idealFatmassEnd circumference is lower than 0");
            }
            request.setAttribute("previousValueIdealeVetmassaEinde", idealFatmassEnd);
            System.out.println("10/10: ideal fatmass end is parsed succesfully");
        } catch (Exception ex) {
            errors.add("Einde ideale vetwaarde is ongeldig!");
            ex.printStackTrace();
        }

        if(temp != null){
            System.out.println("Weights succesfully initialised");
            return temp;

        }else{
            System.out.println("Weights object equals null");
            throw new NullPointerException("Cirumferences from " + getDatabaseService().getClientWithId(clientId).getName() + "are defined as null!");
        }
    }
}
