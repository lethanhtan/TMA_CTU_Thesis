package edu.ctu.thesis.travelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FobiddenController {
	
	@RequestMapping(name = "forbidden", method = RequestMethod.GET)
	public String forbidedenController() {
		return "forbidden";
	}
	
}
