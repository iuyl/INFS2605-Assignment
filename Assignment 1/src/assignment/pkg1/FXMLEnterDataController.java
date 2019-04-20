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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private Label successLabel;
    
    @FXML
    void handleBackAction(ActionEvent event) {
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
    //method to parse date into ISO8601 String
    @FXML
    void handleSaveButtonClick() throws SQLException {
        LocalDate date = datePicker.getValue();
        DatabaseHelper.addNewStatEntry(category.toString(), 0, date.toString());
        successLabel.setText("Data Entered.");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         categoryMenu.getItems().removeAll(categoryMenu.getItems());
         categoryMenu.getItems().addAll("Last Health Check", "Lean/Fat Mass Ratio", "BMI", "Overall Wellbeing", "Sleep Rating", "Resting Heart Rate", "Calories Consumed", "Gym Attendance", "Step Count", "Flights (Stairs) Climbed", "Resistance Exercise Mass", "Aerobic Exercise");
         
         
         
         save.setOnAction((ActionEvent e) -> {
             try {
                 LocalDate date = datePicker.getValue();
                 DatabaseHelper.addNewStatEntry(categoryMenu.getValue().toString(), Integer.parseInt(volumeNumber.getText()), date.toString());
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         });
    }
    
    
}
