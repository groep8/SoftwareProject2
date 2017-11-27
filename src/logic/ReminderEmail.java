package logic;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ReminderEmail {
	public static void main(String[] args) {
		final String username = "noreply.groep8sp2@gmail.com";
		final String password = "aqwzsxedc123";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465"); 
		props.put("mail.smtp.socketFactory.port", "465"); // same question
        props.put("mail.smtp.socketFactory.class", 
            "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.port", "587");
		
		Session sess = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthetication() {
						return new PasswordAuthentication(username, password);
					}
				});
		try {
			Message message = new MimeMessage(sess);
			message.setFrom(new InternetAddress(username));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("mdexelle@gmail.com"));
			message.setSubject("Let's try this email class");
			message.setContent("", "text/html; charset=utf-8");
			Transport transport = sess.getTransport("smtp");
			transport.connect("smtp.gmail.com", 465, username, password );
			Transport.send(message);
			System.out.println("An email was sent.");
		}
		catch(MessagingException e) {
			e.printStackTrace();
		}
	}
}

