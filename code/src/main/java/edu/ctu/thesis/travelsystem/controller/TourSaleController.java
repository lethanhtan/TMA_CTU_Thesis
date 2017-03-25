package edu.ctu.thesis.travelsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.service.BookTourService;

@Controller
public class TourSaleController {
	
	@Autowired
	BookTourService bookTourService;
	
	@RequestMapping(value="toursales", method = RequestMethod.GET)
	public String tourSalesController(ModelMap model, @RequestParam(value = "year", required = true, defaultValue = "2017") int year) {
		List<BookTour> list = bookTourService.listTourByYear(year);
		model.addAttribute("year", year);
		model.addAttribute("sales1", bookTourService.listBookTourByMonth(1, list));
		model.addAttribute("sales2", bookTourService.listBookTourByMonth(2, list));
		model.addAttribute("sales3", bookTourService.listBookTourByMonth(3, list));
		model.addAttribute("sales4", bookTourService.listBookTourByMonth(4, list));
		model.addAttribute("sales5", bookTourService.listBookTourByMonth(5, list));
		model.addAttribute("sales6", bookTourService.listBookTourByMonth(6, list));
		model.addAttribute("sales7", bookTourService.listBookTourByMonth(7, list));
		model.addAttribute("sales8", bookTourService.listBookTourByMonth(8, list));
		model.addAttribute("sales9", bookTourService.listBookTourByMonth(9, list));
		model.addAttribute("sales10", bookTourService.listBookTourByMonth(10, list));
		model.addAttribute("sales11", bookTourService.listBookTourByMonth(11, list));
		model.addAttribute("sales12", bookTourService.listBookTourByMonth(12, list));
		
		/*
		model.addAttribute("sales1", 132);
		model.addAttribute("sales2", 213);
		model.addAttribute("sales3", 212);
		model.addAttribute("sales4", 432);
		model.addAttribute("sales5", 823);
		model.addAttribute("sales6", 271);
		model.addAttribute("sales7", 321);
		model.addAttribute("sales8", 836);
		model.addAttribute("sales9", 121);
		model.addAttribute("sales10", 1211);
		model.addAttribute("sales11", 1210);
		model.addAttribute("sales12", 1501);
		*/
		return "charttoursales";
	}
}
