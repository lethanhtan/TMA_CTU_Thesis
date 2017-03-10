package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.BookTourService;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.BookTourValidator;

@Controller
public class BookTourController {
	
	private static final Logger logger = Logger.getLogger(BookTourController.class);

	@Autowired
	private TourService tourService;

	public void setTourService(TourService tourService) {
		this.tourService = tourService;
	}

	@Autowired
	private BookTourService bookTourService;

	public void setBookTourService(BookTourService bookTourService) {
		this.bookTourService = bookTourService;
	}

	// Display Tour list for user choose
	@RequestMapping(value = "tourlist", method = RequestMethod.GET)
	public String booktourController(ModelMap model, HttpSession session) {
		model.addAttribute("tour", new Tour());
		model.addAttribute("tourList", tourService.listTour());
		model.addAttribute("numTour", tourService.getNumTour());
		return "tourlist";
	}

	// Forward to Book tour page, display book tour form
	@RequestMapping(value = "/booktour/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpSession session, @PathVariable("idTour") String idTour) {
		// Put Customer data into table Book Tour;
		try{
		model.put("cusData", new BookTour());
		model.addAttribute("tour", idTour);
		}catch(Exception e) {
			logger.info("================================");
		}
		return "booktour";
	}

	// Test errors
	@RequestMapping(value = "/booktour/{idTour}", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("cusData") @Valid BookTour bookTour, BindingResult br,
			HttpSession session, @PathVariable("idTour") String idTour) {
		BookTourValidator bookTourValidator = new BookTourValidator();
		bookTourValidator.validate(bookTour, br);
		if (br.hasErrors()) {
			return "booktour";
		} else {
			logger.info("Handle for save booktour!");
			bookTourService.saveBookTour(bookTour, idTour);
			return "redirect:/home";
		}
	}
}
