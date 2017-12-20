package controller;

import java.util.ArrayList;

import database.TrainingDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import model.Book;
import model.BookAPI;
import model.Main;
import model.Training;

public class AssignBookController {
	@FXML
	private Label myMes;
	
	public void setLabel(Training d) {
		myMes.setText("Training: "+d.getIdTraining() +" - "+ d.getTrainingNaam() + " , Boek: " + d.getBook()+" , Auteur: "+d.getAuteurBoek());
	}
	@FXML
	private TextField text;

	 @FXML 
	 private TableView<Book> tableView;
	 @FXML 
	 private TableColumn<Book,String> boek;
	 @FXML 
	 private TableColumn<Book, String>  auteur;
	 

	@FXML 
	public void button() throws Exception {


		boek.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Book, String> data) {
				return new SimpleStringProperty(data.getValue().getBoek());
			}
		});
		auteur.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Book, String> data) {
				return new SimpleStringProperty(data.getValue().getAuteur());
			}
		});
	
			tableView.getItems().clear();
			 ArrayList<String> result= new ArrayList<String>();
			String search = text.getText();
			String[] book = new String[] {"--title", search};
		ObservableList<Book> list = FXCollections.observableArrayList(BookAPI.queryGoogleBooks(book));
		tableView.setItems(list);
		
	 }
	

	@FXML 
	public void button2() throws Exception{
		Book d=tableView.getSelectionModel().getSelectedItem();
		if (d==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("Fout, Niets geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		else {
		int id=BookController.getId();
		String book= d.getBoek();
		String auteur =d.getAuteur();
		Alert alert2 = new Alert(AlertType.INFORMATION);
		alert2.setTitle("Toevoegen");
		alert2.setContentText(d.getBoek() +" is toegevoegd");
		alert2.setHeaderText(null);
		alert2.showAndWait();
		TrainingDAO.changeBook(id, book, auteur);
		Main.BookView();
		}
	}
	 

}
