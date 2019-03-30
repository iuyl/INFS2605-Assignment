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
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        try {
            connect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void connect() throws SQLException{
		//write the four lines which connect your program to the database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessDatabase.db");
        Statement st = conn.createStatement();
        String createQuery = "CREATE TABLE IF NOT EXISTS Members "
                + "(ID INTEGER PRIMARY KEY autoincrement, "
                + "NAME TEXT NOT NULL "

                +");";
        
                st.execute(createQuery);  

        
        createQuery = "CREATE TABLE IF NOT EXISTS Stats "
                + "(ID INTEGER PRIMARY KEY autoincrement, "
                + "MEMBER_ID INTEGER NOT NULL, "
                + "CATEGORY TEXT NOT NULL, "
                + "GOAL TEXT NULL "

                +");";
        
                st.execute(createQuery);  
                
        createQuery = "CREATE TABLE IF NOT EXISTS Stats "
                + "(ID INTEGER PRIMARY KEY autoincrement, "
                + "STATS_ID INTEGER NOT NULL, "
                + "VALUE TEXT NOT NULL, "
                + "DATE TEXT NULL "

                +");";
        
                st.execute(createQuery);  

        
            
        st.close();
        conn.close();
	}
	
	
	
    
    
    
}
