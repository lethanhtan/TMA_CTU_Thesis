package edu.ctu.thesis.travelsystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
import org.springframework.web.bind.annotation.RequestParam;

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

	// Forward to Registration List page
	@RequestMapping(value = "/registrationlist/{idTour}", method = RequestMethod.GET)
	public String registrationList(ModelMap model, HttpSession session, @PathVariable("idTour") String idTour,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page) {
		model.addAttribute("searchedValue", valueSearch);
		if (valueSearch != null) {
			Integer num = 0;
			if ((bookTourService.getNumBTBySearch(valueSearch) % 5) == 0) {
				num = bookTourService.getNumBTBySearch(valueSearch) / 5;
			} else {
				num = (bookTourService.getNumBTBySearch(valueSearch) / 5) + 1;
			}
			if (page <= num) {
				List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
				logger.info("Search active!");
				model.addAttribute("bookTour", new BookTour());
				model.addAttribute("tour", tourService.findTourById(idTour));
				model.addAttribute("registrationList", bookTourService.registrationListByValue(valueSearch));
				model.addAttribute("numBookTour", bookTourService.getNumBTBySearch(valueSearch));
				model.addAttribute("pageNum", pageNum); // create number
				model.addAttribute("pageE", new ArrayList<Integer>()); // create
				model.addAttribute("x", tourService.paginationX(page, 5));
				model.addAttribute("y", bookTourService
						.paginationY(bookTourService.registrationListByValue(valueSearch).size(), page, 5));
				return "registrationlist";
			} else {
				return "registrationlist";
			}
		} else { // search none active ! Update list tour
			Integer num = 0;
			if ((bookTourService.getNumBookTour(idTour) % 5) == 0) {
				num = bookTourService.getNumBookTour(idTour) / 5;
			} else {
				num = (bookTourService.getNumBookTour(idTour) / 5) + 1;
			}
			if (page <= num) {
				List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
				model.addAttribute("bookTour", new BookTour());
				model.addAttribute("tour", tourService.findTourById(idTour));
				model.addAttribute("registrationList", bookTourService.registrationList(idTour)); // create
				model.addAttribute("numBookTour", bookTourService.getNumBookTour(idTour)); // create
				model.addAttribute("pageNum", pageNum); // create number
				model.addAttribute("pageE", new ArrayList<Integer>()); // create
				model.addAttribute("x", bookTourService.paginationX(page, 5));
				model.addAttribute("y",
						bookTourService.paginationY(bookTourService.registrationList(idTour).size(), page, 5));
				return "registrationlist";
			} else {
				return "registrationlist";
			}
		}
	}

	// Forward to Customer detail page
	@RequestMapping(value = "/booktourdetail/{idBT}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idBT") String idBT) {
		model.put("cusData", bookTourService.searchById(idBT));
		logger.info("Show information of customer when book tour");
		return "booktourdetail";
	}

	// Forward to Edit information of customer booked tour
	@RequestMapping(value = "editbooktour/{idBT}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idBT") String idBT) {
		logger.info("Display edit form when admin request!");
		model.put("cusData", bookTourService.searchById(idBT));
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
			return "editbooktour";
		} else {
			logger.info("Edit success!");
			bookTourService.editBookTour(bookTour);
			return "redirect:/managetour";
		}
	}

	// Delete customer booked tour
	@RequestMapping(value = "deletebooktour/{idBT}/{idTour}")
	public String deleteBookTour(@PathVariable("idBT") String idBT, @PathVariable("idBT") String idTour) {
		bookTourService.deleteBookTour(idBT, idTour);
		return "redirect:/registrationlist/{idTour}";
	}
}