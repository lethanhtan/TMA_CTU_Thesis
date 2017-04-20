package edu.ctu.thesis.travelsystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ctu.thesis.travelsystem.extra.CheckConnections;
import edu.ctu.thesis.travelsystem.mail.EMailSender;
import edu.ctu.thesis.travelsystem.model.Email;
import edu.ctu.thesis.travelsystem.service.EmailService;
import edu.ctu.thesis.travelsystem.service.UserService;

@Controller
public class SendMailController {
	
	private static final Logger logger = Logger.getLogger(SendMailController.class);
	
	@Autowired
	EMailSender emailSender;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/sendmail", method = RequestMethod.GET)
	public String showForm(ModelMap model,
			@RequestParam(value = "from", required = false) String from, 
			@RequestParam(value = "to", required = false) String to,
			@RequestParam(value = "subject", required = false) String subject, 
			@RequestParam(value = "message", required = false) String message,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "host", required = false) String host,
			@RequestParam(value = "port", required = false) Integer port,
			@RequestParam(value = "encoding", required = false) String encoding,
			HttpSession session) {
		Email emailObj = new Email();
		String sender = null;
		List<Email> totalList = emailService.listMail();
		List<Email> successList = emailService.listMailByStaus(true);
		model.addAttribute("totalMail", totalList.size());
		model.addAttribute("numSuccess", successList.size());
		model.addAttribute("phoneUser", session.getAttribute("phone"));
		if (CheckConnections.checkConnect("https://mail.google.com")) {
			if (host != null && encoding != null && from != null && password != null) {
				if (host.equals("Gmail")) {
					host = "smtp.gmail.com";
				}
				if (emailSender.manualConfig(from, password, host, port, encoding)) {
					model.addAttribute("status", "Cấu hình email thành công!");
				}
				else {
					model.addAttribute("status", "Cấu hình email thất bại!");
				}
			}
			if (from == null) {
				model.addAttribute("emailConfig", emailSender.getUserName());
				sender = emailSender.getUserName();
			}
			else {
				model.addAttribute("emailConfig", from);
				sender = from;
			}
			if (to != null) {
				logger.info("Handle manual send mail!");
				logger.info("Process: " + sender + "->" + to);
				emailSender.SendEmail(to, subject, message);
				emailObj.setReciever(to);
				emailObj.setSender(sender); 
				emailObj.setDate(new Date());
				emailObj.setTime(new Date());
				emailObj.setContent(message);
				emailObj.setStatus(false);
				emailObj.setSubject(subject);
				emailObj.setUser(userService.findUserByUserName(((String)session.getAttribute("userName"))));
				emailService.saveEmail(emailObj);
				model.addAttribute("sendSuccess", "Email đã được gửi đi");
			}
			else {
				model.addAttribute("notify", "Vui lòng điền những thông tin cần thiết");
			}
		}
		else {
			model.addAttribute("failedConnect", "Không thể kết nối đến mail server!");
		}
		return "sendmail";
	}
}
