package sample;

/**
 * Created by ecogle on 3/10/2017.
 */
public class ActivityBuilder {

    Activity activity = new Activity();

    public ActivityBuilder setActivityId(int x){
        activity.setActivityId(x);
        return this;
    }

    public ActivityBuilder setStartTime(String s){
        activity.setStartTime(s);
        return this;
    }

    public ActivityBuilder setEndTime(String s){
        activity.setEndTime(s);
        return this;
    }

    public ActivityBuilder setTotalMin(int x){
        activity.setTotalMinutes(x);
        return this;
    }

    public ActivityBuilder setFkClassId(int x){
        activity.setFkClassId(x);
        return this;
    }

    public ActivityBuilder setDate(String s){
        activity.setDate(s);
        return this;
    }

    public ActivityBuilder setDeleted(int x){
        activity.setDeleted(x);
        return this;
    }



    public Activity build(){
        return this.activity;
    }
}
