package edu.ctu.thesis.travelsystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class NotFoundController {
	@RequestMapping(name = "/notfound")
	public String notFoundController() {
		return "notfound";
	}
}