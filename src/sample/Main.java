package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.*;

public class Main extends Application {
    Label diTimeNow,diTimeLeft;
    ScheduledFuture everySecond;
    LocalDateTime start,end;

    RadioButton radIready,radLexia,radCode;
    Button btnStart,btnEnd,btnReset;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage window = primaryStage;
        window.setOnCloseRequest(event -> {
            System.exit(-1);
        });
        Font labels = new Font("Comic Sans MS",18);
        Border border = new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(1)));

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(8));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setBorder(border);
        layout.setPrefWidth(400);
        layout.setAlignment(Pos.CENTER);

        layout.setGridLinesVisible(false);

        Label lblTimeNow = new Label("Time started: ");
        lblTimeNow.setFont(labels);
        Label lblTimeLeft = new Label("Time left: ");
        lblTimeLeft.setFont(labels);

        btnStart = new Button("Start");
        btnStart.setPrefWidth(100);
        btnStart.setPrefHeight(35);

        btnEnd = new Button("End");
        btnEnd.setPrefWidth(100);
        btnEnd.setPrefHeight(35);

        btnReset = new Button("Reset");
        btnReset.setPrefWidth(100);
        btnReset.setPrefHeight(35);

        diTimeNow = new Label();
        diTimeNow.setFont(labels);
        diTimeNow.setTextFill(Color.INDIANRED);
        diTimeNow.setPrefWidth(100);



        diTimeLeft = new Label();
        diTimeLeft.setFont(labels);
        diTimeLeft.setTextFill(Color.INDIANRED);
        diTimeLeft.setPrefWidth(100);



        //******************************************************************
        //**                    Radio Buttons                             **
        //******************************************************************
        ToggleGroup tgClasses = new ToggleGroup();

        radIready = new RadioButton("iReady");
        radIready.setToggleGroup(tgClasses);
        radIready.setFont(labels);


        radLexia = new RadioButton("Lexia");
        radLexia.setToggleGroup(tgClasses);
        radLexia.setFont(labels);

        radCode = new RadioButton("Code");
        radCode.setToggleGroup(tgClasses);
        radCode.setFont(labels);

        //******************************************************************
        //**                Container for Rad Buttons                     **
        //******************************************************************
        VBox vbRadBtns = new VBox();
        vbRadBtns.getChildren().addAll(radIready,radLexia,radCode);
        vbRadBtns.setPadding(new Insets(8));
        vbRadBtns.setSpacing(10);

        layout.add(lblTimeNow,0,0); layout.add(diTimeNow,1,0);
        layout.add(lblTimeLeft,0,1); layout.add(diTimeLeft,1,1);
        layout.add(vbRadBtns,2,0,1,2);

        layout.add(btnStart,0,3);layout.add(btnEnd,0,3);
        layout.add(btnReset,2,3);

        btnEnd.setVisible(false);

        btnStart.setDisable(false);
        btnEnd.setDisable(true);
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(6);

        //******************************************************************
        //**                      Event Handlers                          **
        //******************************************************************
        btnStart.setOnAction(event -> {
            // Start the timer

            if(tgClasses.getSelectedToggle() != null){
                start = LocalDateTime.now();
                btnStart.setVisible(false);
                btnEnd.setVisible(true);
                btnEnd.setDisable(true);
                everySecond = pool.scheduleAtFixedRate(() -> {
                    Platform.runLater(()->{
                        diTimeNow.setText(start.format(DateTimeFormatter.ofPattern("h:mm a")));
                        diTimeLeft.setText(getTimeLeft());
                        if(getTimeLeft().equals("0:00")){
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("Finished with this one!");
                            a.show();
                            everySecond.cancel(true);
                            btnEnd.setDisable(false);
                            radCode.setDisable(false);
                            radIready.setDisable(false);
                            radLexia.setDisable(false);
                        }
                    });
                },0,1, TimeUnit.SECONDS);

                radCode.setDisable(true);
                radIready.setDisable(true);
                radLexia.setDisable(true);
            }
        });

        btnEnd.setOnAction(event -> {
            everySecond.cancel(true);
            btnEnd.setVisible(false);
            btnStart.setVisible(true);
            end = LocalDateTime.now();

            long min = ChronoUnit.SECONDS.between(start,end);

            System.out.println(Classes.IREADY.getMinutes());

            Activity a = new ActivityBuilder()
                    .setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .setStartTime(start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .setEndTime(end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .setTotalMin((int)ChronoUnit.MINUTES.between(start,end))
                    .setFkClassId(getClassId())
                    .build();

            new DBController().addActivity(a);
            //clear the variables
            everySecond = null;
            start = null;
            diTimeNow.setText("");
            diTimeLeft.setText("");
        });

        tgClasses.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(tgClasses.getSelectedToggle() != null){
                    btnStart.setDisable(false);
                    btnEnd.setDisable(false);


                }
            }
        });

        btnReset.setOnAction(event -> {
            everySecond.cancel(true);
            everySecond = null;
            start = null;
            diTimeNow.setText("");
            diTimeLeft.setText("");
            radCode.setDisable(false);
            radIready.setDisable(false);
            radLexia.setDisable(false);
            btnEnd.setVisible(false);
            btnStart.setVisible(true);
        });


        Scene scene = new Scene(layout,600,175);
        window.setScene(scene);
        window.show();
    }




    private int getTargetTime(){
        int target = 0;
        if(radIready.isSelected()){
            target = Classes.IREADY.getMinutes();
        }
        else if(radCode.isSelected()){
            target = Classes.CODE.getMinutes();
        }
        else if(radLexia.isSelected()){
            target = Classes.LEXIA.getMinutes();
        }

        return target;
    }

    private int getClassId(){
        int id=0;
        if(radIready.isSelected()){
            id = 1;
        }
        else if(radLexia.isSelected()){
            id=2;
        }
        else{
            id=3;
        }
        return id;
    }

    private String getTimeLeft(){

        // time left definition:
        /*
            (target time) - (elapsed time).
         */

        //long diff = ChronoUnit.SECONDS.between(start,LocalDateTime.now()); // elapsed time
        LocalDateTime targ = LocalDateTime.of(LocalDate.now(),LocalTime.of(0,getTargetTime()));
        long t = ChronoUnit.NANOS.between(start,LocalDateTime.now());

        LocalDateTime dif = targ.minusNanos(t);


        return dif.format(DateTimeFormatter.ofPattern("m:ss"));


    }

    private long getElapsedTime(){

        //elapsed time:
        /*
            (now time) - (start time)
         */

        long time = ChronoUnit.SECONDS.between(LocalDateTime.now(),start);
        return time*-1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
