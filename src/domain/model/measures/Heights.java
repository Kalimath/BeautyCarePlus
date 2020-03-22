package domain.model.measures;

public class Heights extends BodyMeasures {
    private double fullLength;
    private boolean measureSide;

    public Heights(){
        super();

    }

    public Heights(double knee, double thigh, double waist, double calf, double hip, double arm, double fullLength, String comment, boolean measureSide) {
        super(knee,thigh,waist,calf,hip,arm,comment);
        setFullLength(fullLength);
    }

    public void setFullLength(double fullLength) {
        this.fullLength = fullLength;
    }

    public double getFullLength() {
        return fullLength;
    }

    public boolean getMeasureSide(){
        return measureSide;
    }

    public void setMeasureSide(boolean measureSide){
        this.measureSide = measureSide;
    }
}
