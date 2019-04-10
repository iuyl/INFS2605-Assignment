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
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 *
 * @author aiisonsuherly
 */
public class FXMLEnterDataController {
    
    @FXML
    private Label enterData;
    
    @FXML
    private Text text;
    
    @FXML
    private ComboBox typeMenu;
    
    @FXML
    private Text volume;
    
    @FXML
    private ComboBox volumeMenu;
    
    @FXML
    private Button save;
    
    @FXML
    private Button back;
}
