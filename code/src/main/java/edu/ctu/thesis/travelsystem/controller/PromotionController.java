package edu.ctu.thesis.travelsystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ctu.thesis.travelsystem.model.Promotion;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.PromotionService;
import edu.ctu.thesis.travelsystem.service.TourService;

@Controller
public class PromotionController {
	
	private static final Logger logger = Logger.getLogger(PromotionController.class);

	@Autowired
	PromotionService promotionService;
	
	@Autowired
	TourService tourService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
	    dateFormat.setLenient(false);

	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "/update_promotion/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idTour") int idTour) {
		logger.info("Reparing data for update promotion form!");
		Promotion promotion = promotionService.findPromotion(idTour);
		model.addAttribute("idTour", idTour);
		model.addAttribute("fromDate", promotion.getFromDate());
		model.addAttribute("toDate", promotion.getToDate());
		model.put("tour", tourService.findTourById(idTour));
		return "promotions";
	}
	
	@RequestMapping(value = "/update_promotion/{idTour}", method = RequestMethod.POST)
	public String processForm(ModelMap model, @RequestParam(value="fromDate") Date fromDate,
			@RequestParam(value="toDate") Date toDate,
			@RequestParam(value="percent") int percent,
			@PathVariable("idTour") int idTour) {
			logger.info("Updating promotion with id tour: " + idTour);
			Tour tour = tourService.findTourById(idTour);
			tour.getPromotion().setFromDate(fromDate);
			tour.getPromotion().setToDate(toDate);
			tour.getPromotion().setPercent(percent);
			tourService.updateTour(tour);
			model.addAttribute("status", "Cập nhật thành công!");
			
		return "promotions";
	}
}
