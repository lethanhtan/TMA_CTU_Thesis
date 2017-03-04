package edu.ctu.thesis.travelsystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
	
	//handle for mangeagetour request from admin
	@RequestMapping(value = "managetour", method = RequestMethod.GET)
	public String managetourController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch) {
		System.out.println(session.getAttribute("roleId"));
		String result;
		try {
			if ((Integer) session.getAttribute("roleId") == 2) {
				model.addAttribute("searchedValue", valueSearch);
				if (valueSearch != null) { //search active! Update list tour
					model.addAttribute("tour", new Tour());
					model.addAttribute("tourList", tourService.listTourById(valueSearch));
					model.addAttribute("numTour", tourService.getNumTourByValue(valueSearch));
					result = "managetour";
				} else { //search none active ! Update list tour
					Integer num = 0;
					/*
					if ((tourService.getNumTour() % 5) == 0) {
						num = tourService.getNumTour() / 5;
					}
					else {
						num = (tourService.getNumTour() / 5) + 1;
					}
					*/
					Integer n = 41;
					if ((n % 5) == 0) {
						num =n / 5;
					}
					else {
						num = (n / 5) + 1;
					}
					
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					model.addAttribute("tour", new Tour());
					model.addAttribute("tourList", tourService.listTour()); //create list tour
					model.addAttribute("numTour", tourService.getNumTour()); //create number of tour
					model.addAttribute("pageNum", pageNum); //create number of page display
					model.addAttribute("pageE", new ArrayList<Integer>()); //create var for loop
					result = "managetour";
				}
			} else {
				result = "forbidden";
			}
		} catch (Exception e) {
			e.printStackTrace();
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

}