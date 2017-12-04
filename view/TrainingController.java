package view;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import database.TrainingDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import model.Main;
import model.Training;
import model.TrainingDetail;

public class TrainingController {
	private Main main;
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField adresField;
	
	@FXML
	private TextField leerkrachtField;
	
	@FXML
	private DatePicker datumField;
	
	@FXML
	private TextField personeelField;
	
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
	@FXML
	private void goOptions() throws IOException {
		main.OptionView();
	}
	public void addStage() throws IOException {
		main.showAddStage();
	}
	

	public void saveTraining() throws SQLException {
		
		
		String naam = nameField.getText();
		String adresString = adresField.getText();
		int adres =Integer.parseInt(adresString);
		String leerkrachtstring = leerkrachtField.getText();
		int leerkracht =Integer.parseInt(leerkrachtstring);
		LocalDate datum = datumField.getValue();
		String personeelstring = personeelField.getText();
		int personeel =Integer.parseInt(personeelstring);
		
		
		Training training = new Training();
		training.setTrainingNaam(naam);
		training.setAdres(adres);
		training.setLeerkracht(leerkracht);

		
		TrainingDetail trainingd = new TrainingDetail();
		trainingd.setPersoneel(personeel);
		trainingd.setDatum(datum);
		trainingd.setStatus("ok");
		trainingd.setTraining(training);
		if(TrainingDAO.saveTraining(trainingd)) {
		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Training aangemaakt");
			alert.setHeaderText(null);
			alert.showAndWait();
			Main.addDialogStage.close();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Training niet aangemaakt, foutieve invoer");
			alert.setHeaderText(null);
			alert.showAndWait();
			Main.addDialogStage.close();
		}
	
	}
	 public void cancel() {

			
			Main.addDialogStage.close();
	 }
	

}
