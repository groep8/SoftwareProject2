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
import model.Adres;
import model.Leerkracht;
import model.Main;
import model.Training;

public class AdresController {
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
	private void godelete() throws IOException {
		Main.DeleteAdresView();;
	}
	@FXML
	private void AdAdres() throws IOException {
		Main.addAdresView();
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
				
		ObservableList<Adres> list = FXCollections.observableArrayList(TrainingDAO.getadres());
		tableView.setItems(list);
		
	 }
	private static int id;
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		AdresController.id = id;
	}

	@FXML
	public void deleteAdres() throws IOException {
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
		alert.setTitle("DELETE");
		alert.setContentText(d.getVolleAdres() +" is deleted");
		alert.setHeaderText(null);
		alert.showAndWait();
		TrainingDAO.deleteknopAdres(id);
		Main.AdresView();
		}
	}
	@FXML
	public void UpdateAdres() throws IOException {
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
		FXMLLoader f = new FXMLLoader(Main.class.getResource("/view/ModifyAdres.fxml"));
		BorderPane ModifyLeerkrachtView= f.load();
		Stage s = new Stage();
		TrainingController.secundaireStage=s;
		s.setResizable(false);
		s.setTitle("updateTraining");
		s.initModality(Modality.WINDOW_MODAL);
		Scene scene= new Scene(ModifyLeerkrachtView);
		s.setScene(scene);
		ModifyAdres u = f.getController();
		u.setLabel(d);
		s.showAndWait();
		}
	}
	public static void updateStraat() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/ModifyAdresStraat.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		TrainingController.secundaireStage.setScene(scene);
		TrainingController.secundaireStage.show();
	}
	public static void updateHuisn() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/ModifyAdresHuisn.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		TrainingController.secundaireStage.setScene(scene);
		TrainingController.secundaireStage.show();
	}
	public static void updatePost() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/ModifyAdresPostcode.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		TrainingController.secundaireStage.setScene(scene);
		TrainingController.secundaireStage.show();
	}
	public static void updateStad() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/ModifyAdresStad.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		TrainingController.secundaireStage.setScene(scene);
		TrainingController.secundaireStage.show();
	}
	public static void updateLand() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/ModifyAdresLand.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		TrainingController.secundaireStage.setScene(scene);
		TrainingController.secundaireStage.show();
	}
	public void cancel() {
		
		TrainingController.secundaireStage.close();
	}

}
