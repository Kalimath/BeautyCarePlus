package domain.model.cure;

import domain.model.measures.CheckUp;
import domain.model.personal.Client;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

public class ExcellPlusCure implements Serializable {
    private int turnsLeft;
    private List<List<Date>> pastCures;
    private List<LocalDate> visits;
    private List<CheckUp> checkUps;

    public ExcellPlusCure() {
        checkUps = new ArrayList<>();
        visits = new ArrayList<>();
        pastCures = new ArrayList<>();
        turnsLeft = 0;
    }

    public void addTurnsToCure(int turns) {
        if(turns!=0) {
            this.turnsLeft =this.turnsLeft+turns;
        }
    }

    public void startCureOneTime(){
        visits.add(LocalDate.now());
        turnsLeft--;
    }

    public void doCheckUp(double weight, double length){
        checkUps.add(new CheckUp(weight,length));
    }

    public List<CheckUp> getAllCheckUps(){
        return checkUps;
    }

    public CheckUp getLatestCheckup(){
        CheckUp latest = null;
        if(this.getAllCheckUps()==null||this.getAllCheckUps().isEmpty()) {
            return null;
        }else{
        for(CheckUp c : getAllCheckUps()){
            if(latest==null||c.getAppointment().isAfter(latest.getAppointment())) {
                latest = c;
            }
        }}
        return latest;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public int getTotalTurnsPast(){
        int tp = 0;
       for(List<Date> visits: pastCures){
           tp = tp + visits.size();
       }
       return tp;
    }

    private boolean checkupTooLongAgo(){
            Date current = new Date(System.currentTimeMillis());
            LocalDate today =  LocalDate.now();
            LocalDate latest = getLatestCheckup().getAppointment();
            Period between = Period.between(today,latest);
            if(between.getMonths()>=2) {
                return true;
            }else{
                return false;
            }
        }

    private int getInCureNow(){
        int cures = pastCures.size();
        if(visits.size()>1) cures++;
        return cures;
    }

    public boolean isCheckupNeeded() {
        boolean needed = false;
        if((checkUps.size()>=0&&this.getInCureNow()>=1&&(turnsLeft==12||turnsLeft==4)) ||
           ((this.getLatestCheckup()==null||this.checkupTooLongAgo())&&(turnsLeft>=12))){
            needed = true;
        }
        return needed;
    }
}
