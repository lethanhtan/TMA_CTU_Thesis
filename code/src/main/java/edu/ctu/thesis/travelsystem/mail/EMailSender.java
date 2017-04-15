package edu.ctu.thesis.travelsystem.mail;

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
	@Autowired
	private JavaMailSenderImpl senderImpl;
 
	public void SendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
 
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromAddress);
		msg.setTo(toAddress);
		msg.setSubject(subject);
		msg.setText(msgBody);
		mailSender.send(msg);
	}
	
	public void setMailSender(String sender) {
		senderImpl.setHost(sender);
	}
	
	public void setMailPassword(String password) {
		senderImpl.setPassword(password);
	}
}
