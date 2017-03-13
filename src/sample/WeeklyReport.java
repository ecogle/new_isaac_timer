package sample;

import java.sql.ResultSet;
import java.time.LocalDate;

public class WeeklyReport {

    public void display(){
        
        ReportController rc = new ReportController();
        
        ResultSet rs = rc.getWeeklyReport(LocalDate.now());
    }
    
    public static void main(String... args){
        WeeklyReport wr = new WeeklyReport();
        wr.display();
    }
}
