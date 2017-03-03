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
import org.springframework.web.bind.annotation.RequestParam;

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
	public String managetourController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch) {
		System.out.println(session.getAttribute("roleId"));
		String result;
		try {
			if ((Integer) session.getAttribute("roleId") == 2) {
				model.addAttribute("searchedValue", valueSearch);
				if (valueSearch != null) {
					System.out.println("Search active!");
					model.addAttribute("tour", new Tour());
					model.addAttribute("tourList", tourService.listTourById(valueSearch));
					model.addAttribute("numTour", tourService.getNumTourByValue(valueSearch));
					result = "managetour";
				} else {
					model.addAttribute("tour", new Tour());
					model.addAttribute("tourList", tourService.listTour());
					model.addAttribute("numTour", tourService.getNumTour());
					result = "managetour";
				}
			} else {
				System.out.println("What?");
				result = "forbidden";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Why?");
			result = "forbidden";
		}

		return result;
	}

	// handle delete request from client
	@RequestMapping(value = "managetour/delete/{idTour}")
	public String delteTour(@PathVariable("idTour") String idTour) {
		tourService.deleteTour(idTour);
		return "redirect:/managetour";
	}

	// handle required reuest from client
	@RequestMapping(value = "/updatetour/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idTour") String idTour) {
		System.out.println("Handle update form managetour when user request!");
		model.put("tourData", tourService.findByIdTour(idTour)); // put tourData
																	// as a tour
																	// with id
																	// specifies
		return "updatetour";
	}

	// handle form action update tour
	@RequestMapping(value = "updatetour/{idTour}", method = RequestMethod.POST)
	public String updateTour(@PathVariable("idTour") String idTour, ModelMap model,
			@ModelAttribute("tourData") @Valid Tour tour, BindingResult br, HttpSession session) {
		System.out.println("Handle update form managetour when user submit value");
		TourValidator tourValidator = new TourValidator();
		tourValidator.validate(tour, br);
		if (br.hasErrors()) {
			return "updatetour/{idTour}";
		} else {
			System.out.println("Update! In Update Tour Second!");
			tourService.updateTour(tour);
			return "redirect:/managetour";
		}
	}

	// Forward to Tour detail page
	@RequestMapping(value = "/detail/{idTour}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idTour") String idTour) {
		model.put("tourData", tourService.findByIdTour(idTour));
		System.out.println("Show tour detail!");
		return "tourdetail";
	}

	// Delete tour in Detail tour page
	@RequestMapping(value = "detail/delete/{idTour}")
	public String deleteTour(@PathVariable("idTour") String idTour) {
		tourService.deleteTour(idTour);
		return "redirect:/managetour";
	}

	// Forward to Registration List page
	@RequestMapping(value = "/registrationlist/{idTour}", method = RequestMethod.GET)
	public String registrationList(ModelMap model, @PathVariable("idTour") String idTour) {
		model.put("tourData", tourService.findByIdTour(idTour));
		System.out.println("Show tour detail!");
		return "registrationlist";
	}
}