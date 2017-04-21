package edu.ctu.thesis.travelsystem.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.model.Schedule;
import edu.ctu.thesis.travelsystem.service.ScheduleService;
import edu.ctu.thesis.travelsystem.service.TourService;

@Controller
public class ScheduleController {
	
	private static final Logger logger = Logger.getLogger(ScheduleController.class);

	@Autowired
	ScheduleService scheduleService;
	
	@Autowired
	TourService tourService;
	
	@RequestMapping(value = "/updateschedule/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idTour") int idTour) {
		logger.info("Reparing data for update schedule form!");
		model.addAttribute("idTour", idTour);
		model.put("scheduleData", scheduleService.findSchedule(idTour));
		return "schedules";
	}
	
	@RequestMapping(value = "/updateschedule/{idTour}", method = RequestMethod.POST)
	public String processForm(@ModelAttribute(value = "scheduleData") @Valid Schedule schedule,
			@PathVariable("idTour") int idTour) {
		try {
			logger.info("Updating schedule with id tour: " + idTour);
			scheduleService.updateSchedule(schedule);
		} catch (NullPointerException e) {
			logger.info("Not found schedule for update!");
		}
		
		return "managetour";
	}
}
