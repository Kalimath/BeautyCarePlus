package domain.model.measures;

import domain.model.ObjectWithId;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class CheckUp extends ObjectWithId implements Serializable {
    private LocalDate appointment;
    private double bmi, weight, length;
    public CheckUp(){
        super();
    }

    public CheckUp(double weight, double length) {
        this();
        setLengthAndWeight(length,weight);
        setAppointment(LocalDate.now());
    }
    public CheckUp(int id, double weight, double length) {
        super(id);
        setLengthAndWeight(length,weight);
        setAppointment(LocalDate.now());
    }


    private void setBmi() {
        this.bmi = this.weight/(this.length*this.length);
    }

    private void setWeight(double weight) {
        this.weight = weight;
        /*if(weight>30.0){
            this.weight = weight;
        }else{
            throw new IllegalArgumentException("Gewicht moet groter zijn dan 30,0 (Kg)");
        }*/
    }

    private void setLength(double length) {
        if(length>1.0){
            this.length = length;
        }else{
            throw new IllegalArgumentException("Lengte moet groter zijn dan 1,0 (m)");
        }
    }

    public void setLengthAndWeight(double length, double weight) {
        setLength(length);
        setWeight(weight);
        setBmi();
    }

    public void setAppointment(LocalDate localDate){
        try {
            this.appointment = localDate;
        } catch (Exception e) {
            throw  new IllegalArgumentException("date is invalid for checkup");
        }
    }

    public double getBmi() {
        return bmi;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public LocalDate getAppointment() {
        return appointment;
    }


}
