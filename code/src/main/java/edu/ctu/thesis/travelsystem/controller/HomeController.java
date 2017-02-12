package edu.ctu.thesis.travelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirectController(ModelMap model) {

		return "index";
	}

	@RequestMapping(value = "trang-chu", method = RequestMethod.GET)
	public String homeController(ModelMap model) {

		return "home";
	}
	
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String adminController(ModelMap model) {

		return "managetour";
	}

}