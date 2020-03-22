package domain.model.cure;

import domain.model.debug.DomainException;
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
    private int turnsLeft,turnsTotal;
    private List<Visit> visits;
    private Visit latestVisit;

    public ExcellPlusCure() {
        visits = new ArrayList<>();
        turnsLeft = 0;
        setCureStart();
    }

    public ExcellPlusCure(Date cureStart, int turnsLeft,int turnsTotal){
        this();
        setCureStart(cureStart);
        setTurnsLeft(turnsLeft);
        setTurnsTotal(turnsTotal);
        setLatestVisit();
    }

    public int getTurnsTotal() {
        return turnsTotal;
    }

    public void setTurnsTotal(int turnsTotal) {
        this.turnsTotal = turnsTotal;
    }

    public boolean isTestCure() {
        if(turnsTotal==1){
            return true;
        }else {
            return false;
        }
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
        setLatestVisit();
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

    public void startNewVisit(Visit newVisit){
        if(turnsLeft>0){
            visits.add(newVisit);
            turnsLeft--;
        }else{
            throw new DomainException("Visit can't be added to this cure: no turns left!");
        }
    }

    /*public void startCureOneTime(){
        Visit visit = new Visit();
        visits.add(visit);
        turnsLeft--;
    }*/

    /*public void doCheckUp(double weight, double length){
        checkups.add(new Checkup(weight,length));
    }*/

    public List<Checkup> getAllCheckUps(){
        List<Checkup> checkups = new ArrayList<>();
        if(this.visits!=null||!this.visits.isEmpty()){
            for(Visit v : visits) {
                try {
                    checkups.add(v.getCheckup());
                }catch (Exception e){

                }
            }
        }
        return checkups;
    }

    public Visit setLatestVisit(){
        Visit latestVisit = null;
        if(this.visits!=null||!this.visits.isEmpty()){
            for(Visit v : visits) {
                if(latestVisit==null||latestVisit.getMoment().before(v.getMoment())){
                    latestVisit=v;
                }
            }
        }
        return latestVisit;
    }

    public Visit getTodaysVisit(){
        Visit todaysVisit = null;
        if(getLatestVisit().getMoment().toLocalDateTime().equals(LocalDate.now())){
            todaysVisit = getLatestVisit();
        }
        return todaysVisit;
    }

    public Visit getLatestVisitWithCheckup(){
        Visit latestVisitWithCheckup = null;
        if(this.getAllCheckUps()==null||this.getAllCheckUps().isEmpty()) {
            return null;
        }else{

            for (Visit v: this.getVisits()) {
                if(latestVisitWithCheckup==null||v.getMoment().after(latestVisitWithCheckup.getMoment())){
                    latestVisitWithCheckup = v;
                }
            }
        }
        return latestVisitWithCheckup;
    }

    public Checkup getLatestCheckup(){
        if(getLatestVisitWithCheckup()==null||getLatestVisitWithCheckup().getCheckup()==null){
            return  null;
        }else{
            return getLatestVisitWithCheckup().getCheckup();
        }

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

    public List<Visit> getVisits() {
        return visits;
    }

    public Visit getLatestVisit(){
        return latestVisit;
    }
}
