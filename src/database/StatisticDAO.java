package database;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;

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
import model.*;

public class StatisticDAO {
	
	public static ArrayList<Chartdata> getData(String arg, String archiveString, String table){
		Session session = Main.factory.getCurrentSession();
		
		String az = "SELECT " + arg + ", COUNT(" + arg + ") FROM " + table + " WHERE archief =< " + archiveString;
		
		ArrayList<Chartdata> cdata = null;
		
		try {
			session.beginTransaction();
			
			cdata = (ArrayList<Chartdata>)session.createNativeQuery(az, Chartdata.class).getResultList();
			

			session.getTransaction().commit();
			
		}
			catch(Exception e) {
				e.printStackTrace();
				
		}
		
		return cdata;
		
	}
	
	
	public StatisticDAO() {
		// TODO Auto-generated constructor stub
	}

}
