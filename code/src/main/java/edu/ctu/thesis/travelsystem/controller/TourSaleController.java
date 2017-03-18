package edu.ctu.thesis.travelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TourSaleController {
	
	@RequestMapping(value="toursales", method = RequestMethod.GET)
	public String tourSalesController(ModelMap model) {
		return "charttoursales";
	}
}
