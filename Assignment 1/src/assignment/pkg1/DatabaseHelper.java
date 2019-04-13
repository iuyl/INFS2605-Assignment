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
import java.util.Date;



/**
 *
 * @author yilian
 */
public final class DatabaseHelper {
    
    private DatabaseHelper() { }
    
    public static void addNewStatEntry(String category, int value, Date date) throws SQLException {
        //Do SQL query to add new entry, do connect statement for each tine and close
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();

        String getStatsId = "SELECT ID as STATS_ID from Stats where CATEGORY is like " + category;
        ResultSet idResult = st.executeQuery(getStatsId);
        
        int statsId = idResult.getInt("statsId");
        String addNewStatEntry = "INSERT INTO StatsEntries (STATS_ID, VALUE, DATE) "
                + "VALUES (" + statsId + ","+ value + "," + date + ")";  //convert date here to sqlite int
        

        
        st.execute(addNewStatEntry);

        st.close();
        conn.close();
    }
    
    public static void setGoal(String stat, int newGoalValue) throws SQLException {
        //Do SQL query to add new entry, do connect statement for each tine and close
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();

        
        String setGoal = "INSERT OR REPLACE INTO stats (goal) "
                + "VALUES (" + newGoalValue + ") where category is like " + stat;
        st.execute(setGoal);

        st.close();
        conn.close();
        
    }
    
    public static int getGoal(String stat) throws SQLException {
        //Do SQL query to add new entry, do connect statement for each tine and close
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();

        
        String getGoal = "SELECT goal as goal from stats where category is like " + stat;
        ResultSet goalResult = st.executeQuery(getGoal);
        
        int goal = goalResult.getInt("goal");

        st.close();
        conn.close();
        
        return goal;
    }
    
    public static float getProgress(String stat, Date date) throws SQLException {
        //Do SQL query to add new entry, do connect statement for each tine and close
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();

        int dateAsInt = 0; //parse date into int
        
        String getStatsId = "SELECT id as stats_Id from stats where category is like " + stat;
        ResultSet idResult = st.executeQuery(getStatsId);
        
        int statsId = idResult.getInt("statsId");
        
        String getProgress = "SELECT SUM(value) as progress from StatsEntries where STATS_ID = " + statsId
                                + "and date = " + dateAsInt;
        ResultSet progressResult = st.executeQuery(getProgress);
        
        int progress = progressResult.getInt("progress");

        st.close();
        conn.close();
        
        return progress/getGoal(stat);
        
        //for displaying individual categories, call this method but pass in different 'stat' parameters
        
    }
}
