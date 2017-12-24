package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import model.Main;

public class MainViewController {
	
	
	@FXML
	private void goHome() throws IOException {
		Main.mainView();
	}
	
	@FXML
	private void goTraining() throws IOException {
		Main.TrainingView();
	}
	@FXML
	private void goEmployees() throws IOException {
		Main.EmployeesView();
	}
	@FXML
	private void goStatistic() throws IOException {
		Main.StatisticView();
	}
//	@FXML
//	private void goOptions() throws IOException {
//		Main.OptionView();
//	}
	@FXML
	private void goAdmin(ActionEvent event) throws IOException {
		if(Main.currentLogged.isAdmin()) {
			Main.MainAdminView();
		}
		else {
			LoginController.alert("ERROR: Can't load this information.", "You do not have sufficient privileges to load this information.", AlertType.ERROR);
		}
	}

}
