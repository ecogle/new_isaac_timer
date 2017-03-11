package sample;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ecogle on 3/11/2017.
 */
public class Labels {

    private Map<String,Label> myLabels;

    public Map<String,Label> getMyLabels(){

        Font labels = new Font("Comic Sans MS",18);
        Label lblTimeNow = new Label("Time started: ");
        lblTimeNow.setFont(labels);
        Label lblTimeLeft = new Label("Time left: ");
        lblTimeLeft.setFont(labels);

        myLabels = new HashMap<>();
        myLabels.put("TimeNow",lblTimeNow);
        myLabels.put("TimeLeft",lblTimeLeft);
        return myLabels;
    }


}
