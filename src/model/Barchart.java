package model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class Barchart extends Application {
    String austria = "Austria";
    String brazil = "Brazil";
    String france = "France";
	String italy = "Italy";
	String usa = "USA";
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Branches");
        xAxis.setLabel("Country");       
        yAxis.setLabel("Amount");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");       
        series1.getData().add(new XYChart.Data(austria, 1000));
        series1.getData().add(new XYChart.Data(brazil, 1500));
        series1.getData().add(new XYChart.Data(france, 1200));
        series1.getData().add(new XYChart.Data(italy, 1400));
        series1.getData().add(new XYChart.Data(usa, 1700));      
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(austria, 1700));
        series2.getData().add(new XYChart.Data(brazil, 1580));
        series2.getData().add(new XYChart.Data(france, 1670));
        series2.getData().add(new XYChart.Data(italy, 1765));
        series2.getData().add(new XYChart.Data(usa, 2450));  
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(austria, 1400));
        series3.getData().add(new XYChart.Data(brazil, 1200));
        series3.getData().add(new XYChart.Data(france, 1800));
        series3.getData().add(new XYChart.Data(italy, 1200));
        series3.getData().add(new XYChart.Data(usa, 2000));  
        
        Scene scene  = new Scene(bc);
        bc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
