package edu.ctu.thesis.travelsystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.TourService;

@Controller
public class ViewDetailController {
	
	private static final Logger logger = Logger.getLogger(CreateTourController.class);
	
	@Autowired
	private TourService tourService;

	@RequestMapping(value = "/viewdetail/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable(value = "idTour") int idTour) {
		logger.info("Show tour detail!");
		Tour tour = tourService.findTourById(idTour);
		model.addAttribute("img", tour.getImage());
		model.addAttribute("id", idTour);
		model.addAttribute("name", tour.getName());
		model.addAttribute("detail", tour.getDetail());
		model.addAttribute("tour", tour);
		tourService.addView(tour);
		return "viewdetail";
	}
}
