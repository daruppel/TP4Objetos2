package mailPunto2TP6;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dominio.Venta;

public class mailMain implements Observador {

	public void actualizar(Venta venta, String destinatario) {
		// remitente
		String to = "denisruppelvilla@gmail.com";
		// destinatario
		String from = "denisruppelvilla@gmail.com";

		// usuario y clave que se obtiene desde Mailtrap
		final String username = "baa9bcb67c6f48";
		final String password = "eb37566ba9c0f6";
		String host = "smtp.mailtrap.io";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");// it’s optional in Mailtrap
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");
		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Titulo del email...");
			message.setText(venta.toString());
			// Send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
