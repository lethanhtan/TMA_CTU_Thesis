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
import edu.ctu.thesis.travelsystem.validator.TourValidator;

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
	public String registrationList(ModelMap model, HttpSession session, @PathVariable("idTour") String idTour) {
		logger.info("Show registration list!");
		model.addAttribute("bookTour", new BookTour());
		model.addAttribute("tour", tourService.findId(idTour));
		model.addAttribute("registrationList", bookTourService.registrationList(idTour));
		return "registrationlist";
	}

	// Forward to Customer detail page
	@RequestMapping(value = "/booktourdetail/{idBT}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idBT") String idBT) {
		model.put("cusData", bookTourService.searchId(idBT));
		logger.info("Show information of customer when book tour");
		return "booktourdetail";
	}

	// Forward to Edit information of customer booked tour
	@RequestMapping(value = "editbooktour/{idBT}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idBT") String idBT) {
		logger.info("Display edit form when admin request!");
		model.put("cusData", bookTourService.searchId(idBT));
		// model.put("tourData", BookTour.getTour().getIdTour());
		//model.addAttribute("tour", tourService.findId(idTour));
		return "editbooktour";
	}

	// Test errors
	@RequestMapping(value = "editbooktour/{idBT}", method = RequestMethod.POST)
	public String editBookTour(@PathVariable("idBT") String idBT, ModelMap model,
			@ModelAttribute("cusData") @Valid BookTour bookTour, BindingResult br, HttpSession session) {
		logger.info("Handle edit information customer form when admin submit!");
		BookTourValidator bookTourValidator = new BookTourValidator();
		bookTourValidator.validate(bookTour, br);
		if (br.hasErrors()) {
			return "editbooktour/{idBT}";
		} else {
			logger.info("Edit success!");
			// model.put("cusData", BookTour.getTour().getIdTour());
			bookTourService.editBookTour(bookTour);
			return "redirect:/registrationlist/{idTour}";
		}
	}

	// Delete customer booked tour
	@RequestMapping(value = "deletebooktour/{idBT}/{idTour}")
	public String deleteBookTour(@PathVariable("idBT") String idBT, @PathVariable("idBT") String idTour) {
		bookTourService.deleteBookTour(idBT, idTour);
		return "redirect:/registrationlist/{idTour}";
	}
}