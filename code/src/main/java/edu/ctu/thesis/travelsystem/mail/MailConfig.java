package edu.ctu.thesis.travelsystem.mail;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	private static final Logger logger = Logger.getLogger(MailConfig.class);
	
	 @Bean
	    public JavaMailSender getMailSender(){
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	         
	        //Using gmail
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("nytravelsystem@gmail.com");
	        mailSender.setPassword("29032017");
	        mailSender.setDefaultEncoding("UTF-8");
	         
	        Properties javaMailProperties = new Properties();
	        javaMailProperties.put("mail.smtp.starttls.enable", "true");
	        javaMailProperties.put("mail.smtp.auth", "true");
	        javaMailProperties.put("mail.transport.protocol", "smtp");
	        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
	        
	        logger.info("Config mailbox!");
	        mailSender.setJavaMailProperties(javaMailProperties);
	        return mailSender;
	    }
}
