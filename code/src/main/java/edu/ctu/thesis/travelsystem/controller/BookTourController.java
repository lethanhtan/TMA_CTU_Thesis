package edu.ctu.thesis.travelsystem.controller;

import java.util.ArrayList;
import java.util.Calendar;
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
import edu.ctu.thesis.travelsystem.model.RegistrationInfo;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.BookTourService;
import edu.ctu.thesis.travelsystem.service.RegInfoService;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.BookTourValidator;

@Controller
public class BookTourController {
	@Autowired
	private TourService tourService;
	@Autowired
	private BookTourService bookTourService;
	@Autowired
	private RegInfoService regInfoService;
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
				model.addAttribute("showTourList", tourService.tourListByValue(valueSearch));
				model.addAttribute("numTour", tourService.getNumTourByValue(valueSearch));
				model.addAttribute("pageNum", pageNum); // Create number of page
				model.addAttribute("pageE", new ArrayList<Integer>());
				model.addAttribute("x", tourService.paginationX(page, 5));
				model.addAttribute("y",
						tourService.paginationY(tourService.tourListByValue(valueSearch).size(), page, 5));
				return "tourlist";
			} else {
				return "forbidden";
			}
		} else { // Search none active ! Update list tour
			Integer num = 0;
			if ((tourService.getNumTour() % 5) == 0) {
				num = tourService.getNumTour() / 5;
			} else {
				num = (tourService.getNumTour() / 5) + 1;
			}
			if (page <= num) {
				List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
				model.addAttribute("tour", new Tour());
				model.addAttribute("showTourList", tourService.showTourList());
				System.out.println(">>>>>>>>>>>>>>>" +  tourService.showTourList().size());
				// Display tour list
				model.addAttribute("numTour", tourService.getNumTourList());
				// Get number of tour list
				model.addAttribute("pageNum", pageNum); // Create number of page
				model.addAttribute("pageE", new ArrayList<Integer>());
				model.addAttribute("x", tourService.paginationX(page, 5));
				model.addAttribute("y", tourService.paginationY(tourService.showTourList().size(), page, 5));
				return "tourlist";
			} else {
				return "forbidden";
			}
		}
	}

	// Forward to Book tour page, display book tour form
	@RequestMapping(value = "/booktour/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpSession session, @PathVariable("idTour") int idTour,
			@Valid BookTour bookTour, @Valid RegistrationInfo regInfo, @Valid Tour tour,
			@RequestParam(required = false, value = "valueSearch") String valueSearch) {
		// Put Customer data into table Book Tour;
		try {
			model.addAttribute("searchedValue", valueSearch);
			if (valueSearch != null) {
				logger.info("Search active!");
				model.addAttribute("bookTour", new BookTour());
				model.addAttribute("tour", tourService.findTourById(idTour));
				model.addAttribute("registrationList", bookTourService.registrationInfoByValue(valueSearch, idTour));
				return "booktour";
			} else {
				model.put("cusData", new BookTour());
				regInfo = regInfoService.searchRegInfoById(idTour);
				logger.info("Reg Info: " + regInfo);
				if (regInfo != null) {
					model.addAttribute("regInfo", regInfo);
				}
				tour = tourService.findTourById(idTour);
				model.addAttribute("tour", tour);
				bookTour.setTour(tour);
				return "booktour";
			}
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
		return "booktour";
	}

	// Test errors
	@RequestMapping(value = "/booktour/{idTour}", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("cusData") @Valid BookTour bookTour, BindingResult br,
			HttpSession session, @PathVariable("idTour") int idTour, @Valid RegistrationInfo regInfo) {
		BookTourValidator bookTourValidator = new BookTourValidator();
		bookTourValidator.validate(bookTour, br);
		if (br.hasErrors()) {
			regInfo = regInfoService.searchRegInfoById(idTour);
			logger.info("Reg Info: " + regInfo);
			if (regInfo != null) {
				model.addAttribute("regInfo", regInfo);
			}
			return "booktour";
		} else {
			Tour tour = tourService.findTourById(idTour);
			bookTour.setTour(tour);
			bookTour.setDateBook(Calendar.getInstance().getTime());
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

	// Forward to Customer detail page
	@RequestMapping(value = "/booktourdetail/{idBT}/{idTour}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idBT") int idBT, @PathVariable("idTour") int idTour,
			@Valid RegistrationInfo regInfo) {
		logger.info("Show information of customer when book tour");
		model.put("cusData", bookTourService.searchById(idBT));
		regInfo = regInfoService.searchRegInfoById(idTour);
		logger.info("Reg Info: " + regInfo);
		if (regInfo != null) {
			model.addAttribute("regInfo", regInfo);
		}
		return "booktourdetail";
	}

	// Forward to Edit information of customer booked tour
	@RequestMapping(value = "editbooktour/{idBT}/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idBT") int idBT, @PathVariable("idTour") int idTour,
			@Valid RegistrationInfo regInfo) {
		logger.info("Display edit form when admin request!");
		model.put("cusData", bookTourService.searchById(idBT));
		regInfo = regInfoService.searchRegInfoById(idTour);
		logger.info("Reg Info: " + regInfo);
		if (regInfo != null) {
			model.addAttribute("regInfo", regInfo);
		}
		return "editbooktour";
	}

	// Test errors
	@RequestMapping(value = "editbooktour/{idBT}/{idTour}", method = RequestMethod.POST)
	public String editBookTour(@PathVariable("idBT") Integer idBT, @PathVariable("idTour") int idTour, ModelMap model,
			HttpSession session, @ModelAttribute("cusData") @Valid BookTour bookTour, BindingResult br,
			@Valid RegistrationInfo regInfo) {
		logger.info("Handle edit information customer form when admin submit!");
		BookTourValidator bookTourValidator = new BookTourValidator();
		bookTourValidator.validate(bookTour, br);
		if (br.hasErrors()) {
			regInfo = regInfoService.searchRegInfoById(idTour);
			logger.info("Reg Info: " + regInfo);
			if (regInfo != null) {
				model.addAttribute("regInfo", regInfo);
			}
			return "editbooktour";
		} else {
			Tour tour = tourService.findTourById(idTour);
			bookTour.setTour(tour);
			logger.info("Edit success!");
			bookTour.setDateBook(Calendar.getInstance().getTime());
			bookTourService.editBookTour(bookTour);
			if ((int) session.getAttribute("roleId") == 2) {
				return "redirect:/registrationlist/{idTour}";
			} else {
				return "redirect:/tourlist";
			}
		}
	}

	// Customer cancel registration tour
	@RequestMapping(value = "cancelbooktour/{idBT}/{idTour}")
	public String cancelBookTour(@PathVariable("idBT") Integer idBT, @PathVariable("idBT") int idTour) {
		bookTourService.cancelBookTour(idBT, idTour);
		return "redirect:/tourlist";
	}
}
