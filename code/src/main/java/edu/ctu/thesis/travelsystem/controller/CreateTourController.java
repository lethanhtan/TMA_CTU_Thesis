package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("createtour")
public class CreateTourController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String createtourController(ModelMap model, HttpSession session) {
		if ((Integer)session.getAttribute("roleId") == 2) {
			return "createtour";
		} else {
			return "forbidden";
		}
	}
}
