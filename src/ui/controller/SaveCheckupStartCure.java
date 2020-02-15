package ui.controller;

import domain.model.measures.Circumferences;
import domain.model.measures.Weights;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveCheckupStartCure extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int clientid = (int) request.getSession().getAttribute("clientId");

        //omtrek-attributen
        double knie = Double.parseDouble(request.getParameter("knieO"));
        double dij = Double.parseDouble(request.getParameter("dijO"));
        double taille = Double.parseDouble(request.getParameter("tailleO"));
        double arm = Double.parseDouble(request.getParameter("armO"));
        double heup = Double.parseDouble(request.getParameter("heupO"));
        double kuit = Double.parseDouble(request.getParameter("kuitO"));

        //weging-attributen
        double gewicht = Double.parseDouble(request.getParameter("gewicht"));
        double vetmassa = Double.parseDouble(request.getParameter("vetmassa"));
        double spiermassa = Double.parseDouble(request.getParameter("spiermassa"));
        double lichaamsvocht = Double.parseDouble(request.getParameter("lichaamsvocht"));
        double bmr = Double.parseDouble(request.getParameter("bmr"));
        double botmassaa = Double.parseDouble(request.getParameter("botmassa"));
        double metabolischeLeeftijd = Double.parseDouble(request.getParameter("metabolischeLeeftijd"));
        double visceraleVetwaarde = Double.parseDouble(request.getParameter("visceraleVetwaarde"));
        double idealeVetmassaBegin = Double.parseDouble(request.getParameter("idealeVetmassaBegin"));
        double idealeVetmassaEinde = Double.parseDouble(request.getParameter("idealeVetmassaEinde"));

        Circumferences circumferences = new Circumferences();
        circumferences.setKnee(knie);
        circumferences.setThigh(dij);
        circumferences.setWaist(taille);
        circumferences.setArm(arm);
        circumferences.setHip(heup);
        circumferences.setCalf(kuit);

        Weights weights = new Weights();
        weights.setWeight(gewicht);
        weights.setFatmass(vetmassa);
        weights.setMusclemass(spiermassa);
        weights.setMoisturemass(lichaamsvocht);
        weights.setBmr(bmr);
        weights.setBonemass(botmassaa);
        weights.setMetabolicAge((int) Math.round(metabolischeLeeftijd));
        weights.setVisceralFat(visceraleVetwaarde);
        weights.setIdealFatMassBegin(idealeVetmassaBegin);
        weights.setIdealFatMassEnd(idealeVetmassaEinde);

        this.getDatabaseService().addCheckupToLatestVisit(weights,circumferences,clientid);
        //verwijs door naar behandeling
    }
}
