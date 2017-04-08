package edu.ctu.thesis.travelsystem.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.TourValidator;

@Controller
public class CreateTourController {
	@Autowired
	private TourService tourService;

	private static final Logger logger = Logger.getLogger(CreateTourController.class);
	
	// Processing for register when required request
	@RequestMapping(value = "/createtour", method = RequestMethod.GET)
	//Decentralization user and admin
		public String createtourController(ModelMap model, HttpSession session) {
			String result;
			try {
				if ((int) session.getAttribute("roleId") == 2) {
					logger.info("Create tour! In here first!");
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
			HttpSession session, @RequestParam("file") MultipartFile file, @RequestParam("nameFile") String name) {
		if (tour != null) {
			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String departureDate = sdf.format(tour.getDepartureDate());
			String returnDate = sdf.format(tour.getReturnDate());
			String dateAllowReg = sdf.format(tour.getDateAllowReg());
			String dateAllowCancel = sdf.format(tour.getDateAllowCancel());
			model.addAttribute("date1", departureDate);
			model.addAttribute("date2", returnDate);
			model.addAttribute("date3", dateAllowReg);
			model.addAttribute("date4", dateAllowCancel);
			model.addAttribute("tourData", tour);
		} else {
			logger.info("Null Object!");
		}
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
//				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				try(BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
					stream.write(bytes);
					logger.info("Server File Location=" + serverFile.getAbsolutePath());
					tour.setImage(name);
				} catch (Exception e){
					logger.error("exception when writting to file", e);
					throw e;
				} 

			} catch (Exception e) {
				model.addAttribute("failedUpload", "Táº£i lÃªn táº­p tin hÃ¬nh áº£nh tháº¥t báº¡i!");
				return "createtour";
			}
		} else {
			model.addAttribute("failedEmpty", "Báº¡n pháº£i chá»�n táº­p tin hÃ¬nh áº£nh cho tour!");
			return "createtour";
		}
		
		TourValidator tourValidator = new TourValidator();
		tourValidator.validate(tour, br);
		if (br.hasErrors()) {
			return "createtour";
		} else {
			logger.info("Create tour! In here second!");
			tourService.saveTour(tour);
			return "redirect:/managetour";
		}
	}
}

