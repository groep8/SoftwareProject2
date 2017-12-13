package logic;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ApiController extends Application {
	
	@FXML
	private TextField text;
	@FXML
	private ListView<String>listview;


	
	
	public void button() {
		listview.getItems().clear();
		  ArrayList<String> result= new ArrayList<String>();
		String search = text.getText();
		String[] book = new String[] {"--title", search};
		
		 try {
			result=Book.queryGoogleBooks(book);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 listview.getItems().addAll(result);
		
}
	
	
	public static Stage p;
	
	public void start(Stage p) throws IOException {
		//this.p=p;
		Parent root = FXMLLoader.load(getClass().getResource("/logic/api.fxml"));
		Scene scene = new Scene(root);
		p.setScene(scene);
		p.show();
		p.setResizable(false);
		
		
	}
	public static void main(String[] args) {
		
		launch(args);
		
	}
	


}
