package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage window = primaryStage;
        Font labels = new Font("Comic Sans MS",18);
        Border border = new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(1)));

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(8));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setBorder(border);
        layout.setPrefWidth(400);
        layout.setAlignment(Pos.CENTER);

        Label lblTimeNow = new Label("Time started: ");
        lblTimeNow.setFont(labels);
        Label lblTimeLeft = new Label("Time left: ");
        lblTimeLeft.setFont(labels);

        Button btnStart = new Button("Start");
        btnStart.setPrefWidth(100);
        btnStart.setPrefHeight(35);

        Label diTimeNow = new Label();
        diTimeNow.setFont(labels);
        diTimeNow.setTextFill(Color.INDIANRED);
        Label diTimeLeft = new Label();

        //******************************************************************
        //**                    Radio Buttons                             **
        //******************************************************************
        ToggleGroup tgClasses = new ToggleGroup();

        RadioButton radIready = new RadioButton("iReady");
        radIready.setToggleGroup(tgClasses);
        radIready.setFont(labels);

        RadioButton radLexia = new RadioButton("Lexia");
        radLexia.setToggleGroup(tgClasses);
        radLexia.setFont(labels);

        RadioButton radCode = new RadioButton("Code");
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
        layout.add(btnStart,1,3);

        diTimeNow.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a")));
        Scene scene = new Scene(layout,400,175);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
