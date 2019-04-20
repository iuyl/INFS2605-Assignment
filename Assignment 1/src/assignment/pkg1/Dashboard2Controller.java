/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aiisonsuherly
 */
public class Dashboard2Controller implements Initializable {

    @FXML
    private Label fitnessDashboard;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button back;
    @FXML
    private ProgressBar SleepProg;
    @FXML
    private Text SleepLabel;
    @FXML
    private Text SleepGoal;
    @FXML
    private ProgressBar WellbeingProg;
    @FXML
    private Text WellbeingLabel;
    @FXML
    private Text WellbeingGoal;
    @FXML
    private Text RestingHeartLabel;
    @FXML
    private Text RestingHeartGoal;
    @FXML
    private ProgressBar RestingHeartProg;
    @FXML
    private ProgressBar GymAttendanceProg;
    @FXML
    private Text GymAttendanceLabel;
    @FXML
    private Text GymAttendanceGoal;
    @FXML
    private ProgressBar StepProg;
    @FXML
    private ProgressBar ResistanceProg;
    @FXML
    private Text ResistanceLabel;
    @FXML
    private Text ResistanceGoal;
    @FXML
    private Text BMILabel;
    @FXML
    private ProgressBar LeanFatProg;
    @FXML
    private Text LeanFatLabel;
    @FXML
    private Text LeanFatGoal;
    @FXML
    private ProgressBar AerobicProg;
    @FXML
    private Text AerobicLabel;
    @FXML
    private Text AerobicGoal;
    @FXML
    private Text HealthLabel;
    @FXML
    private Text StepLabel;
    @FXML
    private Text StepGoal;
    @FXML
    private ProgressBar CaloriesProg;
    @FXML
    private Text FlightsLabel;
    @FXML
    private Text FlightsGoal;
    @FXML
    private ProgressBar FlightsProg;
    @FXML
    private Text CaloriesLabel;
    @FXML
    private Text CaloriesGoal;
    @FXML
    private Text BMIGoal;

    /**
     * Initializes the controller class.
     */
    void updateLabel(Text progressLabel, String stat) throws SQLException {
        LocalDate date = datePicker.getValue();
        String dateAsString = date.toString();

        double progress = DatabaseHelper.displayProgress(stat, dateAsString);
        System.out.println("Progress Label " + progress + " for " + stat);
        progressLabel.setText(String.valueOf(progress));
    }

