package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.scene.control.Alert;

public class ReportController {
    private Activity activity;
    
    public ReportController(Activity a){
        this.activity = a;
    }
    
    public ReportController(){
        super();
    }
    
    
    public ResultSet getWeeklyReport(LocalDate date){
        DBController db = new DBController();
        try(Connection conn = db.getDataSource().getConnection()){
            String sql = "select * from activity";
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(sql);
            return rs;
        }
        catch(SQLException e){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setTitle("Error");
            alt.setContentText("SQL Error");
            
        }
        return null;
    }
    
    public LocalDate getStartOfWeek(LocalDate ld){
        switch (ld.getDayOfWeek().toString()){
            case "SUNDAY":
                return ld.plusDays(1);
            case "MONDAY":
                return ld;
            case "TUESDAY":
                return ld.minusDays(1);
            case "WEDNESDAY":
                return ld.minusDays(2);
            case "THURSDAY":
                return ld.minusDays(3);
            case "FRIDAY":
                return ld.minusDays(4);
            case "SATURDAY":
                return ld.minusDays(5);

        }
        return LocalDate.now();
    }

}
