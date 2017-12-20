package view;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Main;

public class LineChartController {
	
		@FXML
		private TextField argu;
		
		@FXML
		private TextField table;
		
		@FXML
		private TextField gearchiveerd;
		
		@FXML
		private TextField jaar;
		
		
		public void generateLine() throws SQLException, IOException {
			
			String arg = argu.getText();
			String tabel = table.getText();
			String a = gearchiveerd.getText();
			String ja = jaar.getText(); 
			Main.Linechart(arg,a, tabel,ja);
			
		}
		
		 public void cancel() {
			
				Main.addDialogStage.close();
		 }



}
