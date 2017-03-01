package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;
<<<<<<< HEAD

=======
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> refs/remotes/lethanhtan/master
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
<<<<<<< HEAD
=======
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
>>>>>>> refs/remotes/lethanhtan/master
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

<<<<<<< HEAD
@Controller
@RequestMapping("createtour")
public class CreateTourController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String createTourController(ModelMap model, HttpSession session) {
		System.out.println(session.getAttribute("roleId"));
		String result;
		try {
			if ((Integer)session.getAttribute("roleId") == 2) {
				result = "createtour";
			} else {
				result = "forbidden";
			}
		}catch (Exception e) {
			//e.printStackTrace();
			result = "forbidden";
		}
		
		return result;
=======
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
>>>>>>> refs/remotes/lethanhtan/master
	}
}
