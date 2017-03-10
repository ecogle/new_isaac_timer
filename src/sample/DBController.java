package sample;

import javax.sql.DataSource;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ecogle on 3/10/2017.
 */
public class DBController {

    private DataSource getDataSource(){
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setDatabaseName("isaac_timer.sqlite");
        return ds;
    }

    public static void main(String[] args) {
        try(Connection conn = new DBController().getDataSource().getConnection()) {
            System.out.println("SUCCESS!!!");
        }
        catch (SQLException e){

        }
    }

    public boolean addActivity(Activity a){

        if(true){
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
