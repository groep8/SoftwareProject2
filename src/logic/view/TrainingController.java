package view;

import java.io.IOException;
import java.sql.SQLException;

import database.TrainingDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Main;
import model.Training;

public class TrainingController {
	private Main main;
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField adresField;
	
	@FXML
	private TextField leerkrachtField;
	
	@FXML
	private TextField datumField;
	
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
		String datum = datumField.getText();
		String personeelstring = personeelField.getText();
		int personeel =Integer.parseInt(personeelstring);
		
		
		Training training = new Training();
		training.setTrainingNaam(naam);
		training.setIdAdres(adres);
		training.setIdLeerkracht(leerkracht);
			
			TrainingDAO.saveTraining(training);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Training aangemaakt");
			alert.setHeaderText(null);
			alert.showAndWait();
			Main.addDialogStage.close();
		
	
	}

}
