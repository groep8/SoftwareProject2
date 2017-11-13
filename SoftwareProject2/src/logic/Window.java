package logic;

import javafx.application.Application;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Window extends Application {
	Stage WindowStage;
	Scene WindowScene;
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        @SuppressWarnings("rawtypes")
		XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data<Integer, Integer>(1, 23));
        series.getData().add(new XYChart.Data<Integer, Integer>(2, 14));
        series.getData().add(new XYChart.Data<Integer, Integer>(3, 15));
        series.getData().add(new XYChart.Data<Integer, Integer>(4, 24));
        series.getData().add(new XYChart.Data<Integer, Integer>(5, 34));
        series.getData().add(new XYChart.Data<Integer, Integer>(6, 36));
        series.getData().add(new XYChart.Data<Integer, Integer>(7, 22));
        series.getData().add(new XYChart.Data<Integer, Integer>(8, 45));
        series.getData().add(new XYChart.Data<Integer, Integer>(9, 43));
        series.getData().add(new XYChart.Data<Integer, Integer>(10, 17));
        series.getData().add(new XYChart.Data<Integer, Integer>(11, 29));
        series.getData().add(new XYChart.Data<Integer, Integer>(12, 25));
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        
        stage.setScene(scene);
        stage.show();
    }
	/*@Override
	public void start(Stage primeStage) throws Exception {
		WindowStage = primeStage;
		WindowStage.setTitle("Graphs");
		Label graph1 = new Label();
		graph1.setText("Graph:");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		GridPane.setConstraints(graph1, 4, 4);
		grid.getChildren().addAll(graph1);
		WindowScene = new Scene(grid, 800, 600);
		WindowStage.setScene(WindowScene);
		
		WindowStage.setOnCloseRequest(e -> {
			e.consume();
			close();
		});
		WindowStage.show();
		
	}
	private void close() {
		Boolean sureExit = ConfirmBox.display("Exit", "Are you sure you want to exit the program?");
		if(sureExit == true) {
			WindowStage.close();
		}
	}*/
	public static void main(String[] args) {
		launch(args);
	}

	//code from https://docs.oracle.com/javafx/2/charts/line-chart.htm
}
