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
    public DataSource getDataSource(){
        SQLiteDataSource ds = new SQLiteDataSource();
        Path base = Paths.get(System.getProperty("user.dir"));
        ds.setUrl("jdbc:sqlite:isaac_timer.sqlite");
        return ds;
    }

    public static void main(String[] args) {
        DBController db = new DBController();
        try(Connection conn = db.getDataSource().getConnection()) {
            System.out.println("SUCCESS!!!");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        //System.out.println(System.getProperty("user.dir"));
    }

    public void addActivity(Activity a){

        //Connection conn = new DBController().getDataSource().getConnection()
        DataSource ds = new DBController().getDataSource();
        try(Connection conn = ds.getConnection()){
            Statement stmnt = conn.createStatement();
            String sql = new String("insert into activity (startTime,endTime,totalMinutes,fkClassID,date) values" +
                    "('"+a.getStartTime()+"','"+a.getEndTime()+"',"+a.getTotalMinutes()+","+a.getFkClassId()+",'"+a.getDate()+"')");
            success = stmnt.execute(sql);

        }
        catch (SQLException e){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setContentText(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception r){
            r.printStackTrace();
        }
        catch (Error r){
            r.printStackTrace();
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
