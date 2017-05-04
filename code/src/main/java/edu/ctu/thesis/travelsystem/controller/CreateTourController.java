package edu.ctu.thesis.travelsystem.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.model.Promotion;
import edu.ctu.thesis.travelsystem.model.Schedule;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.AuthenticationService;
import edu.ctu.thesis.travelsystem.service.PromotionService;
import edu.ctu.thesis.travelsystem.service.ScheduleService;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.TourValidator;

@Controller
public class CreateTourController {
	@Autowired
	private TourService tourService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private PromotionService promotionService;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	ServletContext servletContext;

	private static final Logger logger = Logger.getLogger(CreateTourController.class);
	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
             SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
             dateFormat.setLenient(false);
             webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
         }

	// Processing for register when required request
	@RequestMapping(value = "/createtour", method = RequestMethod.GET)
	// Decentralization user and admin
	public String createtourController(ModelMap model, HttpSession session, HttpServletRequest request) {
		try {
			if (authenticationService.authenticationUser(request.getRequestURI(), (int) session.getAttribute("roleId"))) {
				logger.info("Authenticaion user permission!");
				logger.info("Current uri: " + request.getRequestURI());
				return "login";
			}
		} catch (NullPointerException e) {
			if (authenticationService.authenticationUser(request.getRequestURI(), 0)) {
				return "login";
			}
		}
		
		String result;
		try {
				logger.info("Create tour! In here first!");
				model.put("tourData", new Tour());
				model.put("scheduleData", new Schedule());
				model.put("saleData", new Promotion());
				result = "createtour";
		} catch (Exception e) {
			result = "login";
		}
		return result;
	}

	// Processing for form create tour
	@RequestMapping(value = "/createtour", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("tourData") @Valid Tour tour, BindingResult br,
			@ModelAttribute("scheduleData") @Valid Schedule schedule, @ModelAttribute("saleData") @Valid Promotion sale, HttpSession session,
			@RequestParam("file") MultipartFile file, @RequestParam("nameFile") String name) {
		if (file != null && !file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				// BufferedOutputStream stream = new BufferedOutputStream(new
				// FileOutputStream(serverFile));
				try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
					stream.write(bytes);
					logger.info("Server File Location=" + serverFile.getAbsolutePath());
					tour.setImage(name);
				} catch (Exception e) {
					logger.error("exception when writting to file", e);
					throw e;
				}

			} catch (Exception e) {
				model.addAttribute("failedUpload", "Tải lên tập tin hình ảnh thất bại!");
				return "createtour";
			}
		} else {
			model.addAttribute("failedEmpty", "Bạn phải chọn tập tin hình ảnh cho tour!");
			return "createtour";
		}

		TourValidator tourValidator = new TourValidator();
		tourValidator.validate(tour, br);
		if (br.hasErrors()) {
			return "createtour";
		} else {
			logger.info("Create tour! In here second!");
			tourService.saveTour(tour);
			schedule.setTour(tour);
			sale.setTour(tour);
			scheduleService.saveSchedule(schedule);
			promotionService.savePromotion(sale);
			
			return "redirect:/managetour";
		}
	}
}
