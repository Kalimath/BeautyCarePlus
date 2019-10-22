package domain.model.health;

import domain.model.debug.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HealthOverview {
    private String foodAdvice,causeWeight,problematicFood,condition,dietHistory,complaints,bodyType,WeightLosingZones;
    private double initialWeight, targetWeight;
    private List<Birth> births;

    public HealthOverview() {
        births = new ArrayList<>();
    }

    public HealthOverview(String foodAdvice, String causeWeight, String problematicFood, String condition, String dietHistory, String complaints, String bodyType, String weightLosingZones, double initialWeight, double targetWeight) {
        setFoodAdvice(foodAdvice);
        setCauseWeight(causeWeight);
        setProblematicFood(problematicFood);
        setCondition(condition);
        setDietHistory(dietHistory);
        setComplaints(complaints);
        setBodyType(bodyType);
        setWeightLosingZones(weightLosingZones);
        setInitialWeight(initialWeight);
        setTargetWeight(targetWeight);
    }

    public String getFoodAdvice() {
        return foodAdvice;
    }

    public void setFoodAdvice(String foodAdvice) {
        this.foodAdvice = foodAdvice;
    }

    public String getCauseWeight() {
        return causeWeight;
    }

    public void setCauseWeight(String causeWeight) {
        this.causeWeight = causeWeight;
    }

    public String getProblematicFood() {
        return problematicFood;
    }

    public void setProblematicFood(String problematicFood) {
        this.problematicFood = problematicFood;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDietHistory() {
        return dietHistory;
    }

    public void setDietHistory(String dietHistory) {
        this.dietHistory = dietHistory;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getWeightLosingZones() {
        return WeightLosingZones;
    }

    public void setWeightLosingZones(String weightLosingZones) {
        WeightLosingZones = weightLosingZones;
    }

    public double getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(double initialWeight) {
        this.initialWeight = initialWeight;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public void addBirth(Birth birth){
        if(birth!=null){
            births.add(birth);
        }else{
            throw  new DomainException("births can't be empty");
        }
    }

    public List<Birth> getBirths(){
        return births;
    }
}
