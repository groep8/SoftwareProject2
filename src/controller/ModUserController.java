package controller;

import database.LoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Login;
import model.Main;

public class ModUserController {
	static Login selL = new Login();
    @FXML
    private TextField userName;

    @FXML
    private PasswordField pass;

    @FXML
    private CheckBox isAdmin;
    @FXML
    public void initialize() {
    	userName.setText(selL.getUsername());
    	isAdmin.setSelected(selL.isAdmin());
    }
    @FXML
    void cancel(ActionEvent event) {
    	Main.addDialogStage.close();
    }

    @FXML
    void modUser(ActionEvent event) {
    	boolean temp = LoginDAO.modUser(selL);
    	if(temp) {
    		LoginController.alert("INFO: User modified", "User has successfully been modified.", AlertType.INFORMATION);
    	}
    	else {
    		LoginController.alert("ERROR: Failed to modify", "User couldn't be modified.", AlertType.ERROR);
    	}
    }

}
