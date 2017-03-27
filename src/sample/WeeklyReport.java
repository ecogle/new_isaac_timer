package sample;

import java.sql.ResultSet;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WeeklyReport{

    public void display(){
        
        Stage window = new Stage();
        
        window.setTitle("This is a test of the weekly report");
        StackPane layout = new StackPane();
        
        
        TableView<ActivityDisplay> tbTableView = new TableView<>();
        TableColumn colDate = new TableColumn("Date");
        TableColumn colClass = new TableColumn("Class");
        tbTableView.getColumns().addAll(colDate,colClass);
        
        layout.getChildren().add(tbTableView);
        
        Scene scene = new Scene(layout,450,400);
        window.setScene(scene);
        window.show();
    }
    
    
    
    
    
}
