package edu.ctu.thesis.travelsystem.controller;

import java.util.Date;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = "/update_promotion/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idTour") int idTour) {
		logger.info("Reparing data for update promotion form!");
		model.addAttribute("idTour", idTour);
		model.put("promotionData", promotionService.findPromotion(idTour));
		model.put("tour", tourService.findTourById(idTour));
		return "promotions";
	}
	
	@RequestMapping(value = "/update_promotion/{idTour}", method = RequestMethod.POST)
	public String processForm(@RequestParam(value="fromDate") Date fromDate,
			@RequestParam(value="toDate") Date toDate,
			@RequestParam(value="percent") int percent,
			@PathVariable("idTour") int idTour) {
			logger.info("Updating promotion with id tour: " + idTour);
			Tour tour = tourService.findTourById(idTour);
			tour.getPromotion().setPercent(percent);
			tour.getPromotion().setFromDate(fromDate);
			tour.getPromotion().setToDate(toDate);
			tourService.updateTour(tour);
			
		return "managetour";
	}
}
