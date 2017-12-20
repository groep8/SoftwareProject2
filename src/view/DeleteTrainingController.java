package view;

import java.io.IOException;

import database.TrainingDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import model.Main;
import model.Training;

public class DeleteTrainingController {
	
	private Main main;
	private static int id;
	
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		DeleteTrainingController.id = id;
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
	@FXML
	private void goOptions() throws IOException {
		main.OptionView();
	}
	
	 @FXML 
	 private TableView<Training> tableView;
	 @FXML 
	 private TableColumn<Training,Integer> trainingId;
	 @FXML 
	 private TableColumn<Training,String> adres;
	 @FXML 
	 private TableColumn<Training, String>  trainingNaam;
	 @FXML 
	 private TableColumn <Training, String> leerkracht;
	 @FXML 
	 private TableColumn <Training,String >begindatum;
	 @FXML 
	 private TableColumn <Training,String >eindDatum;
	 

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
		adres.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				return new SimpleStringProperty(data.getValue().getAdres().getStraat() + " " + data.getValue().getAdres().getHuisnum());
			}
		});
		
		leerkracht.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				return new SimpleStringProperty(data.getValue().getLeerkracht().getVolleNaam());
			}
		});
		
		eindDatum.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				return new SimpleStringProperty(data.getValue().getEindDatum().toString());
			}
		});
		
		begindatum.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				return new SimpleStringProperty(data.getValue().getBeginDatum().toString());
			}
		});
				
		ObservableList<Training> list = FXCollections.observableArrayList(TrainingDAO.getallDelete());
		tableView.setItems(list);
		
	 }
	@FXML
	public void UndeleteTraining() throws IOException {
		Training d=tableView.getSelectionModel().getSelectedItem();
		this.id=d.getIdTraining();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("UNDELETE");
		alert.setContentText(d.getTrainingNaam() +" is undeleted");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingDAO.undeleteknop(id);
		main.DeleteView();
		
	}
	

}
