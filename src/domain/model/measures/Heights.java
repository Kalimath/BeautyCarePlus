package domain.model.measures;

public class Heights extends BodyMeasures {
    private double fullLength;

    public Heights(){
        super();

    }

    public Heights(double knee, double thigh, double waist, double calf, double hip, double arm, double fullLength, String comment) {
        super(knee,thigh,waist,calf,hip,arm,comment);
        setFullLength(fullLength);
    }

    public void setFullLength(double fullLength) {
        this.fullLength = fullLength;
    }

    public double getFullLength() {
        return fullLength;
    }
}
