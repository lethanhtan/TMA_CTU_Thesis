package edu.ctu.thesis.travelsystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ctu.thesis.travelsystem.extra.CheckConnections;
import edu.ctu.thesis.travelsystem.mail.EMailSender;

@Controller
public class SendMailController {
	
	private static final Logger logger = Logger.getLogger(SendMailController.class);
	
	@Autowired
	EMailSender emailSender;
	
	@RequestMapping(value = "/sendmail", method = RequestMethod.GET)
	public String showForm(ModelMap model,
			@RequestParam(value = "email", required = false) String email, 
			@RequestParam(value = "to", required = false) String to,
			@RequestParam(value = "subject", required = false) String subject, 
			@RequestParam(value = "message", required = false) String message,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "host", required = false) String host,
			@RequestParam(value = "port", required = false) Integer port,
			@RequestParam(value = "encoding", required = false) String encoding) {
		if (CheckConnections.checkConnect("https://www.google.com")) {
			if (host != null && encoding != null && email != null && password != null) {
				if (host.equals("Gmail")) {
					host = "smtp.gmail.com";
				}
				emailSender.manualConfig(email, password, host, port, encoding);
				model.addAttribute("status", "Cấu hình email thành công!");
			}
			if (to != null) {
				logger.info("Handle manual send mail!");
				emailSender.SendEmail(to, subject, message);
				model.addAttribute("sendSuccess", "Email đã được gửi đi");
			}
			else {
				model.addAttribute("notify", "Vui lòng điền những thông tin cần thiết");
			}
		}
		else {
			model.addAttribute("failedConnect", "Không có kết nối internet");
		}
		return "sendmail";
	}
}
