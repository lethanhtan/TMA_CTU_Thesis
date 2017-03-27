package edu.ctu.thesis.travelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class NotFoundController {
	
	@RequestMapping(name = "/notfound")
	public String notFoundController() {
		return "notfound";
	}
}
