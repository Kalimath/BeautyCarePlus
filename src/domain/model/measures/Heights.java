package domain.model.measures;

import domain.model.personal.Client;

import java.util.Random;

public class Heights extends BodyMeasures {

    public Heights(){
        super();

    }

    public Heights(double knee, double thigh, double waist, double calf, double hip, double arm, String comment) {
        super(knee,thigh,waist,calf,hip,arm,comment);
    }
}
