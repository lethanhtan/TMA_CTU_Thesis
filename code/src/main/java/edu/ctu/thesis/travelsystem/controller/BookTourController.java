package edu.ctu.thesis.travelsystem.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import edu.ctu.thesis.travelsystem.extra.CheckConnections;
import edu.ctu.thesis.travelsystem.dto.BookTourInfoVO;
import edu.ctu.thesis.travelsystem.dto.SubBookTourVO;
import edu.ctu.thesis.travelsystem.extra.Pagination;
import edu.ctu.thesis.travelsystem.extra.VerifyRecaptcha;
import edu.ctu.thesis.travelsystem.mail.EMailSender;
import edu.ctu.thesis.travelsystem.mail.MailTemplate;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.BookTourService;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.BookTourValidator;

@Controller
public class BookTourController {
	@Autowired
	private TourService tourService;
	@Autowired
	private BookTourService bookTourService;
	@Autowired
	private EMailSender emailSenderService;

	private static int numOnPage = 5;
	private static int numOfTicket = 1;

	private static final Logger logger = Logger.getLogger(BookTourController.class);

	// Display Tour list for user choose
	@RequestMapping(value = "tourlist", method = RequestMethod.GET)
	public String booktourController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page,
			@RequestParam(required = false, value = "numOn") Integer numOn) {
		model.addAttribute("searchedValue", valueSearch);
		try {
			if (!numOn.equals(null)) {
				numOnPage = numOn; // numOn
			}
		} catch (Exception e) {
			logger.info("None select number of tour on page!");
		}
		if (valueSearch != null) {
			Integer num = 0;
			List<Tour> tourList = tourService.tourListByValue(valueSearch);
			if (tourList.size() == 0) {
				num = tourList.size() / numOnPage;
			} else {
				num = (tourList.size() / numOnPage) + 1;
			}
			if (page <= num) {
				List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
				logger.info("Search active!");
				model.addAttribute("tour", new Tour());
				model.addAttribute("showTourList", tourList);
				model.addAttribute("numTour", tourList.size());
				model.addAttribute("pageNum", pageNum); // Create number of page
				model.addAttribute("numOnPage", numOnPage);
				model.addAttribute("page", page);
				model.addAttribute("pageE", new ArrayList<Integer>());
				model.addAttribute("x", Pagination.paginationX(page, numOnPage));
				model.addAttribute("y", Pagination.paginationY(tourList.size(), page, numOnPage));
				return "tourlist";
			} else {
				return "tourlist";
			}
		} else { // Search none active ! Update list tour
			logger.info("Handel book tour list when search none active!");
			Integer num = 0;
			List<Tour> allTourList = tourService.showTourList();
			if ((allTourList.size() % numOnPage) == 0) {
				num = allTourList.size() / numOnPage;
			} else {
				num = (allTourList.size() / numOnPage) + 1;
			}
			if (page <= num) {
				List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
				model.addAttribute("tour", new Tour());
				model.addAttribute("showTourList", allTourList);
				// Display tour list
				model.addAttribute("numTour", allTourList.size());
				// Get number of tour list
				model.addAttribute("pageNum", pageNum); // Create number of page
				model.addAttribute("numOnPage", numOnPage);
				model.addAttribute("page", page);
				model.addAttribute("pageE", new ArrayList<Integer>());
				model.addAttribute("x", Pagination.paginationX(page, numOnPage));
				model.addAttribute("y", Pagination.paginationY(allTourList.size(), page, numOnPage));
				return "tourlist";
			} else {
				return "tourlist";
			}
		}
	}

	// Forward to Book tour page, display book tour form
	@RequestMapping(value = "/booktour/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpSession session, @PathVariable("idTour") int idTour,
			@Valid BookTour bookTour, @Valid Tour tour,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = false, value = "numTicket") Integer numTicket) {
		// Put Customer data into table Book Tour;
		try {
			// Set default value for number of ticket
			if (!numTicket.equals(null)) {
				numOfTicket = numTicket; // numOn
			}
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
		try {
			model.addAttribute("searchedValue", valueSearch);
			model.addAttribute("numOfTicket", numOfTicket);
			tour = tourService.findTourById(idTour);
			if (valueSearch != null) {
				logger.info("Search active!");
				model.addAttribute("bookTour", new BookTour());
				model.addAttribute("tour", tour);
				model.addAttribute("registrationList", bookTourService.registrationInfoByValue(valueSearch, idTour));
				return "booktour";
			} else {
				SubBookTourVO cusData = new SubBookTourVO();
				List<BookTourInfoVO> infos = new ArrayList<>(numOfTicket);
				for (int i = 0; i < numOfTicket; i++) {
					infos.add(new BookTourInfoVO());
				}
				cusData.setInfo(infos);
				model.addAttribute("cusData", cusData);
				model.addAttribute("tour", tour);
				return "booktour";
			}
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
		return "booktour";
	}

	// Test errors
	@RequestMapping(value = "/booktour/{idTour}", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("cusNextData") SubBookTourVO subBookTourVO,
			@Valid BookTour bookTour, BindingResult br, HttpSession session, @PathVariable("idTour") int idTour,
			@Valid Tour tour, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookTourValidator bookTourValidator = new BookTourValidator();
		bookTourValidator.validate(bookTour, br);
		boolean verify = false;
		if (CheckConnections.checkConnect("https://www.google.com")) {
			String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
			logger.info(gRecaptchaResponse);
			verify = VerifyRecaptcha.verify(gRecaptchaResponse);
			logger.info("Captcha Verify: " + verify);
		} else {
			logger.info("Internet connect problem!");
			model.addAttribute("failedConnect", "Không có kết nối internet!");
			return "booktour";
		}
		tour = tourService.findTourById(idTour);
		int maxValue = bookTourService.getMaxValue();
		if (br.hasErrors()) {
			logger.info("Tour Info: " + tour);
			model.addAttribute("tour", tour);
			return "booktour";
		}
		if (verify == false) {
			String errorString = "Báº¡n pháº£i chá»�n reCaptcha!";
			model.addAttribute("errorString", errorString);
			model.addAttribute("tour", tour);
			return "booktour";
		} else {
			logger.info("Handle for save booktour!");
			if (CheckConnections.checkConnect("https://www.google.com")) {
				List<BookTourInfoVO> bookTourInfo = subBookTourVO.getInfo();
				List<BookTour> bookTours = new ArrayList<>(bookTourInfo.size());
				for (BookTourInfoVO info : bookTourInfo) {
					BookTour bookedTour = new BookTour();
					bookedTour.setTour(tour);
					bookedTour.setCusName(info.getCusName());
					bookedTour.setCusSex(info.getCusSex());
					bookedTour.setCusYearOfBirth(info.getCusYearOfBirth());
					bookedTour.setCusPhone(info.getCusPhone());
					bookedTour.setCusIdCard(info.getCusIdCard());
					bookedTour.setCusEmail(info.getCusEmail());
					bookedTour.setCusAddress(info.getCusAddress());
					bookedTour.setDateBook(Calendar.getInstance().getTime());
					bookedTour.setRelationship(maxValue);
					if (session.getAttribute("idUser") != null) {
						bookedTour.setIdUser((int) session.getAttribute("idUser"));
					} else {
						bookedTour.setIdUser(0);
					}
					bookTours.add(bookedTour);
				}
				bookTourService.saveBookTours(bookTours, idTour);
				logger.info("Handle for save booktour!");
				model.put("idBT", bookTour.getIdBT());
				emailSenderService.SendEmail(bookTour.getCusEmail(), "pc.nt95@gmail.com", MailTemplate.bookSuccessTitle,
						MailTemplate.bookSuccessBody);
				model.put("idTour", idTour);
				model.put("relationship", maxValue);
				return "redirect:/booksuccess/{relationship}/{idTour}";
			} else {
				logger.info("Internet connect problem!");
				model.addAttribute("failedConnect", "Không có kết nối internet!");
				return "booktour";
			}
		}
	}

	// Forward to Tour detail page
	@RequestMapping(value = "/viewtour/{idTour}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idTour") int idTour) {
		logger.info("Show tour detail!");
		model.put("tourData", tourService.findTourById(idTour));
		return "viewtour";
	}

	// Forward to Customer detail page
	@RequestMapping(value = "booktourdetail/{idBT}/{idTour}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idBT") int idBT, @PathVariable("idTour") int idTour,
			@Valid Tour tour, @Valid BookTour bookTour) {
		bookTour = bookTourService.searchById(idBT);
		logger.info("Show information of customer when book tour");
		model.put("cusData", bookTour);
		model.put("price", bookTour.getTour().getPrice());
		return "booktourdetail";
	}

	// Forward to Edit information of customer booked tour
	@RequestMapping(value = "editbooktour/{idBT}/{idTour}", method = RequestMethod.GET)
	public String showForm(ModelMap model, @PathVariable("idBT") int idBT, @PathVariable("idTour") int idTour) {
		logger.info("Display edit form when customer request!");
		model.put("cusData", bookTourService.searchById(idBT));
		return "editbooktour";
	}

	// Test errors
	@RequestMapping(value = "editbooktour/{idBT}/{idTour}", method = RequestMethod.POST)
	public String editBookTour(@PathVariable("idBT") Integer idBT, @PathVariable("idTour") int idTour, ModelMap model,
			HttpSession session, @ModelAttribute("cusData") @Valid BookTour bookTour, BindingResult br,
			@Valid Tour tour) {
		logger.info("Handle edit information customer form when admin submit!");
		BookTourValidator bookTourValidator = new BookTourValidator();
		bookTourValidator.validate(bookTour, br);
		tour = tourService.findTourById(idTour);
		if (br.hasErrors()) {
			return "editbooktour	";
		} else {
			bookTour.setTour(tour);
			logger.info("Edit success!");
			bookTour.setDateBook(Calendar.getInstance().getTime());
			if (session.getAttribute("idUser") != null) {
				bookTour.setIdUser((int) session.getAttribute("idUser"));
				bookTourService.editBookTour(bookTour);
				return "redirect:/managemyreg/{idUser}";
			} else {
				bookTour.setIdUser(0);
				bookTourService.editBookTour(bookTour);
				return "redirect:/tourlist";
			}
		}
	}

	// Customer cancel registration tour
	@RequestMapping(value = "cancelbooktour/{idBT}")
	public String cancelBookTour(@PathVariable("idBT") Integer idBT) {
		bookTourService.cancelBookTour(idBT);
		BookTour bookedTour = bookTourService.searchById(idBT);
		emailSenderService.SendEmail(bookedTour.getCusEmail(), MailTemplate.hostMail, MailTemplate.confirmCancelTitle,
				MailTemplate.confirmCancelBody + bookedTour.getConfirmCode());
		return "redirect:/cancelbook/{idBT}";
	}

	// Forward to Book tour detail page
	@RequestMapping(value = "booksuccess/{relationship}/{idTour}", method = RequestMethod.GET)
	public String showBTDetail(ModelMap model, @PathVariable("idTour") int idTour,
			@PathVariable("relationship") int relationship, @Valid Tour tour, @Valid BookTour bookTour) {
		logger.info("Show book tour detail!");
		Tour tourFromDB = tourService.findTourById(idTour);
		List<BookTour> bookTourList = bookTourService.bookTourListByRelationship(relationship);
		int total = bookTourList.size();
		model.put("tourData", tourFromDB);
		model.put("bookTourList", bookTourList);
		model.put("total", total);
		String pr = tourFromDB.getPrice().replaceAll(",", "");
		DecimalFormat formatter = new DecimalFormat("#,###");
		model.put("price", formatter.format(Integer.parseInt(pr) * total));
		return "booksuccess";
	}
}
