package edu.ctu.thesis.travelsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TourSaleController {
	
	@RequestMapping(value="toursales", method = RequestMethod.GET)
	public String tourSalesController(ModelMap model) {
		List<Sales> list = new ArrayList<Sales>();
		list.add(new Sales("1", 121, "#FF0F00"));
		list.add(new Sales("2", 125, "#FF6600"));
		list.add(new Sales("3", 125, "#FF0F00"));
		list.add(new Sales("4", 125, "#FF0F00"));
		list.add(new Sales("5", 125, "#FF0F00"));
		list.add(new Sales("6", 125, "#FF0F00"));
		list.add(new Sales("7", 125, "#FF0F00"));
		list.add(new Sales("8", 125, "#FF0F00"));
		list.add(new Sales("9", 125, "#FF0F00"));
		list.add(new Sales("10", 125, "#FF0F00"));
		list.add(new Sales("11", 125, "#FF0F00"));
		list.add(new Sales("12", 125, "#FF0F00"));
		model.addAttribute("Data", list.toArray());
		return "charttoursales";
	}
}
