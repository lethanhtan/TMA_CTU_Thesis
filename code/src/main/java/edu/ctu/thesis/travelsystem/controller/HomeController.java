package edu.ctu.thesis.travelsystem.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
public class HomeController {
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirectController(ModelMap model) {
		//log debug message
		if (logger.isDebugEnabled()) {
			logger.debug("redirectController is executed!");
		}
		//log exception
		//logger.error("This is error message!", new Exception("Testing"));
		return "home";
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String homeController(ModelMap model) {

		return "home";
	}
}