package sample;

/**
 * Created by ecogle on 3/11/2017.
 */
public enum Classes {

    IREADY(15),LEXIA(10),CODE(15);
    private int minutes;

    Classes(int min){
        this.minutes = min;
    }

    public int getMinutes(){
        return this.minutes;
    }
}
