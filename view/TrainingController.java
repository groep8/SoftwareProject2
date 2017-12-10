package view;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.scene.control.TableColumn.CellDataFeatures;
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
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField adresField;
	
	@FXML
	private TextField leerkrachtField;
	
	@FXML
	private DatePicker datumField;
	
	@FXML
	private TextField personeelField;
	
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
	public void UpdateTraining() throws IOException {
		TrainingDetail d=tableView.getSelectionModel().getSelectedItem();
		if (d==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("Fout, Niets geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		else {
		this.id=d.getTraining().getIdTraining();
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

	
	 @FXML 
	 private TableView<TrainingDetail> tableView;
	 @FXML 
	 private TableColumn<TrainingDetail,Integer> trainingId;
	 @FXML 
	 private TableColumn<TrainingDetail,String> adres;
	 @FXML 
	 private TableColumn<TrainingDetail, String>  trainingNaam;
	 @FXML 
	 private TableColumn <TrainingDetail, String> leerkracht;
	 @FXML 
	 private TableColumn <TrainingDetail, Integer>personeel;
	 @FXML 
	 private TableColumn <TrainingDetail,String >datum;
	 

	@FXML 
	public void initialize() {

		trainingId.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, Integer>, ObservableValue<Integer>>() {
		@Override
		public ObservableValue<Integer> call(CellDataFeatures<TrainingDetail, Integer> data) {
			return new SimpleIntegerProperty(data.getValue().getTraining().getIdTraining()).asObject();
		}
	});
		
		trainingNaam.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<TrainingDetail, String> data) {
				return new SimpleStringProperty(data.getValue().getTraining().getTrainingNaam());
			}
		});
		adres.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<TrainingDetail, String> data) {
				return new SimpleStringProperty(data.getValue().getTraining().getAdres().getStraat() + " " + data.getValue().getTraining().getAdres().getHuisnum());
			}
		});
		
		leerkracht.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<TrainingDetail, String> data) {
				return new SimpleStringProperty(data.getValue().getTraining().getLeerkracht().getVolleNaam());
			}
		});
		
		personeel.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, Integer>, ObservableValue<Integer>>() {
			@Override
			public ObservableValue<Integer> call(CellDataFeatures<TrainingDetail, Integer> data) {
				return new SimpleIntegerProperty(data.getValue().getPersoneel()).asObject();
			} 
		});
		
		datum.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<TrainingDetail, String> data) {
				return new SimpleStringProperty(data.getValue().getTraining().getDatum().toString());
			}
		});
				
		ObservableList<TrainingDetail> list = FXCollections.observableArrayList(TrainingDAO.getall());
		tableView.setItems(list);
	
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
}
