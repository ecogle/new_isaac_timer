package sample;

import javax.sql.DataSource;

import javafx.scene.control.Alert;
import org.sqlite.SQLiteDataSource;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ecogle on 3/10/2017.
 */
public class DBController {
    boolean success;
    private DataSource getDataSource(){
        SQLiteDataSource ds = new SQLiteDataSource();
        Path base = Paths.get(System.getProperty("user.dir"));
        ds.setUrl("jdbc:sqlite:src/isaac_timer.sqlite");
        return ds;
    }

    public static void main(String[] args) {
        try(Connection conn = new DBController().getDataSource().getConnection()) {
            System.out.println("SUCCESS!!!");
        }
        catch (SQLException e){

        }
        //System.out.println(System.getProperty("user.dir"));
    }

    public boolean addActivity(Activity a){

        try(Connection conn = new DBController().getDataSource().getConnection()){
            Statement stmnt = conn.createStatement();
            String sql = new String("insert into activity (startTime,endTime,totalMinutes,fkClassID,date) values" +
                    "('"+a.getStartTime()+"','"+a.getEndTime()+"',"+a.getTotalMinutes()+","+a.getFkClassId()+",'"+a.getDate()+"')");
            success = stmnt.execute(sql);

        }
        catch (SQLException e){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setContentText("There is a SQL Error");
        }
        if(success){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean delActivity(Activity a){
        if(true){
            return true;
        }
        else {
            return false;
        }
    }

}
