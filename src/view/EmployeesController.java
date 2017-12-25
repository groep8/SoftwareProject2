package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import model.Main;

<<<<<<< HEAD:src/controller/StatisticController.java
public class StatisticController {
=======
public class EmployeesController {
	
private Main main;
>>>>>>> origin/mao.uyen.tram:src/view/EmployeesController.java
	
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
	private void goAdmin() throws IOException {
		if(Main.currentLogged.isAdmin()) {
			Main.MainAdminView();
		}
		else {
			LoginController.alert("ERROR: Can't load this information.", "You do not have sufficient privileges to load this information.", AlertType.ERROR);
		}
	}
}
