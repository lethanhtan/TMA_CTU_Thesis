package edu.ctu.thesis.travelsystem.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.extra.Pagination;
import edu.ctu.thesis.travelsystem.model.BookTour;
//import edu.ctu.thesis.travelsystem.model.Export;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.AuthenticationService;
import edu.ctu.thesis.travelsystem.service.BookTourService;
//import edu.ctu.thesis.travelsystem.service.ExportDataService;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.TourValidator;

@Controller
public class ManageTourController {
	@Autowired
	private TourService tourService;
	@Autowired
	private BookTourService bookTourService;
	// @Autowired
	// private ExportDataService exportDataService;

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	ServletContext servletContext;

	private static final Logger logger = Logger.getLogger(ManageTourController.class);
	private static int numOnPage = 10;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	// handle for mangeagetour request from admin
	@RequestMapping(value = "managetour", method = RequestMethod.GET)
	public String managetourController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page,
			@RequestParam(required = false, value = "numOn") Integer numOn, HttpServletRequest request) {
		try {
			if (authenticationService.authenticationUser(request.getRequestURI(),
					(int) session.getAttribute("roleId"))) {
				logger.info("Authenticaion user permission!");
				logger.info("Current uri: " + request.getRequestURI());
				return "login";
			}
		} catch (NullPointerException e) {
			if (authenticationService.authenticationUser(request.getRequestURI(), 0)) {
				return "login";
			}
		}
		logger.info("Handle when managetour request from admin!");
		String result; // view page mapping
		try {
			if (!numOn.equals(null)) {
				numOnPage = numOn; // numOn
			}
		} catch (Exception e) {
			logger.info("None select number of tour on page!");
		}
		try {
			model.addAttribute("searchedValue", valueSearch);
			if (valueSearch != null) {
				Integer num = 0;
				List<Tour> tourList = tourService.listTourByValue(valueSearch);
				if ((tourList.size() % numOnPage) == 0) {
					num = tourList.size() / numOnPage;
				} else {
					num = (tourList.size() / numOnPage) + 1;
				}
				if (page <= num) {
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					logger.info("Search active!");
					model.addAttribute("tour", new Tour());
					model.addAttribute("tourList", tourList);
					model.addAttribute("numTour", tourList.size());
					model.addAttribute("pageNum", pageNum); // create number
					model.addAttribute("numOnPage", numOnPage);
					model.addAttribute("page", page);
					model.addAttribute("pageE", new ArrayList<Integer>()); // create
					model.addAttribute("x", Pagination.paginationX(page, numOnPage));
					model.addAttribute("y", Pagination.paginationY(tourList.size(), page, numOnPage));
					result = "managetour";
				} else {
					result = "managetour";
				}
			} else { // search none active ! Update list tour
				Integer num = 0;
				List<Tour> tourList = tourService.listTour();
				if ((tourList.size() % numOnPage) == 0) {
					num = tourList.size() / numOnPage;
				} else {
					num = (tourList.size() / numOnPage) + 1;
				}
				if (page <= num) {
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					model.addAttribute("tour", new Tour());
					model.addAttribute("tourList", tourList); // create
					model.addAttribute("numTour", tourList.size()); // create
					model.addAttribute("pageNum", pageNum); // create number
					model.addAttribute("numOnPage", numOnPage);
					model.addAttribute("page", page);
					model.addAttribute("pageE", new ArrayList<Integer>()); // create
					model.addAttribute("x", Pagination.paginationX(page, numOnPage));
					model.addAttribute("y", Pagination.paginationY(tourList.size(), page, numOnPage));
					result = "managetour";
				} else {
					result = "managetour";
				}
			}
		} catch (Exception e) {
			logger.error("Occured ex", e);
			result = "forbidden";
		}
		return result;
	}

	// handle delete request from client
	@RequestMapping(value = "managetour/delete/{idTour}")
	public String delteTour(@PathVariable("idTour") int idTour) {
		tourService.deleteTour(idTour);
		return "redirect:/managetour";
	}

	// handle required reuest from client
	@RequestMapping(value = "updatetour/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idTour") int idTour) throws ParseException {
		logger.info("Handle update form managetour when user request!");
		Tour tour = tourService.findTourById(idTour);
		model.addAttribute("tourData", tour);
		return "updatetour";
	}

	// handle form action update tour
	@RequestMapping(value = "/updatetour/{idTour}", method = RequestMethod.POST)
	public String updateTour(ModelMap model, @PathVariable("idTour") int idTour,
			@ModelAttribute("tourData") @Valid Tour tour, BindingResult br, HttpSession session,
			@RequestParam("file") MultipartFile file, @RequestParam("nameFile") String name) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				logger.info("Processing for saving image data!");
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());
				tour.setImage(name);

			} catch (Exception e) {
				model.addAttribute("failedUpload", "You failed to upload!");
				return "updatetour";
			}
		} else {
			tour.setImage(tourService.findTourById(idTour).getImage());
		}

		TourValidator tourValidator = new TourValidator();
		tourValidator.validate(tour, br);
		if (br.hasErrors()) {
			return "updatetour";
		} else {
			logger.info("Update! In Update Tour Second!");
			tourService.updateTour(tour);
			model.addAttribute("status", "Cập nhật thành công!");
			return "updatetour";
		}
	}

	// Forward to Tour detail page
	@RequestMapping(value = "/tourdetail/{idTour}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idTour") int idTour, @Valid Tour tour) {
		logger.info("Show tour detail!");
		model.put("tourData", tourService.findTourById(idTour));
		return "tourdetail";
	}

	// Delete tour in Detail tour page
	@RequestMapping(value = "tourdetail/delete/{idTour}")
	public String deleteTour(@PathVariable("idTour") int idTour) {
		tourService.deleteTour(idTour);
		return "redirect:/managetour";
	}

	// create chart for a tour
	@RequestMapping(value = "tourreg/{idTour}", method = RequestMethod.GET)
	public String creatDataChart(ModelMap model, @PathVariable("idTour") int idTour) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar ca = Calendar.getInstance();
		Date d = new Date();
		ca.setTime(d);
		int numReg = 0;
		int numCan = 0;
		List<BookTour> list = bookTourService.listBookTourById(idTour);
		Tour tour = tourService.findTourById(idTour);
		for (BookTour bt : list) {
			numReg += bt.getCusNumOfTicket();
			numCan += bt.getTicketCancel();
		}
		model.addAttribute("numReg", numReg);
		model.addAttribute("numCan", numCan);
		model.addAttribute("tourName", tour.getName());
		model.addAttribute("departure", tour.getDepartureDate());
		model.addAttribute("departureDate", sdf.format(tour.getDepartureDate()));
		model.addAttribute("returnDate", sdf.format(tour.getReturnDate()));
		model.addAttribute("now", d);
		if (tour.getDepartureDate().after(d)) {
			model.addAttribute("status", 1);
		} else {
			model.addAttribute("status", 0);
		}
		return "charttourres";
	}

	@RequestMapping(value = "tourreg/{idTour}", method = RequestMethod.POST)
	public String creatChart(ModelMap model, @PathVariable("idTour") int idTour) {
		return "redirect:/charttourres";
	}
}