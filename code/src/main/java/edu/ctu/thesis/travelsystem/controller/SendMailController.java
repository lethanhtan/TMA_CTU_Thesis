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
	public String showForm(ModelMap model,  @RequestParam(value = "from", required = false) String from,
			@RequestParam(value = "to", required = false) String to, 
			@RequestParam(value = "subject", required = false) String subject, 
			@RequestParam(value = "message", required = false) String message,
			@RequestParam(value = "password", required = false) String password) {
		if (CheckConnections.checkConnect("https://www.google.com")) {
			if (from != null && to != null && password != null) {
				logger.info("Handle manual send mail!");
				emailSender.manualConfig(from, password);
				emailSender.SendEmail(to, from, subject, message);
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
