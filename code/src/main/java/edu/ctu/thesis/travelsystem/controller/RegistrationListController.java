package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.service.BookTourService;
import edu.ctu.thesis.travelsystem.service.TourService;

@Controller
public class RegistrationListController {

	@Autowired
	private BookTourService bookTourService;
	@Autowired
	 private TourService tourService;

	private static final Logger logger = Logger.getLogger(RegistrationListController.class);

	public void setBookTourService(BookTourService bookTourService) {
		this.bookTourService = bookTourService;
	}
	
	public void setTourService(TourService tourService) {
		this.tourService = tourService;
	}

	// Forward to Registration List page
	@RequestMapping(value = "/registrationlist/{idTour}", method = RequestMethod.GET)
	public String registrationList(ModelMap model, HttpSession session, @PathVariable("idTour") String idTour/*ModelMap model, @PathVariable("idTour") String idTour*/) {
		//model.put("tourData", tourService.findId(idTour));
		logger.info("Show registration list!");
		model.addAttribute("bookTour", new BookTour());
		model.addAttribute("tour", tourService.findId(idTour));
		model.addAttribute("registrationList", bookTourService.registrationList(idTour));
		return "registrationlist";
	}
}