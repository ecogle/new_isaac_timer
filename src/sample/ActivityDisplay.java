package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by ecogle on 3/14/2017.
 */
public class ActivityDisplay extends Activity {

    SimpleStringProperty className = new SimpleStringProperty();

    public void setClassName(String s){
        this.className.set(s);
    }

    public String getClassName(){
        return this.className.get();
    }
}
