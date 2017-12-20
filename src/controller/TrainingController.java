package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import database.TrainingDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.util.Callback;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Adres;
import model.Main;
import model.Training;
import model.TrainingDetail;
public class TrainingController {
	private Main main;
	public static Stage secundaireStage;
	private UpdateTraining upt;

	
	private static int id;
	
	@FXML
	private void goHome() throws IOException {
		Main.mainView();
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
	public void addStage() throws IOException {
		main.showAddStage();
	}
	
	@FXML
	public void goBook() throws IOException {
		main.BookView();
	}
	@FXML
	public void goDelete() throws IOException {
		main.DeleteView();
	}
	@FXML
	public void goLeerkracht() throws IOException {
		main.LeerkrachtView();
	}
	@FXML
	public void goAdres() throws IOException {
		main.AdresView();
	}
	

	@FXML
	public void DeleteTraining() throws IOException {
		Training d=tableView.getSelectionModel().getSelectedItem();
		if (d==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("Fout, Niets geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		else {
		this.id=d.getIdTraining();
		Alert alert2 = new Alert(AlertType.INFORMATION);
		alert2.setTitle("DELETE");
		alert2.setContentText(d.getTrainingNaam() +" is deleted");
		alert2.setHeaderText(null);
		alert2.showAndWait();
		TrainingDAO.deleteknop(id);
		main.TrainingView();
		}
	}
	

	@FXML
	public void UpdateTraining() throws IOException {
		Training d=tableView.getSelectionModel().getSelectedItem();
		if (d==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("Fout, Niets geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		else {
		this.id=d.getIdTraining();
		FXMLLoader f = new FXMLLoader(Main.class.getResource("/view/UpdateTraining.fxml"));
		BorderPane updateTraining= f.load();
		Stage s = new Stage();
		TrainingController.secundaireStage=s;
		s.setResizable(false);
		s.setTitle("updateTraining");
		s.initModality(Modality.WINDOW_MODAL);
		Scene scene= new Scene(updateTraining);
		s.setScene(scene);
		UpdateTraining u = f.getController();
		u.setLabel(d);
		s.showAndWait();
		}
		
		
	}
	public void updateName() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/UpdateName.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		secundaireStage.setScene(scene);
		secundaireStage.show();
	}
	
	public void updateLeerkracht() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/UpdateLeerkracht.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		secundaireStage.setScene(scene);
		secundaireStage.show();
	}
	public void updateAdres() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/UpdateAdres.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		secundaireStage.setScene(scene);
		secundaireStage.show();
	}
	public void updateDatum() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/UpdateDatum.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		secundaireStage.setScene(scene);
		secundaireStage.show();
	}
	public void updateDatum2() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/UpdateEindDatum.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		secundaireStage.setScene(scene);
		secundaireStage.show();
	}
	public void cancel() {
		
		TrainingController.secundaireStage.close();
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
				
		ObservableList<Training> list = FXCollections.observableArrayList(TrainingDAO.getall());
		tableView.setItems(list);
		
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@FXML
	public void goGoogleMap() throws IOException {
		Training d=tableView.getSelectionModel().getSelectedItem();
		if (d==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("Fout, Niets geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		else {
		this.id=d.getIdTraining();
		this.str= d.getAdres().getStraat()+"+"+d.getAdres().getHuisnum()+"+"+d.getAdres().getPostcode()+"+"+d.getAdres().getStad()+"+"+d.getAdres().getLand();
		FXMLLoader f = new FXMLLoader(Main.class.getResource("/view/googleMapView.fxml"));
		AnchorPane updateTraining= f.load();
		Stage s = new Stage();
		TrainingController.secundaireStage=s;
		s.setResizable(false);
		s.setTitle("updateTraining");
		s.initModality(Modality.WINDOW_MODAL);
		Scene scene= new Scene(updateTraining);
		s.setScene(scene);
		GoogleMapsController u = f.getController();
		u.setLabel(d);
		s.showAndWait();
		}
		
		
	}
	
	public static String getStr() {
		return str;
	}

	public static void setStr(String str) {
		TrainingController.str = str;
	}



	private static String str;
	
	
	
}
