package controller;

import java.io.IOException;

import database.TrainingDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Adres;
import model.Main;

public class ModifyAdres {
	@FXML
	public void gostraat() throws IOException {
		AdresController.updateStraat();
	}
	@FXML
	public void gohuisnummer() throws IOException {
		AdresController.updateHuisn();
	}
	@FXML
	public void gopostcode() throws IOException {
		AdresController.updatePost();
	}
	@FXML
	public void gostad() throws IOException {
		AdresController.updateStad();
	}
	@FXML
	public void goland() throws IOException {
		AdresController.updateLand();
	}
	@FXML
	private Label myMes;
	@FXML
	private TextField straat;
	@FXML
	private TextField huisnummer;
	@FXML
	private TextField postcode;
	@FXML
	private TextField stad;
	@FXML
	private TextField land;

	public void setLabel(Adres a) {
		myMes.setText("Adres: "+a.getVolleAdres());
	}
	

	public void changeStraat() throws IOException {
		String straatstring= straat.getText();
		AdresController test= new AdresController();
		int id= test.getId();
		TrainingDAO.updateAdresStraat(id, straatstring);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("straat gewijzigt");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingController.secundaireStage.close();
		Main.AdresView();
	}
	public void changehuisnummer() throws IOException {
		String huisn= huisnummer.getText();
		int huis= Integer.parseInt(huisn);
		AdresController test= new AdresController();
		int id= test.getId();
		TrainingDAO.updateAdreshuisn(id, huis);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("huisnummer gewijzigt");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingController.secundaireStage.close();
		Main.AdresView();
	}
	public void changePostcode() throws IOException {
		String postc= postcode.getText();
		int post= Integer.parseInt(postc);
		AdresController test= new AdresController();
		int id= test.getId();
		TrainingDAO.updateAdrespostcode(id, post);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("Postcode gewijzigt");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingController.secundaireStage.close();
		Main.AdresView();
	}
	public void changestad() throws IOException {
		String stads= stad.getText();
		AdresController test= new AdresController();
		int id= test.getId();
		TrainingDAO.updateAdresStad(id, stads);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("stad gewijzigt");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingController.secundaireStage.close();
		Main.AdresView();
	}
	public void changeland() throws IOException {
		String lands= land.getText();
		AdresController test= new AdresController();
		int id= test.getId();
		TrainingDAO.updateAdresland(id, lands);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("land gewijzigt");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingController.secundaireStage.close();
		Main.AdresView();
	}
	public void cancel() {
		
		TrainingController.secundaireStage.close();
	}
	
}
