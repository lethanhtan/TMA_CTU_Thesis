package edu.ctu.thesis.travelsystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.ScheduleService;
import edu.ctu.thesis.travelsystem.service.TourService;

@Controller
public class ScheduleController {
	
	private static final Logger logger = Logger.getLogger(ScheduleController.class);

	@Autowired
	ScheduleService scheduleService;
	
	@Autowired
	TourService tourService;
	
	@RequestMapping(value = "/update_schedule/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idTour") int idTour) {
		logger.info("Reparing data for update schedule form!");
		model.addAttribute("idTour", idTour);
		model.put("scheduleData", scheduleService.findSchedule(idTour));
		model.put("tour", tourService.findTourById(idTour));
		return "schedules";
	}
	
	@RequestMapping(value = "/update_schedule/{idTour}", method = RequestMethod.POST)
	public String processForm(@RequestParam(value="detailSchedule") String detailSchedule,
			@RequestParam(name="sumary") String sumary,
			@PathVariable("idTour") int idTour) {
			logger.info("Updating schedule with id tour: " + idTour);
			Tour tour = tourService.findTourById(idTour);
			tour.getSchedule().setDetailSchedule(detailSchedule);
			tour.getSchedule().setSumary(sumary);
			tourService.updateTour(tour);
		
		return "managetour";
	}
}
