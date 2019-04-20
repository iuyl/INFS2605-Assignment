/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author aiisonsuherly
 */
public class FXMLSetGoalController implements Initializable{

    @FXML
    private Label setGoal;

    @FXML
    private Text category;

    @FXML
    private ComboBox categoryMenu;

    @FXML
    private Label volume;

    @FXML
    private TextField volumeNumber;

    @FXML
    private Button back;

    @FXML
    private Button save;
    
    @FXML
    private Label savedLabel;

    @FXML
    void handleBackAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root1;
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {

        }
    }
    
    @FXML
    void handleSaveAction(ActionEvent event) {
        System.out.println("You clicked me!");
        savedLabel.setText("Hello World!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialising");
        categoryMenu.getItems().removeAll(categoryMenu.getItems());
        categoryMenu.getItems().addAll("Last Health Check", "Lean/Fat Mass Ratio", "BMI", "Overall Wellbeing", "Sleep Rating", "Resting Heart Rate", "Calories Consumed", "Gym Attendance", "Step Count", "Flights (Stairs) Climbed", "Resistance Exercise Mass", "Aerobic Exercise");

        save.setOnAction((ActionEvent e) -> {
            try {
                DatabaseHelper.setGoal(categoryMenu.getValue().toString(), Integer.parseInt(volumeNumber.getText()));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

    }
}
