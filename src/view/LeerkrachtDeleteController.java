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
import model.Leerkracht;
import model.Main;
import model.Training;

public class LeerkrachtDeleteController {
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
	@FXML
	private void goOptions() throws IOException {
		Main.OptionView();
	}
	
	@FXML
	private void goBack() throws IOException {
		Main.LeerkrachtView();
	}
	@FXML 
	 private TableView<Leerkracht> tableView;
	 @FXML 
	 private TableColumn<Leerkracht,Integer> leerkrachtId;
	 @FXML 
	 private TableColumn<Leerkracht,String> voornaam;
	 @FXML 
	 private TableColumn<Leerkracht, String>  familienaam;
	
	 

	@FXML 
	public void initialize() {

		leerkrachtId.setCellValueFactory(new Callback<CellDataFeatures<Leerkracht, Integer>, ObservableValue<Integer>>() {
		@Override
		public ObservableValue<Integer> call(CellDataFeatures<Leerkracht, Integer> data) {
			return new SimpleIntegerProperty(data.getValue().getIdLeerkracht()).asObject();
		}
	});
		
		voornaam.setCellValueFactory(new Callback<CellDataFeatures<Leerkracht, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Leerkracht, String> data) {
				return new SimpleStringProperty(data.getValue().getVoornaam());
			}
		});
		familienaam.setCellValueFactory(new Callback<CellDataFeatures<Leerkracht, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Leerkracht, String> data) {
				return new SimpleStringProperty(data.getValue().getFamilienaam());
			}
		});
				
		ObservableList<Leerkracht> list = FXCollections.observableArrayList(TrainingDAO.getallLeerkrachtDelete());
		tableView.setItems(list);
		
	 }
	private static int id;
	
	@FXML
	public void UndeleteLeerkracht() throws IOException {
		Leerkracht d=tableView.getSelectionModel().getSelectedItem();
		this.id=d.getIdLeerkracht();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("UNDELETE");
		alert.setContentText(d.getVolleNaam() +" is undeleted");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingDAO.undeleteknopleerkracht(id);
		Main.DeleteLeerkrachtView();
		
	}
	
}
