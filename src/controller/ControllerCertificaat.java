package controller;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ControllerCertificaat extends Application {

@FXML
private ListView<String> listview=new ListView<String>();

@FXML
private Label label;
@FXML
private ListView<String> listview2=new ListView<String>();

public void refreshButton() throws SocketException, IOException {
	listview.getItems().clear();
	listview2.getItems().clear();
	ArrayList<String>files=new ArrayList<String>();
	files=PDFUpload.getAllFiles();
	listview.getItems().addAll(files);
	ArrayList<String>files2=new ArrayList<String>();
	files2=PDFUpload.getAllFilesFTP();
	listview2.getItems().addAll(files2);
}
public void retrieveButton() throws SocketException, IOException {
	if(listview2.getSelectionModel().getSelectedItems()!=null) {
		
		String selected = (String) listview2.getSelectionModel().getSelectedItem();
		ArrayList<String>list=new ArrayList<String>();
		list=PDFUpload.getAllFiles();
		
		try {
			
			PDFUpload.retrieveFiles(selected);
			
			
		} catch (Exception e) {
			label.setText("Transfer succeeded!");
			//e.printStackTrace();
		}
			
		}
	
		refreshButton();
		/*listview.getItems().clear();
		listview2.getItems().clear();
		ArrayList<String>files=new ArrayList<String>();
		files=PDFUpload.getAllFiles();
		listview.getItems().addAll(files);
		ArrayList<String>files2=new ArrayList<String>();
		files2=PDFUpload.getAllFilesFTP();
		listview2.getItems().addAll(files2);*/
		
		}

public void sendButton() throws SocketException, IOException  {
	if(listview.getSelectionModel().getSelectedItems()!=null) {
		
	String selected = (String) listview.getSelectionModel().getSelectedItem();
	ArrayList<String>list=new ArrayList<String>();
	list=PDFUpload.getAllFilesFTP();
	
	try {
		
		PDFUpload.uploadToServer(selected);
		
		
	} catch (Exception e) {
		
		//e.printStackTrace();
	}
	
		
	}
	
	refreshButton();
	/*listview.getItems().clear();
	listview2.getItems().clear();
	ArrayList<String>files=new ArrayList<String>();
	files=PDFUpload.getAllFilesFTP();
	listview2.getItems().addAll(files);
	ArrayList<String>files2=new ArrayList<String>();
	files2=PDFUpload.getAllFiles();
	listview.getItems().addAll(files2);*/
	
	}

	


public void initialize() throws SocketException, IOException {
	refreshButton();
	/*listview.getItems().clear();
	listview2.getItems().clear();
	ArrayList<String>files=new ArrayList<String>();
	files=PDFUpload.getAllFilesFTP();
	listview2.getItems().addAll(files);
	ArrayList<String>files2=new ArrayList<String>();
	files2=PDFUpload.getAllFiles();
	listview.getItems().addAll(files2);*/
}
	@Override
	public void start(Stage p) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/viewCertificaat.fxml"));
		Scene scene = new Scene(root);
		p.setScene(scene);
		p.show();
		p.setResizable(false);
		
		
		
	}

}
