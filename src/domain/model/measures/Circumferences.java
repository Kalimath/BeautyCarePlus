package domain.model.measures;

public class Circumferences extends BodyMeasures {
    public Circumferences(){
        super();
    }

    public Circumferences(double knee, double thigh, double waist, double calf, double hip, double arm, String comment) {
        super(knee,thigh,waist,calf,hip,arm,comment);
    }
}
