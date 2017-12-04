package logic;

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

public class ReminderEmail {
	private LocalDate date;
	final private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public ReminderEmail() {
		date = LocalDate.now();
		
	}
	public void sendRM() {
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("info@sparxsolutions.be"));
			message.setSubject("Reminder Email Training Groep 8 SP 2");
			message.setContent("    <head>\r\n" + 
					"        <style>\r\n" + 
					"\r\n" + 
					"            html{\r\n" + 
					"                font-family: sans-serif;\r\n" + 
					"            }\r\n" + 
					"            #outlineBorder{\r\n" + 
					"                background-color: cornsilk;\r\n" + 
					"                float: center;\r\n" + 
					"                width:800px;\r\n" + 
					"                height:600px;\r\n" + 
					"                border: 1px;\r\n" + 
					"                border-color:black;\r\n" + 
					"                \r\n" + 
					"            }\r\n" + 
					"            #outlineBorder h1{\r\n" + 
					"                text-align: center;\r\n" + 
					"                width: auto;\r\n" + 
					"                height: auto;\r\n" + 
					"                padding-top: 10px;\r\n" + 
					"                text-decoration:underline;\r\n" + 
					"            }\r\n" + 
					"            .textB{\r\n" + 
					"                margin-left:10%;\r\n" + 
					"                margin-right: 10%;\r\n" + 
					"                padding:15px;\r\n" + 
					"                min-width: 400px;\r\n" + 
					"                min-height: 0px;\r\n" + 
					"                max-width:600px;\r\n" + 
					"                margin-top: 2%;\r\n" + 
					"                margin-bottom: 2%;\r\n" + 
					"            }\r\n" + 
					"            img{\r\n" + 
					"                float:right;\r\n" + 
					"                \r\n" + 
					"            }\r\n" + 
					"            th{\r\n" + 
					"                width: auto;\r\n" + 
					"                padding-left: 10px;\r\n" + 
					"                padding-right: 10px;\r\n" + 
					"                padding-top:3px;\r\n" + 
					"                padding-bottom:3px;\r\n" + 
					"            }\r\n" + 
					"            td{\r\n" + 
					"                width:auto;\r\n" + 
					"                padding-left: 10px;\r\n" + 
					"                padding-right: 10px;\r\n" + 
					"                padding-top:3px;\r\n" + 
					"                padding-bottom:3px;\r\n" + 
					"            }\r\n" + 
					"            th{\r\n" + 
					"                width: auto;\r\n" + 
					"                padding-left: 10px;\r\n" + 
					"                padding-right: 10px;\r\n" + 
					"                padding-top:3px;\r\n" + 
					"                padding-bottom:3px;\r\n" + 
					"            }\r\n" + 
					"        </style>\r\n" + 
					"    </head>\r\n" + 
					"    <body>\r\n" + 
					"        <div id=\"outlineBorder\">\r\n" + 
					"            <h1>Reminder: Training (SP2 Groep 8)</h1>\r\n" + 
					"            <h2><!--getter company name--></h2>\r\n" + 
					"            <div class=\"textB\">\r\n" + 
					"                <p>We hereby remind you that you have an upcoming training starting the ... that you must attend to. It is expected from you to particitpate to this </p>\r\n" + 
					"            </div>\r\n" + 
					"            <p><!--training info --></p>\r\n" + 
					"            <div class=\"textB\">\r\n" + 
					"                <table>\r\n" + 
					"                    <tr>\r\n" + 
					"                        <th>Training</th>\r\n" + 
					"                        <th>Location</th>\r\n" + 
					"                        <th>Start date</th>\r\n" + 
					"                        <th>End Date</th>\r\n" + 
					"                    </tr>\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td>Software Project 2</td>\r\n" + 
					"                        <td>Nijverheidskaai anderlecht</td>\r\n" + 
					"                        <td>04/12/2017</td>\r\n" + 
					"                        <td>04/12/2017</td>\r\n" + 
					"                    </tr>\r\n" + 
					"                </table>\r\n" + 
					"            </div>\r\n" + 
					"            <div class=\"textB\">\r\n" + 
					"                <p>Do not forget to upload your certificate at the end of the training through the employee website: <a href=\"\">http://www.uploadyourfileshere.com/dontactuallyclick.com</a></p>\r\n" + 
					"            </div>\r\n" + 
					"        </div>\r\n" + 
					"    </body>", "text/html; charset=utf-8");
			Transport.send(message);
			System.out.println("An email was sent.");
		}
		catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ReminderEmail rm = new ReminderEmail();
		rm.sendRM();
	}
}