    void updateProgressBar(ProgressBar progressBar, String stat) throws SQLException {
        LocalDate date = datePicker.getValue();
        String dateAsString = date.toString();

        double progress = DatabaseHelper.getProgress(stat, dateAsString);
        System.out.println("Progress " + progress + " for " + stat);
        progressBar.setProgress(progress);

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePicker.setValue(LocalDate.now());

        HashMap<String, ProgressBar> statsMap = new HashMap<String, ProgressBar>();
//        statsMap.put("BMI", BMIProg);
//        statsMap.put("Last Health Check", HealthProg);
        statsMap.put("Lean/Fat Mass Ratio", LeanFatProg);
        statsMap.put("Overall Wellbeing", WellbeingProg);
        statsMap.put("Sleep Rating", SleepProg);
        statsMap.put("Resting Heart Rate", RestingHeartProg);
        statsMap.put("Calories Consumed", CaloriesProg);
        statsMap.put("Gym Attendance", GymAttendanceProg);
        statsMap.put("Step Count", StepProg);
        statsMap.put("Flights (Stairs) Climbed", FlightsProg);
        statsMap.put("Resistance Exercise Mass", ResistanceProg);
        statsMap.put("Aerobic Exercise", AerobicProg);

        HashMap<String, Text> displayMap = new HashMap<String, Text>();
        displayMap.put("BMI", BMILabel);
        displayMap.put("Last Health Check", HealthLabel);
        displayMap.put("Lean/Fat Mass Ratio", LeanFatLabel);
        displayMap.put("Overall Wellbeing", WellbeingLabel);
        displayMap.put("Sleep Rating", SleepLabel);
        displayMap.put("Resting Heart Rate", RestingHeartLabel);
        displayMap.put("Calories Consumed", CaloriesLabel);
        displayMap.put("Gym Attendance", GymAttendanceLabel);
        displayMap.put("Step Count", StepLabel);
        displayMap.put("Flights (Stairs) Climbed", FlightsLabel);
        displayMap.put("Resistance Exercise Mass", ResistanceLabel);
        displayMap.put("Aerobic Exercise", AerobicLabel);
        
        try {
            for (HashMap.Entry<String, Text> entry : displayMap.entrySet()) {
                try {
                    updateLabel(entry.getValue(), entry.getKey());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            for (HashMap.Entry<String, ProgressBar> entry : statsMap.entrySet()) {
                try {
                    updateProgressBar(entry.getValue(), entry.getKey());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            BMIGoal.setText(String.valueOf(DatabaseHelper.getGoal("BMI")));
//            HealthGoal.setText(String.valueOf(DatabaseHelper.getGoal("Last Health Check")));
            LeanFatGoal.setText(String.valueOf(DatabaseHelper.getGoal("Lean/Fat Mass Ratio")));
            WellbeingGoal.setText(String.valueOf(DatabaseHelper.getGoal("Overall Wellbeing")));
            SleepGoal.setText(String.valueOf(DatabaseHelper.getGoal("Sleep Rating")));
            RestingHeartGoal.setText(String.valueOf(DatabaseHelper.getGoal("Resting Heart Rate")));
            CaloriesGoal.setText(String.valueOf(DatabaseHelper.getGoal("Calories Consumed")));
            GymAttendanceGoal.setText(String.valueOf(DatabaseHelper.getGoal("Gym Attendance")));
            StepGoal.setText(String.valueOf(DatabaseHelper.getGoal("Step Count")));
            FlightsGoal.setText(String.valueOf(DatabaseHelper.getGoal("Flights (Stairs) Climbed")));
            ResistanceGoal.setText(String.valueOf(DatabaseHelper.getGoal("Resistance Exercise Mass")));
            AerobicGoal.setText(String.valueOf(DatabaseHelper.getGoal("Aerobic Exercise")));

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        datePicker.setOnAction((ActionEvent e) -> {
            try {
                for (HashMap.Entry<String, Text> entry : displayMap.entrySet()) {
                    try {
                        updateLabel(entry.getValue(), entry.getKey());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                for (HashMap.Entry<String, ProgressBar> entry : statsMap.entrySet()) {
                    try {
                        updateProgressBar(entry.getValue(), entry.getKey());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                BMIGoal.setText(String.valueOf(DatabaseHelper.getGoal("BMI")));
//                HealthGoal.setText(String.valueOf(DatabaseHelper.getGoal("Last Health Check")));
                LeanFatGoal.setText(String.valueOf(DatabaseHelper.getGoal("Lean/Fat Mass Ratio")));
                WellbeingGoal.setText(String.valueOf(DatabaseHelper.getGoal("Overall Wellbeing")));
                SleepGoal.setText(String.valueOf(DatabaseHelper.getGoal("Sleep Rating")));
                RestingHeartGoal.setText(String.valueOf(DatabaseHelper.getGoal("Resting Heart Rate")));
                CaloriesGoal.setText(String.valueOf(DatabaseHelper.getGoal("Calories Consumed")));
                GymAttendanceGoal.setText(String.valueOf(DatabaseHelper.getGoal("Gym Attendance")));
                StepGoal.setText(String.valueOf(DatabaseHelper.getGoal("Step Count")));
                FlightsGoal.setText(String.valueOf(DatabaseHelper.getGoal("Flights (Stairs) Climbed")));
                ResistanceGoal.setText(String.valueOf(DatabaseHelper.getGoal("Resistance Exercise Mass")));
                AerobicGoal.setText(String.valueOf(DatabaseHelper.getGoal("Aerobic Exercise")));

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
    }    

    @FXML
    private void handleBackAction(ActionEvent event) {
            try{
            FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("HomePage.fxml"));
            Parent root1;
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
        }

    }
    
}
