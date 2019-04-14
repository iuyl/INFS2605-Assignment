/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *
 * @author aiisonsuherly
 */
public class FXMLDashboardController implements Initializable {
    
    @FXML
    private Label dashboard;
    
    @FXML
    private Label health;
    
    @FXML
    private Label fitness;
    
    @FXML
    private ProgressBar HealthProg;
    
    @FXML
    private ProgressBar LeanFatProg;
    
    @FXML
    private ProgressBar BMIProg;
    
    @FXML
    private ProgressBar WellbeingProg;
    
    @FXML
    private ProgressBar GymAttendanceProg;
    
    @FXML
    private ProgressBar StepProg;
    
    @FXML
    private ProgressBar RestingHeartProg;
    
    @FXML
    private ProgressBar CaloriesProg;
    
    @FXML
    private ProgressBar FlightsProg;
    
    @FXML
    private ProgressBar ResistanceProg;
    
    @FXML
    private ProgressBar SleepProg;
    
    @FXML
    private Label HealthGoal;
    
    @FXML
    private Label LeanFatGoal;
    
    @FXML
    private Label BMIGoal;
    
    @FXML
    private Label WellbeingGoal;
    
    @FXML
    private Label GymAttendanceGoal;
    
    @FXML
    private Label StepGoal;
    
    @FXML
    private Label RestingHeartGoal;
    
    @FXML
    private Label CaloriesGoal;
    
    @FXML
    private Label FlightsGoal;
    
    @FXML
    private Label ResistanceGoal;
    
    @FXML
    private Label SleepGoal;
    
    @FXML
    private DatePicker datePicker;
    
    
    @FXML
    void handleBackAction(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("HomePage.fxml"));
            Parent root1;
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            } catch (Exception e) {
            
        }
    }
    void updateProgressBar(ProgressBar progressBar, String stat) throws SQLException {
        LocalDate date = datePicker.getValue();
        String dateAsString = date.toString();
        
        double progress = DatabaseHelper.getProgress(stat, dateAsString);
        System.out.println("Progress " + progress + " for " + stat);
        progressBar.setProgress(progress);
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        HashMap<String, ProgressBar> statsMap = new HashMap<String,ProgressBar>();
        statsMap.put("BMI", BMIProg);
        statsMap.put("Last Health Check", HealthProg);
        statsMap.put("Lean/Fat Mass Ratio", LeanFatProg);
        statsMap.put("Overall Wellbeing", WellbeingProg);
        statsMap.put("Sleep Rating", SleepProg);
        statsMap.put("Resting Heart Rate", RestingHeartProg);
        statsMap.put("Calories Consumed", CaloriesProg);
        statsMap.put("Gym Attendance", GymAttendanceProg);
        statsMap.put("Step Count", StepProg);
        statsMap.put("Flights (Stairs) Climbed", FlightsProg);
        statsMap.put("Resistance Exercise Mass", ResistanceProg);
        
        datePicker.setValue(LocalDate.now());
        
        try {
                for (HashMap.Entry<String, ProgressBar> entry : statsMap.entrySet()) {
                    try {
                        updateProgressBar(entry.getValue(), entry.getKey());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                
                BMIGoal.setText(String.valueOf(DatabaseHelper.getGoal("BMI")));
                HealthGoal.setText(String.valueOf(DatabaseHelper.getGoal("Last Health Check")));
                LeanFatGoal.setText(String.valueOf(DatabaseHelper.getGoal("Lean/Fat Mass Ratio")));
                WellbeingGoal.setText(String.valueOf(DatabaseHelper.getGoal("Overall Wellbeing")));
                SleepGoal.setText(String.valueOf(DatabaseHelper.getGoal("Sleep Rating")));
                RestingHeartGoal.setText(String.valueOf(DatabaseHelper.getGoal("Resting Heart Rate")));
                CaloriesGoal.setText(String.valueOf(DatabaseHelper.getGoal("Calories Consumed")));
                GymAttendanceGoal.setText(String.valueOf(DatabaseHelper.getGoal("Gym Attendance")));
                StepGoal.setText(String.valueOf(DatabaseHelper.getGoal("Step Count")));
                FlightsGoal.setText(String.valueOf(DatabaseHelper.getGoal("Flights (Stairs) Climbed")));
                ResistanceGoal.setText(String.valueOf(DatabaseHelper.getGoal("Resistance Exercise Mass")));
                
            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        
        datePicker.setOnAction((ActionEvent e) -> {
            
            try {
                for (HashMap.Entry<String, ProgressBar> entry : statsMap.entrySet()) {
                    try {
                        updateProgressBar(entry.getValue(), entry.getKey());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                
                BMIGoal.setText(String.valueOf(DatabaseHelper.getGoal("BMI")));
                HealthGoal.setText(String.valueOf(DatabaseHelper.getGoal("Last Health Check")));
                LeanFatGoal.setText(String.valueOf(DatabaseHelper.getGoal("Lean/Fat Mass Ratio")));
                WellbeingGoal.setText(String.valueOf(DatabaseHelper.getGoal("Overall Wellbeing")));
                SleepGoal.setText(String.valueOf(DatabaseHelper.getGoal("Sleep Rating")));
                RestingHeartGoal.setText(String.valueOf(DatabaseHelper.getGoal("Resting Heart Rate")));
                CaloriesGoal.setText(String.valueOf(DatabaseHelper.getGoal("Calories Consumed")));
                GymAttendanceGoal.setText(String.valueOf(DatabaseHelper.getGoal("Gym Attendance")));
                StepGoal.setText(String.valueOf(DatabaseHelper.getGoal("Step Count")));
                FlightsGoal.setText(String.valueOf(DatabaseHelper.getGoal("Flights (Stairs) Climbed")));
                ResistanceGoal.setText(String.valueOf(DatabaseHelper.getGoal("Resistance Exercise Mass")));
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        });
        
    }
}
