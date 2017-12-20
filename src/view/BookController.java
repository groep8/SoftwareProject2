package view;

import java.io.IOException;

import database.TrainingDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Main;
import model.Training;

public class BookController {
	private Main main;
	@FXML
	private void goHome() throws IOException {
		main.mainView();
	}
	private static int id;
	
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
	@FXML
	public void AssignBook() throws IOException {
		Training d=tableView.getSelectionModel().getSelectedItem();
		if (d==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("Fout, Niets geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		else {
		BookController.setId(d.getIdTraining());
		FXMLLoader f = new FXMLLoader(Main.class.getResource("/view/AssignBook.fxml"));
		BorderPane updateTraining= f.load();
		Stage s = new Stage();
		TrainingController.secundaireStage=s;
		s.setResizable(false);
		s.setTitle("Assign book");
		s.initModality(Modality.WINDOW_MODAL);
		Scene scene= new Scene(updateTraining);
		s.setScene(scene);
		AssignBookController a = f.getController();
		a.setLabel(d);
		s.showAndWait();
		}
	}
	
	
	 @FXML 
	 private TableView<Training> tableView;
	 @FXML 
	 private TableColumn<Training,Integer> trainingId;
	 @FXML 
	 private TableColumn<Training, String>  trainingNaam;
	 @FXML 
	 private TableColumn<Training, String>  boek;
	 @FXML 
	 private TableColumn<Training, String>  auteur;
	 

	@FXML 
	public void initialize() {

		trainingId.setCellValueFactory(new Callback<CellDataFeatures<Training, Integer>, ObservableValue<Integer>>() {
		@Override
		public ObservableValue<Integer> call(CellDataFeatures<Training, Integer> data) {
			return new SimpleIntegerProperty(data.getValue().getIdTraining()).asObject();
		}
	});
		
		trainingNaam.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				return new SimpleStringProperty(data.getValue().getTrainingNaam());
			}
		});
		boek.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				return new SimpleStringProperty(data.getValue().getBook());
			}
		});
		auteur.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				return new SimpleStringProperty(data.getValue().getAuteurBoek());
			}
		});
		
				
		ObservableList<Training> list = FXCollections.observableArrayList(TrainingDAO.getall());
		tableView.setItems(list);
		
	 }
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		BookController.id = id;
	}
	 public void cancel() {

			
			Main.addDialogStage.close();
	 }

}
