package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import model.Main;

public class StatisticController {
	private Main main;
	
	@FXML
	private void preset() throws IOException {
		main.Linechart("month(beginDatum)", "<=", "Training", "(select max(year(beginDatum)) from Training)", "(select max(year(beginDatum))-1 from Training)" );
	}

	@FXML
	private void preset2() throws IOException {
		main.preset2("month(beginDatum)", "<=", "TrainingDetail", "(select max(year(beginDatum)) from Training)","(select max(year(beginDatum))-1 from Training)" );
	}

	
	@FXML
	private void pie() throws IOException {
		main.PiechartView();
	}
	
	@FXML
	private void bar() throws IOException {
		main.BarchartView();
	}

	
	@FXML
	private void line() throws IOException {
		main.LinechartView();
	}
	
	
	@FXML
	private void goHome() throws IOException {
		main.mainView();
	}
	
	@FXML
	private void goTraining() throws IOException {
		main.TrainingView();
	}
	@FXML
	private void goEmployees() throws IOException {
		main.EmployeesView();
	}
	@FXML
	private void goStatistic() throws IOException {
		main.StatisticView();
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
