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

@Controller
public class BookTourController {

	@Autowired
	private TourService tourService;

	@Autowired
	private BookTourService bookTourService;

	private static final Logger logger = Logger.getLogger(BookTourController.class);

	// Display Tour list for user choose
	@RequestMapping(value = "tourlist", method = RequestMethod.GET)
	public String booktourController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page) {
		model.addAttribute("searchedValue", valueSearch);
		if (valueSearch != null) {
			Integer num = 0;
			if ((tourService.getNumTourByValue(valueSearch) % 5) == 0) {
				num = tourService.getNumTourByValue(valueSearch) / 5;
			} else {
				num = (tourService.getNumTourByValue(valueSearch) / 5) + 1;
			}
			if (page <= num) {
				List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
				logger.info("Search active!");
				model.addAttribute("tour", new Tour());
				model.addAttribute("tourList", tourService.listTourByValue(valueSearch));
				model.addAttribute("numTour", tourService.getNumTourByValue(valueSearch));
				model.addAttribute("pageNum", pageNum); // create number
				model.addAttribute("pageE", new ArrayList<Integer>()); // create
				model.addAttribute("x", tourService.paginationX(page, 5));
				model.addAttribute("y",
						tourService.paginationY(tourService.listTourByValue(valueSearch).size(), page, 5));
				return "tourlist";
			} else {
				return "forbidden";
			}
		} else { // search none active ! Update list tour
			Integer num = 0;
			if ((tourService.getNumTour() % 5) == 0) {
				num = tourService.getNumTour() / 5;
			} else {
				num = (tourService.getNumTour() / 5) + 1;
			}
			if (page <= num) {
				List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
				model.addAttribute("tour", new Tour());
				model.addAttribute("tourList", tourService.listTour()); // create
				model.addAttribute("numTour", tourService.getNumTour()); // create
				model.addAttribute("pageNum", pageNum); // create number
				model.addAttribute("pageE", new ArrayList<Integer>()); // create
				model.addAttribute("x", tourService.paginationX(page, 5));
				model.addAttribute("y", tourService.paginationY(tourService.listTour().size(), page, 5));
				return "tourlist";
			} else {
				return "forbidden";
			}
		}
	}

	// Forward to Book tour page, display book tour form
	@RequestMapping(value = "/booktour/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpSession session, @PathVariable("idTour") int idTour, @Valid BookTour bookTour) {
		// Put Customer data into table Book Tour;
		try {
			model.put("cusData", new BookTour());
			 model.addAttribute("tour", idTour);
			 Tour tour = tourService.findTourById(idTour);
				bookTour.setTour(tour);
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
		return "booktour";
	}

	// Test errors
	@RequestMapping(value = "/booktour/{idTour}", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("cusData") @Valid BookTour bookTour, BindingResult br,
			HttpSession session, @PathVariable("idTour") int idTour) {
		BookTourValidator bookTourValidator = new BookTourValidator();
		bookTourValidator.validate(bookTour, br);
		if (br.hasErrors()) {
			return "booktour";
		} else {
			Tour tour = tourService.findTourById(idTour);
			bookTour.setTour(tour);
			logger.info("Handle for save booktour!");
			bookTourService.saveBookTour(bookTour, idTour);
			return "redirect:/home";
		}
	}

	// Forward to Tour detail page
	@RequestMapping(value = "/viewtour/{idTour}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idTour") int idTour) {
		logger.info("Show tour detail!");
		model.put("tourData", tourService.findTourById(idTour));
		return "viewtour";
	}
}
