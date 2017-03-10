package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage window = primaryStage;

        GridPane layout = new GridPane();




        Scene scene = new Scene(layout,400,400);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
