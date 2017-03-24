package edu.ctu.thesis.travelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.service.TourService;

@Controller
public class TourSaleController {
	
	@Autowired
	TourService tourService;
	
	@RequestMapping(value="toursales", method = RequestMethod.GET)
	public String tourSalesController(ModelMap model) {
		model.addAttribute("listTour", tourService.listTourByYear(2017));
		model.addAttribute("Size", tourService.listTourByYear(2017).size());
		return "charttoursales";
	}
}
