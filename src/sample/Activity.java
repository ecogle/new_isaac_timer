package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by ecogle on 3/10/2017.
 */
public class Activity {

    public SimpleIntegerProperty activityId = new SimpleIntegerProperty();
    public SimpleStringProperty startTime = new SimpleStringProperty();
    public SimpleStringProperty endTime = new SimpleStringProperty();
    public SimpleIntegerProperty totalMinutes = new SimpleIntegerProperty();
    public SimpleIntegerProperty fkClassId = new SimpleIntegerProperty();
    public SimpleStringProperty date = new SimpleStringProperty();
    public SimpleIntegerProperty deleted = new SimpleIntegerProperty();

    public void setActivityId(int x){
        this.activityId.set(x);
    }
    public  void setStartTime(String s){
        this.startTime.set(s);
    }
    public void setEndTime(String s){
        this.endTime.set(s);
    }
    public void setTotalMinutes(int x){
        this.totalMinutes.set(x);
    }
    public void setFkClassId(int x){
        this.fkClassId.set(x);
    }
    public void setDate(String s){
        this.date.set(s);
    }
    public void setDeleted(int x){
        this.deleted.set(x);
    }
    public int getActivityId(){
        return this.activityId.get();
    }
    public String getStartTime(){
        return this.startTime.get();
    }
    public String getEndTime(){
        return this.endTime.get();
    }
    public int getTotalMinutes(){
        return this.totalMinutes.get();
    }
    public int getFkClassId(){
        return this.fkClassId.get();
    }
    public String getDate(){
        return this.date.get();
    }
    public int getDeleted(){
        return this.deleted.get();
    }
}
