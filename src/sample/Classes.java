package sample;

/**
 * Created by ecogle on 3/11/2017.
 */
public enum Classes {

    IREADY(1),LEXIA(1),CODE(1);
    private int minutes;

    Classes(int min){
        this.minutes = min;
    }

    public int getMinutes(){
        return this.minutes;
    }
}
