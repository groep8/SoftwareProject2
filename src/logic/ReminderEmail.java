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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mdexelle@gmail.com"));
			message.setSubject("Reminder Email Training Groep 8 SP 2");
			message.setContent("<p>" + dtf.format(date) + "</p>", "text/html; charset=utf-8");
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

