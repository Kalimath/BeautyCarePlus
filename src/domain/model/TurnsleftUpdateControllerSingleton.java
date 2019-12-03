/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of TurnsleftUpdateControllerSingleton.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.model;

import java.time.LocalDate;

public class TurnsleftUpdateControllerSingleton {
    private static TurnsleftUpdateControllerSingleton uniqueInstance;
    private LocalDate lastUpdateTime;

    private TurnsleftUpdateControllerSingleton(){}

    public static TurnsleftUpdateControllerSingleton getInstance(){
        if (uniqueInstance == null) {
            uniqueInstance = new TurnsleftUpdateControllerSingleton();
        }
        return uniqueInstance;
    }

    public void setLastUpdateTime(LocalDate lastUpdateTime) {
        this.lastUpdateTime = LocalDate.now();
    }

    public LocalDate getLastUpdateTime(){
        return lastUpdateTime;
    }
}
