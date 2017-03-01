package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("managetour")
public class ManageTourController {

	@RequestMapping(method = RequestMethod.GET)
	public String managetourController(ModelMap model, HttpSession session) {
		System.out.println(session.getAttribute("roleId"));
		String result;
		try {
			if ((Integer)session.getAttribute("roleId") == 2) {
				result = "managetour";
			} else {
				result = "forbidden";
			}
		}catch (Exception e) {
			//e.printStackTrace();
			result = "forbidden";
		}
		
		return result;
	}
}