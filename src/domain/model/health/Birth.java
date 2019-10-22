package domain.model.health;

import domain.model.ObjectWithId;

import java.time.LocalDate;
import java.util.Random;

public class Birth {
    private LocalDate birthDate;
    private boolean isCesarean;

    public Birth() {

    }

    public Birth(LocalDate birthDate, boolean isCesarean) {
        this();
        setBirthDate(birthDate);
        setCesarean(isCesarean);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }


    public void setBirthDate(int day,int month, int year) {
        try {
            this.birthDate = LocalDate.of(year,month,day);
        }catch (Exception e){
            throw new IllegalArgumentException("date is invalid");
        }
    }

    public boolean isCesarean() {
        return isCesarean;
    }

    public void setCesarean(boolean cesarean) {
        isCesarean = cesarean;
    }
}
