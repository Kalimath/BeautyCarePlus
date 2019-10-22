package domain.model;

import java.util.Random;

public class RandomIdGenerator {
    private int range;
    public RandomIdGenerator(int range) {
        setRange(range);
    }
    public RandomIdGenerator( ) {
        this(0);
    }

    private void setRange(int range) {
        if(range==0&&range>=100){
            this.range = 2000;
        }else {
            this.range = range;
        }
    }


    public Integer getRandomId(){
        return new Random().nextInt();
    }

}
