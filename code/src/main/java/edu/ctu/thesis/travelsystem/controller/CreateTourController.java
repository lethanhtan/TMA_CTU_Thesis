package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(CreateTourController.class);

	// Processing for register when required request
	@RequestMapping(value = "/createtour", method = RequestMethod.GET)
	//Decentralization user and admin
		public String createtourController(ModelMap model, HttpSession session) {
			logger.info("Create tour request is called!");
			String result;
			try {
				if ((Integer) session.getAttribute("roleId") == 2) {
					logger.info("Register! In here first!");
					model.put("tourData", new Tour());
					result = "createtour";
				} else {
					result = "forbidden";
				}
			} catch (Exception e) {
				result = "forbidden";
			}
			return result;
		}
	
	// Processing for form create tour
	@RequestMapping(value = "/createtour", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("tourData") @Valid Tour tour, BindingResult br,
			HttpSession session) {
		TourValidator tourValidator = new TourValidator();
		tourValidator.validate(tour, br);
		if (br.hasErrors()) {
			return "createtour";
		} else {
			logger.info("Create tour when submit form!");
			tourService.saveTour(tour);
			return "redirect:managetour";
		}
	}
}

