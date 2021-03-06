package model;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.Group;
	 
public class Piechart extends Application {
	 
	@Override 
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setTitle("Specializations");
		
		
		ObservableList<Data> pieChartData = FXCollections.observableArrayList(
    		new Data("JAVA", 13),
    		new Data("C++", 25),
    		new Data("PYTHON", 10),
    		new Data("HTML5", 22),
    		new Data("KOPLIN", 30));
		PieChart chart = new PieChart(pieChartData);
		((Group) scene.getRoot()).getChildren().add(chart);
		stage.setScene(scene);
		stage.show();
		
		final Label caption = new Label("");
		caption.setTextFill(Color.DARKORANGE);
		caption.setStyle("-fx-font: 24 arial;");
		
		for (final PieChart.Data data : chart.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {
					@Override 
					public void handle(MouseEvent e) {
						caption.setTranslateX(e.getSceneX());
						caption.setTranslateY(e.getSceneY());
						caption.setText(String.valueOf(data.getPieValue()) + "%");
					}
				}
			);
		}
	}
	 
	public static void main(String[] args) {
	    launch(args);
	}
}
