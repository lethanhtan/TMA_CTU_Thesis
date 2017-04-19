package edu.ctu.thesis.travelsystem.mail;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
 
@Service("Email")
public class EMailSender {
	
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
		mailSender.send(msg);
	}
	
	public void manualConfig(String userName, String password, String host, int port, String encoding) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        
        //Using gmail
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(userName);
        mailSender.setPassword(password);
        mailSender.setDefaultEncoding(encoding);
         
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
        
        mailSender.setJavaMailProperties(javaMailProperties);
	}
}
