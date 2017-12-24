package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	private LocalDate date;
	final private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public Email() {
		date = LocalDate.now();
		
	}
	public void sendDump() {
		final String username = "noreply.groep8sp2@gmail.com";
		final String password = "aqwzsxedc123";
		
		Properties props = new Properties();
		
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587"); 
		
		Session sess = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(sess);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mdexelle@gmail.com"));
			message.setSubject("Back up has been created Groep 8 SP 2");
			message.setContent("<html>\r\n" + 
					"    <head>\r\n" + 
					"        <style>\r\n" + 
					"            html{\r\n" + 
					"                font-family: sans-serif;\r\n" + 
					"            }\r\n" + 
					"            #outlineBorder{\r\n" + 
					"                background-color: midnightblue;\r\n" + 
					"                float: center;\r\n" + 
					"                width:800px;\r\n" + 
					"                height:500px;\r\n" + 
					"                border-radius: 10px;\r\n" + 
					"                background: linear-gradient(white,midnightblue);\r\n" + 
					"                \r\n" + 
					"            }\r\n" + 
					"            #outlineBorder h1{\r\n" + 
					"                text-align: center;\r\n" + 
					"                width: auto;\r\n" + 
					"                height: auto;\r\n" + 
					"                padding-top: 25px;\r\n" + 
					"                text-decoration:underline;\r\n" + 
					"                font-size: 30px;\r\n" + 
					"            }\r\n" + 
					"            .textB{\r\n" + 
					"                font-size: 19px;\r\n" + 
					"                margin-left:10%;\r\n" + 
					"                margin-right: 10%;\r\n" + 
					"                padding:4px;\r\n" + 
					"                min-width: 400px;\r\n" + 
					"                min-height: 0px;\r\n" + 
					"                max-width:600px;\r\n" + 
					"                margin-top: 1%;\r\n" + 
					"                margin-bottom: 2%;\r\n" + 
					"            }\r\n" + 
					"            img{\r\n" + 
					"                float:right;\r\n" + 
					"                \r\n" + 
					"            }\r\n" + 
					"        </style>\r\n" + 
					"    </head>\r\n" + 
					"    <body>\r\n" + 
					"        <div id=\"outlineBorder\">\r\n" + 
					"            <h1>Admin notification: The database has been back up</h1>\r\n" + 
					"            <h2><!--getter company name--></h2>\r\n" + 
					"            <div class=\"textB\">\r\n" + 
					"                <p>The database has been backed up by user \"" + Main.currentLogged.getUsername() + "\" the " + dtf.format(date) +".</p>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"textB\">\r\n" + 
					"                <p>If there is a need to restore the database, user \"" + Main.currentLogged.getUsername() + "\" can be contacted to load it back. Please use the application created for that purpose of the HR departement linked to the trainings</p>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"textB\">\r\n" + 
					"                <p>(Don't forget you need to be connected to the VPN to access the phpmadmin database of the application ! )</p>\r\n" + 
					"            </div>\r\n" + 
					"             <img src=\" ..\\lib\\img.ico\"/>\r\n" + 
					"        <footer></footer>\r\n" + 
					"        </div>\r\n" + 
					"    </body>\r\n" + 
					"</html>", "text/html; charset=utf-8");
			Transport.send(message);
		}
		catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	public void sendRestore() {
		final String username = "noreply.groep8sp2@gmail.com";
		final String password = "aqwzsxedc123";
		
		Properties props = new Properties();
		
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587"); 
		
		Session sess = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(sess);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mdexelle@gmail.com"));
			message.setSubject("Back up has been created Groep 8 SP 2");
			message.setContent("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"    <head>\r\n" + 
					"        <style>\r\n" + 
					"            html{\r\n" + 
					"                font-family: sans-serif;\r\n" + 
					"            }\r\n" + 
					"            #outlineBorder{\r\n" + 
					"                background-color: midnightblue;\r\n" + 
					"                float: center;\r\n" + 
					"                width:800px;\r\n" + 
					"                height:500px;\r\n" + 
					"                border-radius: 10px;\r\n" + 
					"                background: linear-gradient(white,midnightblue);\r\n" + 
					"                \r\n" + 
					"            }\r\n" + 
					"            #outlineBorder h1{\r\n" + 
					"                text-align: center;\r\n" + 
					"                width: auto;\r\n" + 
					"                height: auto;\r\n" + 
					"                padding-top: 25px;\r\n" + 
					"                text-decoration:underline;\r\n" + 
					"                font-size: 30px;\r\n" + 
					"            }\r\n" + 
					"            .textB{\r\n" + 
					"                font-size: 19px;\r\n" + 
					"                margin-left:10%;\r\n" + 
					"                margin-right: 10%;\r\n" + 
					"                padding:4px;\r\n" + 
					"                min-width: 400px;\r\n" + 
					"                min-height: 0px;\r\n" + 
					"                max-width:600px;\r\n" + 
					"                margin-top: 1%;\r\n" + 
					"                margin-bottom: 2%;\r\n" + 
					"            }\r\n" + 
					"            img{\r\n" + 
					"                float:right;\r\n" + 
					"                \r\n" + 
					"            }\r\n" + 
					"        </style>\r\n" + 
					"    </head>\r\n" + 
					"    <body>\r\n" + 
					"        <div id=\"outlineBorder\">\r\n" + 
					"            <h1>Admin notification: The database has been restored.</h1>\r\n" + 
					"            <h2><!--getter company name--></h2>\r\n" + 
					"            <div class=\"textB\">\r\n" + 
					"                <p>The database has been restored by user \""+ Main.currentLogged.getUsername() + "\" the " + dtf.format(date) + "  .</p>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"textB\">\r\n" + 
					"                <p>To restore the database to a previous version, conctact the last person who backed up the database before this restore.</p>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"textB\">\r\n" + 
					"                <p>(Don't forget you need to be connected to the VPN to access the phpmadmin database of the application ! )</p>\r\n" + 
					"            </div>\r\n" + 
					"             <img src=\"img.ico\"/>\r\n" + 
					"        <footer></footer>\r\n" + 
					"        </div>\r\n" + 
					"    </body>\r\n" + 
					"</html>", "text/html; charset=utf-8");
			Transport.send(message);
		}
		catch(MessagingException e) {
			e.printStackTrace();
		}
	}
}

