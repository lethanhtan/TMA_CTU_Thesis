package edu.ctu.thesis.travelsystem.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.model.Promotion;
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
		return "promotion";
	}
	
	@RequestMapping(value = "/update_promotion/{idTour}", method = RequestMethod.POST)
	public String processForm(@ModelAttribute(value = "promotionData") @Valid Promotion promotion,
			@PathVariable("idTour") int idTour) {
		try {
			logger.info("Updating promotion with id tour: " + idTour);
			logger.info("Id promotion: " + promotion.getTour().getIdTour());
			promotionService.updatePromotion(promotion);
		} catch (NullPointerException e) {
			logger.info("Not found promotion for update!");
		}
		
		return "managetour";
	}
}
