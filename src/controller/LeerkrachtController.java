package controller;

import java.io.IOException;

import database.TrainingDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
import model.Leerkracht;
import model.Main;
import model.Training;

public class LeerkrachtController {

	private Main main;
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
	private void AdLeerkracht() throws IOException {
		Main.addLeerkrachtView();
	}
	@FXML
	private void DelLeerkracht() throws IOException {
		Main.DeleteLeerkrachtView();
	}
	
	
	private static int id;
	
	
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
				
		ObservableList<Leerkracht> list = FXCollections.observableArrayList(TrainingDAO.getallLeerkracht());
		tableView.setItems(list);
		
	 }
	
	@FXML
	public void DeleteLeerkracht() throws IOException {
		Leerkracht l=tableView.getSelectionModel().getSelectedItem();
		if (l==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("Fout, Niets geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		else {
		this.id=l.getIdLeerkracht();
		Alert alert2 = new Alert(AlertType.INFORMATION);
		alert2.setTitle("DELETE");
		alert2.setContentText(l.getVolleNaam() +" is deleted");
		alert2.setHeaderText(null);
		alert2.showAndWait();
		TrainingDAO.deleteknopLeerkracht(id);
		Main.LeerkrachtView();
		}
	}
	@FXML
	public void Updateleerkracht() throws IOException {
		Leerkracht d=tableView.getSelectionModel().getSelectedItem();
		if (d==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("Fout, Niets geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		else {
		this.id=d.getIdLeerkracht();
		FXMLLoader f = new FXMLLoader(Main.class.getResource("/view/ModifyLeerkrachtView.fxml"));
		BorderPane ModifyLeerkrachtView= f.load();
		Stage s = new Stage();
		TrainingController.secundaireStage=s;
		s.setResizable(false);
		s.setTitle("updateTraining");
		s.initModality(Modality.WINDOW_MODAL);
		Scene scene= new Scene(ModifyLeerkrachtView);
		s.setScene(scene);
		UpdateLeerkrachtController u = f.getController();
		u.setLabel(d);
		s.showAndWait();
		}
	}
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		LeerkrachtController.id = id;
	}

	public static void updateName() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/LeerkrachtModifyVN.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		TrainingController.secundaireStage.setScene(scene);
		TrainingController.secundaireStage.show();
	}
	public static void updateLastname() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/LeerkrachtModifyLN.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		TrainingController.secundaireStage.setScene(scene);
		TrainingController.secundaireStage.show();
	}
}
