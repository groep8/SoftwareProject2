package view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Main;
import view.LoginController;

public class DBBackUpController {
	private String path;
	private String pathSql;
	
    @FXML
    private TextField tf_path;
    @FXML
    private TextField tf_pathsql;

    @FXML
    void browseDump(ActionEvent event) {
    	
    	FileChooser fc = new FileChooser();
    	FileChooser.ExtensionFilter exFilter = new ExtensionFilter("sql", "*.sql");
    	fc.getExtensionFilters().add(exFilter);
    	fc.setTitle("Select a directory and a file name.");
    	try {
    		File f = fc.showSaveDialog(null);
    		path = f.getAbsolutePath();
    		path = path.replace('\\', '/');
    		if(f != null) {
    			try {
    	            FileWriter fileWriter = null;
    	             
    	            fileWriter = new FileWriter(f);
    	            fileWriter.close();
    	            System.out.println(path);
    	        } catch (IOException e) {
    	            LoginController.alert("ERROR: Couldn't create the file.", "The requested file couldn't be created / overwritten.", AlertType.ERROR);
    	        }
    		}
    		tf_path.setText(path);
    	}
    	catch(NullPointerException e) {
    		LoginController.alert("Error: No file specified", "No file has been selected / found.",AlertType.ERROR );
    		e.printStackTrace();
    	}
    }
    @FXML
    void createDump(ActionEvent event) {
    	Process p = null;
    	try {
    		Runtime runtime = Runtime.getRuntime();
    		//A way to run mysqldump on the remote data on the phpmyadmin
    		p = runtime.exec("C:\\Users\\mdexe\\SoftwareProject2\\lib\\mysqldump.exe -P 3306 -u SP2Team08 -h 172.20.0.27 -paqwzsxedc123 SP2Team08 --result-file " + path);
    		
    		int processComplete = p.waitFor();
    		System.out.println(processComplete);
    		if(processComplete == 0) {
    			LoginController.alert("INFO: Created a backup", "A backup has been created", AlertType.INFORMATION);
    		}
    		else {
    			LoginController.alert("Error: Couldn't generate backup.", "Are you sure you selected the right .exe ?",AlertType.ERROR );
    			
    		}
    	}
    	catch(IOException e) {
    		//exception moet nog worden aangepast, programma catched nog niet alle exceptions
    	}
    	catch(Exception e) {
    		LoginController.alert("FATAL ERROR", "Unknown error, please contact your system administrator and report the bug.", AlertType.WARNING);
    	}
    }
    

    @FXML
    void LoadSql(ActionEvent event) {
    	Process p = null;
    	try {
    		if(pathSql != null) {
    			String[] cmd = {"C:\\Users\\mdexe\\SoftwareProject2\\lib\\mysql.exe", "-P 3306", "-u SP2Team08", "-h 172.20.0.27", "-paqwzsxedc123", "SP2Team08","-e", " source " + pathSql};
    			Runtime rt = Runtime.getRuntime();
        		p = rt.exec(cmd);
        		int processComplete = p.waitFor();
        		if(processComplete == 0) {
        			LoginController.alert("INFO: Backup loaded", "The backup has been loaded back into the database.", AlertType.INFORMATION);
        		}
        		else {
        			LoginController.alert("ERROR: Failed to load backup", "Database couldn't be restored.", AlertType.ERROR);
        		}
    		}
    		else {
    			LoginController.alert("ERROR: No path given.", "No file to backup was selected. Please select a backup of the database. (*sql)", AlertType.ERROR);
    		}
    	}
    	catch(IOException e) {
    		//exception moet nog worden aangepast, programma catched nog niet alle exceptions
    	}
    	catch(Exception e) {
    		LoginController.alert("FATAL ERROR", "Unknown error, please contact your system administrator and report the bug.", AlertType.WARNING);
    	}
    }

    @FXML
    void browseForSql(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	FileChooser.ExtensionFilter exFilter = new ExtensionFilter("sql", "*.sql");
    	fc.getExtensionFilters().add(exFilter);
    	fc.setTitle("Select the backup (.sql");
    	
    	try {
    		File f = fc.showOpenDialog(null);
    		pathSql = f.getAbsolutePath();
    		pathSql = pathSql.replace("\\", "/");
    		tf_pathsql.setText(pathSql);
    	}
    	catch(NullPointerException e) {
    		LoginController.alert("Error: No file specified", "No file has been selected / found.",AlertType.ERROR);
    	}
    }
    @FXML
    void quit(ActionEvent event) {
    	Main.addDialogStage.close();
    }

}
