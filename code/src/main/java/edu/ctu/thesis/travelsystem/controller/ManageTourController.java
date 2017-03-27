package edu.ctu.thesis.travelsystem.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Export;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.BookTourService;
import edu.ctu.thesis.travelsystem.service.ExportDataService;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.TourValidator;

@Controller
public class ManageTourController {
	@Autowired
	private TourService tourService;

	@Autowired
	private BookTourService bookTourService;

	@Autowired
	ExportDataService exportDataService;

	private static final Logger logger = Logger.getLogger(ManageTourController.class);

	private static int numOnPage = 5;

	// handle for mangeagetour request from admin
	@RequestMapping(value = "managetour", method = RequestMethod.GET)
	public String managetourController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page,
			@RequestParam(required = false, value = "numOn") Integer numOn) {
		logger.info("Handle when managetour request from admin!");
		String result; // view page mapping
		try{
			if (!numOn.equals(null)) {
				numOnPage = numOn; // numOn 
			}
		} catch (Exception e) {
			logger.info("None select number of tour on page!");
		}
		try {
			if ((int) session.getAttribute("roleId") == 2) {
				model.addAttribute("searchedValue", valueSearch);
				if (valueSearch != null) {
					Integer num = 0;
					if ((tourService.getNumTourByValue(valueSearch) % numOnPage) == 0) {
						num = tourService.getNumTourByValue(valueSearch) / numOnPage;
					} else {
						num = (tourService.getNumTourByValue(valueSearch) / numOnPage) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						logger.info("Search active!");
						model.addAttribute("tour", new Tour());
						model.addAttribute("tourList", tourService.listTourByValue(valueSearch));
						model.addAttribute("numTour", tourService.getNumTourByValue(valueSearch));
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("numOnPage", numOnPage);
						model.addAttribute("page", page);
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", tourService.paginationX(page, numOnPage));
						model.addAttribute("y", tourService.paginationY(tourService.listTourByValue(valueSearch).size(), page, numOnPage));
						result = "managetour";
					} else {
						result = "managetour";
					}
				} else { // search none active ! Update list tour
					Integer num = 0;
					if ((tourService.getNumTour() % numOnPage) == 0) {
						num = tourService.getNumTour() / numOnPage;
					} else {
						num = (tourService.getNumTour() / numOnPage) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						model.addAttribute("tour", new Tour());
						model.addAttribute("tourList", tourService.listTour()); // create
						model.addAttribute("numTour", tourService.getNumTour()); // create
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("numOnPage", numOnPage);
						model.addAttribute("page", page);
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", tourService.paginationX(page, numOnPage));
						model.addAttribute("y", tourService.paginationY(tourService.listTour().size(), page, numOnPage));
						result = "managetour";
					} else {
						result = "managetour";
					}
				}
			} else {
				result = "forbidden";
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
			model.addAttribute("idTour", idTour);
		} else {
			logger.info("Null Object!");
		}
		return "updatetour";
	}

	// handle form action update tour
	@RequestMapping(value = "/updatetour/{idTour}", method = RequestMethod.POST)
	public String updateTour(ModelMap model, @PathVariable("idTour") int idTour,
			@ModelAttribute("tourData") @Valid Tour tour, BindingResult br, HttpSession session) {
		TourValidator tourValidator = new TourValidator();
		tourValidator.validate(tour, br);
		if (br.hasErrors()) {
			return "updatetour";
		} else {
			logger.info("Update! In Update Tour Second!");
			tourService.updateTour(tour);
			return "redirect:/managetour";
		}
	}

	// Forward to Tour detail page
	@RequestMapping(value = "/tourdetail/{idTour}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idTour") int idTour) {
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
		for (BookTour bt : list) {
			numReg += bt.getCusNumOfTicket();
			numCan += bt.getTicketCancel();
		}
		model.addAttribute("numReg", numReg);
		model.addAttribute("numCan", numCan);
		model.addAttribute("tourName", tourService.findTourById(idTour).getName());
		model.addAttribute("departure", tourService.findTourById(idTour).getDepartureDate());
		model.addAttribute("departureDate", sdf.format(tourService.findTourById(idTour).getDepartureDate()));
		model.addAttribute("returnDate", sdf.format(tourService.findTourById(idTour).getReturnDate()));
		model.addAttribute("now", d);
		if (tourService.findTourById(idTour).getDepartureDate().after(d)) {
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

	@RequestMapping(value = "export/{idTour}", method = RequestMethod.GET)
	public ModelAndView exportData(@PathVariable("idTour") int idTour, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Export objExport = new Export();
		model.addObject("exportList", "Tour");
		model.addObject("listBookTours", bookTourService.listBookTourById(idTour));
		objExport.setOwner(session.getAttribute("userName").toString());
		objExport.setFileType("Pdf");
		objExport.setExportType("Registration list");
		exportDataService.saveExport(objExport);
		model.setViewName("pdfView");
		return model;
	}

}