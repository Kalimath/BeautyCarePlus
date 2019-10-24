/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of Visit.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.model.visit;

import domain.model.measures.Checkup;

import java.sql.Timestamp;

public class Visit {
    private Timestamp moment;
    private Checkup checkup;
    private String comment;

    public Visit(Timestamp moment, Checkup checkup, String comment) {
        setMoment(moment);
        setComment(comment);
        setCheckup(checkup);
    }

    private void setCheckup(Checkup checkup) {
        this.checkup = checkup;
    }

    public Visit(){
        this.moment = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getMoment() {
        return moment;
    }

    public void setMoment(Timestamp moment) {
        this.moment = moment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Checkup getCheckup() {
        return checkup;
    }
}
