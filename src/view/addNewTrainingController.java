package view;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import database.TrainingDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import model.Adres;
import model.Leerkracht;
import model.Main;
import model.Training;
import model.TrainingDetail;

public class addNewTrainingController {
	@FXML
	private TextField nameField;


	@FXML
	private DatePicker datumField;
	@FXML
	private DatePicker datumField2;

	@FXML
	private TextField personeelField;

	public void saveTraining() throws SQLException, IOException {

		int idadres=adres.getValue().getIdAdres();
		int idleerkracht = leerkracht.getValue().getIdLeerkracht();
		String naam = nameField.getText();

		LocalDate bdatum = datumField.getValue();
		LocalDate edatum = datumField2.getValue();



		Training training = new Training();
		training.setTrainingNaam(naam);
		training.setBeginDatum(bdatum);
		training.setEindDatum(edatum);
		training.setStatus("WAITING");
		training.setArchief(false);
		training.setBook("NONE");



		/*TrainingDetail trainingd = new TrainingDetail();
		trainingd.setPersoneel(1);
		trainingd.setTraining(training);*/

		if(TrainingDAO.saveTraining(training, idadres, idleerkracht)) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Training aangemaakt");
			alert.setHeaderText(null);
			alert.showAndWait();
			Main.addDialogStage.close();
			Main.TrainingView();
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

	@FXML
	private ComboBox<Adres> adres;

	ObservableList<String> options = FXCollections.observableArrayList( "1", "2", "3" );

	@FXML
	private ComboBox<Leerkracht> leerkracht;



	@FXML
	private void initialize() {
		ObservableList<Adres> adreslist = FXCollections.observableArrayList(TrainingDAO.getadres());
		adres.setItems(adreslist);

		Callback<ListView<Adres>, ListCell<Adres>> call = lv -> new ListCell<Adres>() {

			@Override
			protected void updateItem(Adres a, boolean empty) {
				super.updateItem(a, empty);
				setText(a == null ? "" : (a.getStraat()+" "+a.getHuisnum()));
			}

		};

		adres.setCellFactory(call);
		adres.setButtonCell(call.call(null));

		ObservableList<Leerkracht> leerkrachtlist = FXCollections.observableArrayList(TrainingDAO.getLeerkracht());
		leerkracht.setItems(leerkrachtlist);

		Callback<ListView<Leerkracht>, ListCell<Leerkracht>> call1 = lv -> new ListCell<Leerkracht>() {

			@Override
			protected void updateItem(Leerkracht l, boolean empty) {
				super.updateItem(l, empty);
				setText(l == null ? "" : (l.getVolleNaam()));
			}

		};

		leerkracht.setCellFactory(call1);
		leerkracht.setButtonCell(call1.call(null));



	}

}
