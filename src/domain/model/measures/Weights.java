/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of Weights.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.model.measures;

public class Weights {
    private double weight, bmr, fatmass, musclemass, bonemass,visceralFat, moisturemass, idealFatMassBegin, idealFatMassEnd;
    private int metabolicAge;

    public Weights() {
    }

    public Weights(double weight, double bmr, double fatMass, double muscleMass, double boneMass,double visceralFat, double moistureMass, double idealFatMassBegin, double idealFatMassEnd, int metabolicAge) {
        setWeight(weight);
        setBmr(bmr);
        setFatmass(fatMass);
        setMusclemass(muscleMass);
        setBonemass(boneMass);
        setVisceralFat(visceralFat);
        setMoisturemass(moistureMass);
        setIdealFatMassBegin(idealFatMassBegin);
        setMetabolicAge(metabolicAge);
        setIdealFatMassEnd(idealFatMassEnd);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    public double getFatmass() {
        return fatmass;
    }

    public void setFatmass(double fatMass) {
        this.fatmass = fatMass;
    }

    public double getMusclemass() {
        return musclemass;
    }

    public void setMusclemass(double musclemass) {
        this.musclemass = musclemass;
    }

    public double getMoisturemass() {
        return moisturemass;
    }

    public void setMoisturemass(double moisturemass) {
        this.moisturemass = moisturemass;
    }

    public double getIdealFatMassBegin() {
        return idealFatMassBegin;
    }

    public void setIdealFatMassBegin(double idealFatMassBegin) {
        this.idealFatMassBegin = idealFatMassBegin;
    }

    public int getMetabolicAge() {
        return metabolicAge;
    }

    public void setMetabolicAge(int metabolicAge) {
        this.metabolicAge = metabolicAge;
    }

    public double getBonemass() {
        return bonemass;
    }

    public void setBonemass(double bonemass) {
        this.bonemass = bonemass;
    }

    public double getVisceralFat() {
        return visceralFat;
    }

    public void setVisceralFat(double visceralFat) {
        this.visceralFat = visceralFat;
    }

    public double getIdealFatMassEnd() {
        return idealFatMassEnd;
    }

    public void setIdealFatMassEnd(double idealFatMassEnd) {
        this.idealFatMassEnd = idealFatMassEnd;
    }

    public int getBmi(){
        System.out.println("nog niet geschreven");
        return -1;
    }
}
