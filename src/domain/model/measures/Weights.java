/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of Weights.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.model.measures;

public class Weights {
    private double weight, bmr,fatMass,muscleMass,moistureMass,idealFatMass;
    private int metabolicAge;

    public Weights() {
    }

    public Weights(double weight, double bmr, double fatMass, double muscleMass, double moistureMass, double idealFatMass, int metabolicAge) {
        setWeight(weight);
        setBmr(bmr);
        setFatMass(fatMass);
        setMuscleMass(muscleMass);
        setMoistureMass(moistureMass);
        setIdealFatMass(idealFatMass);
        setMetabolicAge(metabolicAge);
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

    public double getFatMass() {
        return fatMass;
    }

    public void setFatMass(double fatMass) {
        this.fatMass = fatMass;
    }

    public double getMuscleMass() {
        return muscleMass;
    }

    public void setMuscleMass(double muscleMass) {
        this.muscleMass = muscleMass;
    }

    public double getMoistureMass() {
        return moistureMass;
    }

    public void setMoistureMass(double moistureMass) {
        this.moistureMass = moistureMass;
    }

    public double getIdealFatMass() {
        return idealFatMass;
    }

    public void setIdealFatMass(double idealFatMass) {
        this.idealFatMass = idealFatMass;
    }

    public int getMetabolicAge() {
        return metabolicAge;
    }

    public void setMetabolicAge(int metabolicAge) {
        this.metabolicAge = metabolicAge;
    }
}
