package view;

import java.io.IOException;

import database.LoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Login;
import model.Main;
import javafx.scene.control.Alert.AlertType;

public class addNewUserController {

	@FXML
    private Label InformationL;
	
    @FXML
    private PasswordField passFirst;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField passSecond;

    @FXML
    private CheckBox isAdmin;

    @FXML
    void cancel(ActionEvent event) {
    	Main.addDialogStage.close();
    }

    @FXML
    void createNewUser(ActionEvent event) {
    	try {
    		Login newLog = new Login();
    		newLog.setUsername(userName.getText());
    		if(passSecond.getText().contentEquals(passFirst.getText())) {
    			InformationL.setText("!! The passwords must match to be accepted !!");
    		}
    		else {
    			newLog.setPassword(passSecond.getText());
    			newLog.setAdmin(isAdmin.isSelected());
        		LoginDAO.saveLogin(newLog);
        		Main.addDialogStage.close();
    			Main.MainAdminView();
    		}
    		
    	}
    	catch(NullPointerException e) {
    		LoginController.alert("ERROR: Not all fields where chosen", "Not all fields that need to be filled in were given.", AlertType.ERROR);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
