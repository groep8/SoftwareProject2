package controller;

import database.LoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import model.Login;
import model.Main;

public class LoginController {
	private Login logCurrent;
    @FXML
    private PasswordField pf_password;
    @FXML
    private TextField tf_user;

    @FXML
    void goHome(ActionEvent event) {
    	
    	try {
    		logCurrent = new Login();
    		logCurrent.setUsername(tf_user.getText());
    		logCurrent.setPassword(pf_password.getText());
    		if(LoginDAO.getLogUser(logCurrent)) {
    			Main.mainView();
    	    	alert("Success !", "Je bent succesvol ingelogd !", AlertType.INFORMATION);
    	    	
    		}
    		else {
    	    	alert("Username", "Login onmogelijk. ", AlertType.WARNING);
    		}
		}
    	catch(NullPointerException e) {
    		alert("Error","Foutieve gebruikersnaam / paswoord.", AlertType.WARNING);
    		logCurrent.setUsername("");
    		logCurrent.setPassword("");	
    	}
    	catch (Exception e) {
    		alert("FATAL ERROR", "Unknown error, please contact your system administrator and report the bug.", AlertType.WARNING);
    		e.printStackTrace();
		}
    }
    public static void alert(String title,String message, AlertType al) {
    	Alert alert = new Alert(al);
    	alert.setHeaderText(null);
    	alert.setTitle(title);
    	alert.setContentText(message);
    	alert.showAndWait();
    	
    }
}