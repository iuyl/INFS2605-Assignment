/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *
 * @author aiisonsuherly
 */
public class FXMLEnterDataController implements Initializable {
    
    @FXML
    private Label enterData;
    
    @FXML
    private Text category;
    
    @FXML
    private ComboBox categoryMenu;
    
    @FXML
    private Text volume;
    
    @FXML
    private TextField volumeNumber;
    
    @FXML
    private Text date;
    
    @FXML
    private DatePicker datePicker;
    
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         categoryMenu.getItems().removeAll(categoryMenu.getItems());
         categoryMenu.getItems().addAll("Last Health Checkup", "Lean/Fat Mass Ratio", "BMI", "Overall Wellbeing", "Sleep Rating", "Resting Heart Rate", "Calories Consumed", "Gym Attendence", "Step Count", "Flights (Stairs) Climbed", "Resistance Exercise Mass");
    }
    
    
}
