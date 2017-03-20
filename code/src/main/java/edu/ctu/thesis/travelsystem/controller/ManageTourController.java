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

import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.TourValidator;

@Controller
public class ManageTourController {
	@Autowired
	private TourService tourService;

	private static final Logger logger = Logger.getLogger(ManageTourController.class);

	// handle for mangeagetour request from admin
	@RequestMapping(value = "managetour", method = RequestMethod.GET)
	public String managetourController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page) {
		logger.info("Handle when managetour request from admin!");
		String result;
		try {
			if ((int) session.getAttribute("roleId") == 2) {
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
						model.addAttribute("y", tourService.paginationY(tourService.listTourByValue(valueSearch).size(), page, 5));
						result = "managetour";
					} else {
						result = "managetour";
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
						result = "managetour";
					} else {
						result = "managetour";
					}
				}
			} else {
				result = "forbidden";
			}
		} catch (Exception e) {
			logger.error("Occured ex", e);
			result = "forbidden";
		}
		return result;
	}

	// handle delete request from client
	@RequestMapping(value = "managetour/delete/{idTour}")
	public String delteTour(@PathVariable("idTour") int idTour) {
		tourService.deleteTour(idTour);
		return "redirect:/managetour";
	}

	// handle required reuest from client
	@RequestMapping(value = "updatetour/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idTour") int idTour) {
		logger.info("Handle update form managetour when user request!");
		Tour tour = tourService.findTourById(idTour);
		if (tour != null) {
			model.addAttribute("tourData", tour);
			model.addAttribute("idTour", idTour);
		} else {
			logger.info("Null Object!");
		}
		return "updatetour";
	}

	// handle form action update tour
	@RequestMapping(value = "/updatetour/{idTour}")
	public String updateTour(ModelMap model, @PathVariable("idTour") int idTour,
			@ModelAttribute("tourData") @Valid Tour tour, BindingResult br, HttpSession session) {
		TourValidator tourValidator = new TourValidator();
		tourValidator.validate(tour, br);
		if (br.hasErrors()) {
			return "updatetour";
		} else {
			logger.info("Update! In Update Tour Second!");
			tourService.updateTour(tour);
			return "redirect:/managetour";
		}
	}

	// Forward to Tour detail page
	@RequestMapping(value = "/tourdetail/{idTour}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idTour") int idTour) {
		logger.info("Show tour detail!");
		model.put("tourData", tourService.findTourById(idTour));
		return "tourdetail";
	}

	// Delete tour in Detail tour page
	@RequestMapping(value = "tourdetail/delete/{idTour}")
	public String deleteTour(@PathVariable("idTour") int idTour) {
		tourService.deleteTour(idTour);
		return "redirect:/managetour";
	}
}