package edu.ctu.thesis.travelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TourResController {
	
	@RequestMapping(value="tourres", method = RequestMethod.GET)
	public String tourResController(ModelMap model) {
		return "charttourres";
	}
}

