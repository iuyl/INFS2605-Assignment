/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import javafx.scene.text.Text;



/**
 *
 * @author yilian
 */
public final class DatabaseHelper {

    
    private DatabaseHelper() { }
    
    public static void addNewStatEntry(String category, int value, String date) throws SQLException {
        //Do SQL query to add new entry, do connect statement for each tine and close
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();
        System.out.println(category);
        String getStatsId = "SELECT ID as STATS_ID from Stats where CATEGORY like '" + category + "'";
        ResultSet idResult = st.executeQuery(getStatsId);
        
        int statsId = idResult.getInt("STATS_ID");
        String addNewStatEntry = "INSERT INTO StatsEntries (STATS_ID, VALUE, DATE) "
                + "VALUES (" + statsId + ","+ value + ",'" + date + "')"; 
        
        System.out.println(addNewStatEntry);
        
        st.execute(addNewStatEntry);

        st.close();
        conn.close();
    }
    
    public static void setGoal(String category, int newGoalValue) throws SQLException {
        //Do SQL query to add new entry, do connect statement for each tine and close
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();
        
        String setGoal = "UPDATE Stats SET GOAL = "
                + newGoalValue + " where CATEGORY like '" + category + "'";
        st.execute(setGoal);

        st.close();
        conn.close();
        
    }
    
    public static int getGoal(String stat) throws SQLException {
        //Do SQL query to add new entry, do connect statement for each tine and close
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();

        
        String getGoal = "SELECT GOAL as GOAL from stats where CATEGORY like '" + stat + "'";
        ResultSet goalResult = st.executeQuery(getGoal);
        
        int goal = goalResult.getInt("GOAL"); //attn

        st.close();
        conn.close();
        
        if (goal == 0) {
            goal = 1;
        }
        
        System.out.println("Goal is " + goal + " for " + stat);
        
        return goal;
    }
    
    public static double getProgress(String stat, String date) throws SQLException {
        //Do SQL query to add new entry, do connect statement for each tine and close
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();
        
        String getStatsId = "SELECT ID as STATS_ID from stats where CATEGORY like '" + stat + "'";
        ResultSet idResult = st.executeQuery(getStatsId);
        
        int statsId = idResult.getInt("STATS_ID"); //attn
        
        String getProgress = "SELECT SUM(value) as progress from StatsEntries where STATS_ID = " + statsId
                                + " and date like '" + date + "'";
        ResultSet progressResult = st.executeQuery(getProgress);
        
        int progress = progressResult.getInt("progress"); //attn

        st.close();
        conn.close();
        
        System.out.println(getProgress);
        System.out.println("Progress as " + progress + " for " + stat);
        
        return (double)progress/getGoal(stat);
        
        //for displaying individual categories, call this method but pass in different 'stat' parameters
        
    }
}
