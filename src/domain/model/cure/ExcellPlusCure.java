package domain.model.cure;

import domain.model.measures.Checkup;
import domain.model.visit.Visit;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcellPlusCure implements Serializable {
    private Date cureStart;
    private int turnsLeft;
    private List<Visit> visits;

    public ExcellPlusCure() {
        visits = new ArrayList<>();
        turnsLeft = 0;
        setCureStart();
    }

    public ExcellPlusCure(Date cureStart, int turnsLeft){
        setCureStart(cureStart);
        setTurnsLeft(turnsLeft);
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    private void setTurnsLeft(int turnsLeft) {
        this.turnsLeft = turnsLeft;
    }

    public Date getCureStart() {
        return cureStart;
    }

    public void setCureStart(Date cureStart) {
        this.cureStart = cureStart;
    }

    public void setCureStart() {
        this.cureStart = new Date(System.currentTimeMillis());
    }

    public void addTurnsToCure(int turns) {
        if(turns!=0) {
            this.turnsLeft =this.turnsLeft+turns;
        }
    }

    public void startCureOneTime(){
        Visit visit = new Visit();
        visits.add(visit);
        turnsLeft--;
    }

    /*public void doCheckUp(double weight, double length){
        checkups.add(new Checkup(weight,length));
    }*/

    public List<Checkup> getAllCheckUps(){
        List<Checkup> checkups = new ArrayList<>();
        for(Visit v : visits) checkups.add(v.getCheckup());
        return checkups;
    }

    public Visit getLatestVisitWithCheckup(){
        Visit latestVisitWithCheckup = null;
        List<Checkup> checkups = this.getAllCheckUps();
        if(checkups==null||checkups.isEmpty()) {
            return null;
        }else{
            for (Visit v: visits) {
                if(latestVisitWithCheckup==null||v.getMoment().after(latestVisitWithCheckup.getMoment())){
                    latestVisitWithCheckup = v;
                }
            }
        }
        return latestVisitWithCheckup;
    }

    public Checkup getLatestCheckup(){
        return getLatestVisitWithCheckup().getCheckup();
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public boolean checkupTooLongAgo(){
            Date current = new Date(System.currentTimeMillis());
            LocalDate today =  LocalDate.now();
            LocalDate latest = getLatestVisitWithCheckup().getMoment().toLocalDateTime().toLocalDate();
            Period between = Period.between(today,latest);
            if(between.getMonths()>=2) {
                return true;
            }else{
                return false;
            }
        }

}
