/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2020. All Rights Reserved
 * Unauthorized copying of JsonConverterSingleton.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (mathi), Month Year
 */

package domain.model;

public class JsonConverterSingleton {
    private static JsonConverterSingleton uniqueInstance;

    private JsonConverterSingleton(){
    }

    public static JsonConverterSingleton getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new JsonConverterSingleton();
        }
        return uniqueInstance;
    }

}
