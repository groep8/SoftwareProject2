package controller;

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
import model.Adres;
import model.Leerkracht;
import model.Main;

public class AdresDeleteController {
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
		Main.AdresView();
	}
	 @FXML 
	 private TableView<Adres> tableView;
	 @FXML 
	 private TableColumn<Adres,Integer> adresId;
	 @FXML 
	 private TableColumn<Adres,String> straat;
	 @FXML 
	 private TableColumn<Adres,Integer> huisnum;
	 @FXML 
	 private TableColumn<Adres,Integer> postcode;
	 @FXML 
	 private TableColumn<Adres,String> stad;
	 @FXML 
	 private TableColumn<Adres,String> land;

	@FXML 
	public void initialize() {

		adresId.setCellValueFactory(new Callback<CellDataFeatures<Adres, Integer>, ObservableValue<Integer>>() {
		@Override
		public ObservableValue<Integer> call(CellDataFeatures<Adres, Integer> data) {
			return new SimpleIntegerProperty(data.getValue().getIdAdres()).asObject();
		}
	});
		
		straat.setCellValueFactory(new Callback<CellDataFeatures<Adres, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Adres, String> data) {
				return new SimpleStringProperty(data.getValue().getStraat());
			}
		});
		huisnum.setCellValueFactory(new Callback<CellDataFeatures<Adres, Integer>, ObservableValue<Integer>>() {
			@Override
			public ObservableValue<Integer> call(CellDataFeatures<Adres, Integer> data) {
				return new SimpleIntegerProperty(data.getValue().getHuisnum()).asObject();
			}
		});
		postcode.setCellValueFactory(new Callback<CellDataFeatures<Adres, Integer>, ObservableValue<Integer>>() {
			@Override
			public ObservableValue<Integer> call(CellDataFeatures<Adres, Integer> data) {
				return new SimpleIntegerProperty(data.getValue().getPostcode()).asObject();
			}
		});
		stad.setCellValueFactory(new Callback<CellDataFeatures<Adres, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Adres, String> data) {
				return new SimpleStringProperty(data.getValue().getStad());
			}
		});
		land.setCellValueFactory(new Callback<CellDataFeatures<Adres, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Adres, String> data) {
				return new SimpleStringProperty(data.getValue().getLand());
			}
		});
				
		ObservableList<Adres> list = FXCollections.observableArrayList(TrainingDAO.getadresDelete());
		tableView.setItems(list);
		
	 }
	private static int id;
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		AdresDeleteController.id = id;
	}

	@FXML
	public void UndeleteAdres() throws IOException {
		Adres d=tableView.getSelectionModel().getSelectedItem();
		if (d==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("Fout, Niets geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		else {
		this.id=d.getIdAdres();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("UNDELETE");
		alert.setContentText(d.getVolleAdres() +" is undeleted");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingDAO.undeleteknopAdres(id);
		Main.DeleteAdresView();
		}
	}

}
