package domain.model.personal;

public class Sport {
    private int timesPerWeek;
    private String sportName;


    public Sport() {

    }

    public Sport(int timesPerWeek, String sportName) {
        this.timesPerWeek = timesPerWeek;
        this.sportName = sportName;
    }

    public int getTimesPerWeek() {
        return timesPerWeek;
    }

    public void setTimesPerWeek(int timesPerWeek) {
        this.timesPerWeek = timesPerWeek;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
