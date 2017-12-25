package controller;
 


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;

import javafx.scene.control.ListView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class PDFUpload {
	
	public static Boolean uploadToServer(String text) throws Exception {

	 	String server = "10.3.50.16";
        int port=21;
        String user = "Halil";
        String pass = "test";

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server,port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalActiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            String secondRemoteFile = ("/Halil/" + text);
            InputStream inputStream = new FileInputStream("./certs/"+text);

            //System.out.println("Start uploading first file");
            OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
            byte[] bytesIn = new byte[4096];
            int read = 0;

            while ((read = inputStream.read(bytesIn)) != -1) {
                outputStream.write(bytesIn, 0, read);
            }
            inputStream.close();
            outputStream.close();
            boolean completed = ftpClient.completePendingCommand();
            if (completed) {
                //System.out.println("The first file is uploaded successfully.");
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
	return true;
}
	
	public static void retrieveFiles(String selectedFile) {
        String server = "10.3.50.16";
        int port = 21;
        String user = "Halil";
        String pass = "test";
 
        FTPClient ftpClient = new FTPClient();
        try {
 
            ftpClient.connect(server);
            ftpClient.login(user, pass);
            ftpClient.enterLocalActiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
 
            // APPROACH #1: using retrieveFile(String, OutputStream)
            String remoteFile1 = "/Halil/"+selectedFile;
            File downloadFile1 = new File("./certs/"+selectedFile);
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
 
          
        } catch (IOException ex) {
          //  System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                    
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
	
		  public static ArrayList<String> getAllFilesFTP() throws SocketException, IOException {
			  FTPClient client = new FTPClient();
			  ArrayList<String>filesFTP = new ArrayList<String>();
		        boolean result;
		        try 
		        {
		        	client.connect("10.3.50.16");
		                result = client.login("Halil", "test");
		                client.changeWorkingDirectory("/Halil");
		                if (result == true) 
		                {
		                       // System.out.println("Logged in Successfully !");
		                }
		                else 
		                {
		                       // System.out.println("Login failed !");
		                        return null;
		                }
		                FTPFile[] files = client.listFiles();
		                //System.out.println("Files and directories on Ftp Server directory : ");
		                for (FTPFile file : files) 
		                {
		                       // System.out.println(file.getName());
		                        filesFTP.add(file.getName());
		                }

		        }
		 
		        catch (FTPConnectionClosedException e) 
		        {
		              //  System.out.println(e);
		        }
		        finally 
		        {
		        try 
		        {
		        	client.logout();
		        client.disconnect();
		        }
		        catch (FTPConnectionClosedException e) 
		        {
		                        System.out.println(e);
		        }
		        }
				return filesFTP;
		        }
				
public static ArrayList<String> getAllFiles(){
	File folder = new File("./certs");
	File[] listOfFiles = folder.listFiles();
    ArrayList<String>files=new ArrayList<String>();
	    for (File list: listOfFiles) {
	      if (list.isFile()) {
	       //System.out.println("File " + listOfFiles[i].getName());
	        files.add(list.getName());
	      } else if (list.isDirectory()) {
	      //  System.out.println("Directory " + listOfFiles[i].getName());
	        files.add(list.getName());
	      }
	    }
	return files;
	
}

		
	/*public static void main(String[] args) throws Exception {
		//String file= new String("./Template.pdf");
		//		uploadToServer(file);
		String file=new String("test1.pdf");
			retrieveFiles(file);
		
	//
		    //getAllFilesFTP();
	}*/
	}
	


	   
	    
