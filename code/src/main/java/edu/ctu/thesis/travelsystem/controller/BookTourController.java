package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ctu.thesis.travelsystem.dao.TourDaoImpl;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.TourService;

@Controller
public class BookTourController {

	@Autowired
	private TourService tourService;

	public void setTourService(TourService tourService) {
		this.tourService = tourService;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(BookTourController.class);

	// Forward to Tour List page
	@RequestMapping(value = "booktour", method = RequestMethod.GET)
	public String booktourController(ModelMap model, HttpSession session) {
		model.addAttribute("tour", new Tour());
		model.addAttribute("tourList", tourService.listTour());
		model.addAttribute("numTour", tourService.getNumTour());
		return "tourlist";
	}

	// Forward to Book Tour page
	@RequestMapping(value = "/booktour/{idTour}", method = RequestMethod.GET)
	public String registrationList(ModelMap model, @PathVariable("idTour") String idTour) {
		model.put("tourData", tourService.findId(idTour));
		logger.info("Show tour detail!");
		return "booktour";
	}
}