package domain.model.measures;

import domain.model.ObjectWithId;

import java.util.Random;

public abstract class BodyMeasures {
    private double knee,thigh,waist,calf,hip,arm;
    private String comment;

    public BodyMeasures() {
        super();
    }


    public BodyMeasures(double knee, double thigh, double waist, double calf, double hip, double arm, String comment) {
        setKnee(knee);
        setThigh(thigh);
        setWaist(waist);
        setCalf(calf);
        setHip(hip);
        setArm(arm);
        setComment(comment);
    }

    public double getKnee() {
        return knee;
    }

    public void setKnee(double knee) {
        this.knee = knee;
    }

    public double getThigh() {
        return thigh;
    }

    public void setThigh(double thigh) {
        this.thigh = thigh;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getCalf() {
        return calf;
    }

    public void setCalf(double calf) {
        this.calf = calf;
    }

    public double getHip() {
        return hip;
    }

    public void setHip(double hip) {
        this.hip = hip;
    }

    public double getArm() {
        return arm;
    }

    public void setArm(double arm) {
        this.arm = arm;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
