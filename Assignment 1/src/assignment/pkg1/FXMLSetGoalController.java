/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.io.IOException;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
public class FXMLSetGoalController {
    
    @FXML
    private Label setGoal;
    
    @FXML
    private Label category;
    
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
}
