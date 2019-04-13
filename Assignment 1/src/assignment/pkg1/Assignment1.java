/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author aiisonsuherly
 */
public class Assignment1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        
=======
        connect();
        insertCategories();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

>>>>>>> 5bc20147b2b08b5e178bdf5c6cf112c2500d4120
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void connect() throws SQLException {
        //write the four lines which connect your program to the database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();

        String createQuery = "CREATE TABLE IF NOT EXISTS Stats "
                + "(ID INTEGER PRIMARY KEY autoincrement, "
                + "CATEGORY TEXT NOT NULL, "
                + "GOAL INTEGER NULL "
                + ");";

        st.execute(createQuery);

        createQuery = "CREATE TABLE IF NOT EXISTS StatsEntries "
                + "(ID INTEGER PRIMARY KEY autoincrement, "
                + "STATS_ID INTEGER NOT NULL, "
                + "VALUE INTEGER NOT NULL, "
                + "DATE TEXT NULL "
                + ");";

        st.execute(createQuery);

        st.close();
        conn.close();
    }
    
 public static void insertCategories() throws SQLException{
		//write the SQL query and the java code to insert all categories
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();
        
        String insertLastHealthCheck = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (1, 'Last Health Check');";
        st.execute(insertLastHealthCheck);
        
        String insertLeanFatRatio = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (2, 'Lean/Fat Mass Ratio');";
        st.execute(insertLeanFatRatio);
        
        String insertBMI = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (3, 'BMI');";
        st.execute(insertBMI);
        
        String insertWellbeing = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (4, 'Overall Wellbeing');";
        st.execute(insertWellbeing);

        String insertSleepRating = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (5, 'Sleep Rating');";
        st.execute(insertSleepRating);
        
        String insertRestingHeartRate = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (6, 'Resting Heart Rate');";
        st.execute(insertRestingHeartRate);
        
        String insertCaloriesConsumed = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (7, 'Calories Consumed');";
        st.execute(insertCaloriesConsumed);
        
        String insertGymAttendance = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (8, 'Gym Attendance');";
        st.execute(insertGymAttendance);
        
        String insertStepCount = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (9, 'Step Count');";
        st.execute(insertStepCount);
        
        String insertFlights = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (10, 'Flights (Stairs) Climbed');";
        st.execute(insertFlights);
        
        String insertResistanceMass = "INSERT OR IGNORE INTO Stats (ID, CATEGORY) "
                + "VALUES (11, 'Resistance Exercise Mass');";
        st.execute(insertResistanceMass);
        
        
        st.close();
        conn.close();   

    //In javafx class (view controller)
    //private void OnSaveClicked() {
    //StatEntry newEntry = new StatEntry( type, volume );
    //DatabaseHelper.addNewStatEntry(newEntry);
}
}
