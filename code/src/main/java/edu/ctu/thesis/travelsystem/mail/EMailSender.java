package edu.ctu.thesis.travelsystem.mail;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
 
@Service("Email")
public class EMailSender{
	
	private static String host = "smtp.gmail.com";
	
	private static String userName = "nytravelsystem@gmail.com";
	
	private static int port = 587;
	
	private static String encoding = "UTF-8";
	
	private static String password = "29032017";
	
	@Autowired
	private MailSender mailSender; // MailSender interface defines a strategy
										// for sending simple mails
 
	public void SendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
 
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromAddress);
		msg.setTo(toAddress);
		msg.setSubject(subject);
		msg.setText(msgBody);
		mailSender.send(msg);
	}
	
	public void SendEmail(String toAddress, String subject, String msgBody) {
		 
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(toAddress);
		msg.setSubject(subject);
		msg.setText(msgBody);
		mailSender.send(msg);	}
	
	public boolean manualConfig(String userName, String password, String host, int port, String encoding) {
		//JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		EMailSender.host = host;
        EMailSender.userName = userName;
        EMailSender.port = port;
        EMailSender.encoding = encoding;
        EMailSender.password = password;
        //Using gmail
        ((JavaMailSenderImpl) mailSender).setHost(EMailSender.host);
        ((JavaMailSenderImpl) mailSender).setPort(EMailSender.port);
        ((JavaMailSenderImpl) mailSender).setUsername(EMailSender.userName);
        ((JavaMailSenderImpl) mailSender).setPassword(EMailSender.password);
        ((JavaMailSenderImpl) mailSender).setDefaultEncoding(EMailSender.encoding);
         
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
        
        ((JavaMailSenderImpl) mailSender).setJavaMailProperties(javaMailProperties);
        return checkAuthentication(javaMailProperties);
	}
	
	public static boolean checkAuthentication(Properties props) {
		try {
			Session session = Session.getInstance(props, null);
			Transport transport = session.getTransport("smtp");
			transport.connect(EMailSender.host, EMailSender.port, EMailSender.userName, EMailSender.password);
			transport.close();
			return true;
		} catch (AuthenticationFailedException e) {
			return false;
		} catch (MessagingException e) {
			return false;
		}
	}
	
	public String getUserName() {
		return EMailSender.userName;
	}
}
