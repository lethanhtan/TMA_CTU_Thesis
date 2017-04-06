package edu.ctu.thesis.travelsystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.TourService;

import org.springframework.ui.ModelMap;

@Controller
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	TourService tourService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirectController(ModelMap model) {
		//log debug message
		if (logger.isDebugEnabled()) {
			logger.debug("redirectController is executed!");
		}
		return "home";
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String loadPage(ModelMap model) {
		model.addAttribute("tour", new Tour() );
		model.addAttribute("tourList", tourService.listTour());
		return "home";
	}
	
	public String showPage(ModelMap model) {
		return "home";
	}
}