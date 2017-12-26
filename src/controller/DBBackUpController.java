package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import controller.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Email;
import model.Main;
import model.Javaloc;

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
    	}
    }
    @FXML
    void createDump(ActionEvent event) {
    	Process p;
    	try {
    		Runtime runtime = Runtime.getRuntime();
    		String k = Javaloc.javaloc("lib/mysqldump.exe");
			k += "  -P 3306 -u SP2Team08 -h 172.20.0.27 -paqwzsxedc123 SP2Team08 --add-drop-database --quick --result-file " + path;
			System.out.println(k);
    		p = runtime.exec(k);
    		//p = runtime.exec("C:\\Users\\mdexe\\SoftwareProject2\\lib\\mysqldump.exe -P 3306 -u SP2Team08 -h 172.20.0.27 -paqwzsxedc123 SP2Team08 --add-drop-database --quick --result-file " + path);
    		int processComplete = p.waitFor();
    		System.out.println(processComplete);
    		if(processComplete == 0) {
    			LoginController.alert("INFO: Created a backup", "A backup has been created and an email has been sent to the head of the department.", AlertType.INFORMATION);
    			Email backEm = new Email();
    			backEm.sendDump();
    		}
    		else {
    			LoginController.alert("Error: Couldn't generate backup.", "Couldn't generate the backup. Check if you are connected to the VPN.",AlertType.ERROR );
    			
    		}
    	}
    	catch(IOException e) {
    		LoginController.alert("ERROR: Path to the file hasn't been found", "No path to a .sql file was specified or the path is wrong.", AlertType.ERROR);
    	}
    	catch(Exception e) {
    		LoginController.alert("FATAL ERROR", "Unknown error, please contact your system administrator and report the bug.", AlertType.WARNING);
    		e.printStackTrace();
    	}
    }
    

    @FXML
    void LoadSql(ActionEvent event) {
    	Process p;
    	try {
    		if(pathSql != null) {
    			Runtime rt = Runtime.getRuntime();
    			String k = Javaloc.javaloc("lib/mysql.exe");
    			k += " --host 172.20.0.27 --user=SP2Team08 --password=aqwzsxedc123 -D SP2Team08 --execute=\"source "+ pathSql +"\"";
        		p = rt.exec(k);
        		int processComplete = p.waitFor();
        		System.out.println(processComplete);
        		if(processComplete == 0) {
        			LoginController.alert("INFO: Backup loaded", "The backup has been loaded back into the database.", AlertType.INFORMATION);
        			Email rest = new Email();
        			rest.sendRestore();
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
    		LoginController.alert("ERROR: Error with given path.", "There is an error in the path of the file or in the sql script contained in it. Please use another sql file to back up the database.", AlertType.ERROR);
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
