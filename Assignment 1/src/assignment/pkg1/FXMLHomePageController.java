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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author aiisonsuherly
 */
public class FXMLHomePageController {
    
    @FXML
    private Label home;
    
    @FXML
    private Button enterData;
    
    @FXML
    private Button progress;
    
    @FXML
    private Button setGoal;
    
    @FXML
    private ImageView background;
    
    @FXML
    void handleEnterDataAction(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("EnterData.fxml"));
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
    void handleProgressAction(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("Dashboard2.fxml"));
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
    void handleSetGoalAction(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("SetGoals.fxml"));
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
