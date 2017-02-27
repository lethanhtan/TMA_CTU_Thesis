package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.TourValidator;

@Controller
public class CreateTourController {
	@Autowired
	private TourService tourService;

	// Processing for register when required request
	@RequestMapping(value = "/createtour", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.put("tourData", new Tour());
		return "createtour";
	}

	// Processing for form create tour
	@RequestMapping(value = "/createtour", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("tourData") @Valid Tour tour, BindingResult br,
			HttpSession session) {
		TourValidator tourValidator = new TourValidator();
		tourValidator.validate(tourValidator, br);
		if (br.hasErrors()) {
			return "createtour";
		}
		else {
			tourService.saveTour(tour);
			System.out.println("Lan 1");
			session.setAttribute("tour", tour);
			session.setAttribute("tourName", tour.getTourName());
			return "redirect:managetour";
		}
	}
}
