package sample;

/**
 * Created by ecogle on 3/11/2017.
 */
public enum Classes {

    IREADY(10),LEXIA(15),CODE(15);
    private int minutes;

    Classes(int min){
        this.minutes = min;
    }

    public int getMinutes(){
        return this.minutes;
    }
}
