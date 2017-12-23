package view;

import java.io.IOException;
import java.sql.SQLException;

import database.StatisticDAO;
import database.TrainingDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Main;

public class LineChartController {
	
	@FXML
	private ComboBox<String> argu;

	@FXML
	private ComboBox<String> table;


	@FXML
	private ComboBox<String> gearchiveerd;


	@FXML
	private ComboBox<String> jaar;
	
	@FXML
	private ComboBox<String> verg;

	@FXML
	private void initialize() {
		gearchiveerd.getItems().setAll("nee", "ja", "alles");
		gearchiveerd.getSelectionModel().selectFirst();
		table.getItems().setAll("Adres","Leerkracht","Training","TrainingDetail");
		table.setOnAction((e) ->{
			ObservableList<String> adreslist = FXCollections.observableArrayList(StatisticDAO.getTable(table.getSelectionModel().getSelectedItem()));
			argu.setItems(adreslist);
			});
		ObservableList<String> jaren = FXCollections.observableArrayList(StatisticDAO.getJaar());
		jaren.add("Alles");
		jaar.setItems(jaren);
		ObservableList<String> verge = FXCollections.observableArrayList(StatisticDAO.getJaar());
		verge.add(0,"nee");
		verg.setItems(verge);
		verg.getSelectionModel().selectFirst();
		
	}
		
		
		public void generateLine() throws SQLException, IOException {
			
			String arg = argu.getSelectionModel().getSelectedItem();
			String tabel = table.getSelectionModel().getSelectedItem();
			String a = gearchiveerd.getSelectionModel().getSelectedItem();
			String ja = jaar.getSelectionModel().getSelectedItem();
			String ve = verg.getSelectionModel().getSelectedItem();
			if (a.equals("nee")){
				a = "!=";
			}
			else if (a.equals("ja")) {
				a = "=";
			}
			else {
				a = "<=";
			}
			
			if(ja == null || arg == null || tabel == null) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Confirmation");
				alert.setContentText("Error, 1 of meerdere argumenten zijn niet geselecteerd");
				alert.setHeaderText(null);
				alert.showAndWait();
				Main.addDialogStage.close();
				
			}
			else {
				Main.Linechart(arg,a, tabel,ja, ve);
			}
			
			
		}
		
		 public void cancel() {
			
				Main.addDialogStage.close();
		 }



}
