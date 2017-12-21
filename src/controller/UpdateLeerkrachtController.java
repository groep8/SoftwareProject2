package controller;

import java.io.IOException;

import database.TrainingDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Leerkracht;
import model.Main;
import model.Training;

public class UpdateLeerkrachtController {
	
	@FXML
	private Label lab;
	@FXML
	private TextField text;
	@FXML
	private TextField text2;

	public void setLabel(Leerkracht d) {
		lab.setText("Trainer: "+ d.getVolleNaam());
	}
	@FXML
	private void goLeerkrachtVN() throws IOException {
		LeerkrachtController.updateName();
	}
	@FXML
	private void goLeerkrachtLN() throws IOException {
		LeerkrachtController.updateLastname();
	}
	public void changeName() throws IOException {
		String voornaam= text.getText();
		
		LeerkrachtController test= new LeerkrachtController();
		int id= test.getId();
		TrainingDAO.updateLeerkrachtName(id, voornaam);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("Trainernaam gewijzigt");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingController.secundaireStage.close();
		Main.LeerkrachtView();
	}
	public void changelastname() throws IOException {
		String familienaam= text2.getText();
		
		LeerkrachtController test= new LeerkrachtController();
		int id= test.getId();
		TrainingDAO.updateLeerkrachtLastname(id, familienaam);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("Trainernaam gewijzigt");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingController.secundaireStage.close();
		Main.LeerkrachtView();
	}
	public void cancel() {
		
		TrainingController.secundaireStage.close();
	}

}
