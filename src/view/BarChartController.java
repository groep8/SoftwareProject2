package view;

import java.io.IOException;
import java.sql.SQLException;

import database.StatisticDAO;
import database.TrainingDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Adres;
import model.Main;

public class BarChartController {


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


	public void generateBar() throws SQLException, IOException {
		
		String arg = argu.getSelectionModel().getSelectedItem();
		String tabel = table.getSelectionModel().getSelectedItem();
		String a = gearchiveerd.getSelectionModel().getSelectedItem();
		String ver = verg.getSelectionModel().getSelectedItem();
		if (a.equals("nee")){
			a = "!=";
		}
		else if (a.equals("ja")) {
			a = "=";
		}
		else {
			a = "<=";
		}
		String ja = jaar.getSelectionModel().getSelectedItem();
		Main.Barchart(arg,a, tabel,ja, ver);
		
	}
	
	 public void cancel() {
		
			Main.addDialogStage.close();
	 }



}
