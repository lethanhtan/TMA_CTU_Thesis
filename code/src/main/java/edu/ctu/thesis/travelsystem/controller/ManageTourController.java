package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.TourValidator;

@Controller
public class ManageTourController {
	
	@Autowired
	private TourService tourService;
	
	public void setTourService(TourService tourService) {
		this.tourService = tourService;
	}
	
	
	@RequestMapping(value = "managetour", method = RequestMethod.GET)
	public String managetourController(ModelMap model, HttpSession session) {
		System.out.println(session.getAttribute("roleId"));
		String result;
		try {
			if ((Integer)session.getAttribute("roleId") == 2) {
				model.addAttribute("tour", new Tour());
				model.addAttribute("tourList", tourService.listTour());
				model.addAttribute("numTour", tourService.getNumTour());
				result = "managetour";
			} else {
				result = "forbidden";
			}
		}catch (Exception e) {
			//e.printStackTrace();
			result = "forbidden";
		}
		
		return result;
	}
	
	@RequestMapping(value = "managetour/delete/{idTour}")
	public String delteTour(@PathVariable("idTour") Integer idTour) {
		tourService.deleteTour(idTour);
		return "redirect:/managetour";
	}
	
	//handle required reuest from client
	@RequestMapping(value = "/updatetour/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idTour") Integer idTour) {
		model.put("tourData", tourService.findByIdTour(idTour));
		System.out.println("Update !In here first!");
		return "updatetour";
	}
	
	//handle form action
	@RequestMapping(value = "updatetour/{idTour}", method = RequestMethod.POST)
	public String updateTour(@PathVariable("idTour") Integer idTour, ModelMap model, @ModelAttribute("tourData") @Valid Tour tour, BindingResult br,
			HttpSession session) {
		TourValidator tourValidator = new TourValidator();
		tourValidator.validate(tourValidator, br);
		if (br.hasErrors()) {
			return "updatetour/{idTour}";
		} else {
			System.out.println("Update! In Update Tour Second!");
			tourService.updateTour(tour);
			return "redirect:/managetour";
		}
	}
	
}