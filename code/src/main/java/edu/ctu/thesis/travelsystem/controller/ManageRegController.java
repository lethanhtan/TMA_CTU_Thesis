package edu.ctu.thesis.travelsystem.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import edu.ctu.thesis.travelsystem.extra.Pagination;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.BookTourService;
import edu.ctu.thesis.travelsystem.service.FilterService;
import edu.ctu.thesis.travelsystem.service.RegInfoService;
import edu.ctu.thesis.travelsystem.service.TourService;
import edu.ctu.thesis.travelsystem.validator.BookTourValidator;

@Controller
public class ManageRegController {
	@Autowired
	private BookTourService bookTourService;
	@Autowired
	private TourService tourService;
	@Autowired
	private RegInfoService regInfoService;
	@Autowired
	private FilterService filterService;

	private static int numOnPage = 10;
	private static int numOnPage2 = 10;

	private static final Logger logger = Logger.getLogger(ManageRegController.class);

	// Display tour list
	@RequestMapping(value = "manageregister", method = RequestMethod.GET)
	public String manageRegController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page,
			@RequestParam(required = false, value = "numOn") Integer numOn) {
		logger.info("Handle when manage register request from admin!");
		String result;
		try {
			if (!numOn.equals(null)) {
				numOnPage = numOn; // numOn
			}
		} catch (Exception e) {
			logger.info("None select number of book tour on page!");
		}
		try {
			if ((int) session.getAttribute("roleId") == 2) {
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
						result = "manageregister";
					} else {
						result = "manageregister";
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
						result = "manageregister";
					} else {
						result = "manageregister";
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

	// Forward to Registration List page
	@RequestMapping(value = "registrationlist/{idTour}", method = RequestMethod.GET)
	public String registrationList(ModelMap model, HttpSession session, @PathVariable("idTour") int idTour,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page,
			@RequestParam(required = false, value = "numOn") Integer numOn,
			@RequestParam(required = false, value = "valueSearch2") String valueSearch2,
			@RequestParam(required = true, defaultValue = "1", value = "page2") Integer page2,
			@RequestParam(required = false, value = "numOn2") Integer numOn2,
			@RequestParam(required = false, value = "filterSex") String filterSex,
			@RequestParam(required = false, value = "filterAge") String filterAge,
			@RequestParam(required = false, value = "filterSex2") String filterSex2,
			@RequestParam(required = false, value = "filterAge2") String filterAge2) {
		logger.info("Handle when manage register request from admin!");
		String result = null;
		try {
			if (!numOn.equals(null)) {
				numOnPage = numOn;
			}
			if (!numOn2.equals(null)) {
				numOnPage = numOn2;
			}
		} catch (Exception e) {
			logger.info("None select number of book tour on page!");
		}
		try {
			if ((int) session.getAttribute("roleId") == 2) {
				// Display registration list
				model.addAttribute("searchedValue", valueSearch);
				if (valueSearch != null) {
					Integer num = 0;
					List<BookTour> registrationList = bookTourService.registrationListByValue(valueSearch, idTour);
					if ((registrationList.size() % numOnPage) == 0) {
						num = registrationList.size() / numOnPage;
					} else {
						num = (registrationList.size() / numOnPage) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						logger.info("Search active!");
						model.addAttribute("bookTour", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("registrationList", registrationList);
						model.addAttribute("numBookTour", registrationList.size());
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("numOnPage", numOnPage);
						model.addAttribute("page", page);
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", Pagination.paginationX(page, numOnPage));
						model.addAttribute("y", Pagination.paginationY(registrationList.size(), page, numOnPage));
						result = "registrationlist";
					} else {
						result = "registrationlist";
					}
				}

				// Search none active ! Update registration list
				if (valueSearch == null && filterSex == null && filterAge == null) {
					Integer num = 0;
					List<BookTour> registrationList = regInfoService.registrationList(idTour);
					if ((registrationList.size() % numOnPage) == 0) {
						num = registrationList.size() / numOnPage;
					} else {
						num = (registrationList.size() / numOnPage) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						model.addAttribute("bookTour", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("registrationList", registrationList);
						model.addAttribute("numBookTour", registrationList.size());
						model.addAttribute("pageNum", pageNum);
						model.addAttribute("numOnPage", numOnPage);
						model.addAttribute("page", page);
						model.addAttribute("pageE", new ArrayList<Integer>());
						model.addAttribute("x", Pagination.paginationX(page, 5));
						model.addAttribute("y", Pagination.paginationY(registrationList.size(), page, numOnPage));
						result = "registrationlist";
					} else {
						result = "registrationlist";
					}
				}

				// Filter registration list by sex
				if (filterSex != null) {
					Integer num = 0;
					List<BookTour> regListBySex = filterService.regListByFilterSex(filterSex, idTour);
					if ((regListBySex.size() % numOnPage) == 0) {
						num = regListBySex.size() / numOnPage;
					} else {
						num = (regListBySex.size() / numOnPage) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						model.addAttribute("bookTour", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("registrationList", regListBySex);
						model.addAttribute("numBookTour", regListBySex.size());
						model.addAttribute("pageNum", pageNum);
						model.addAttribute("numOnPage", numOnPage);
						model.addAttribute("page", page);
						model.addAttribute("pageE", new ArrayList<Integer>());
						model.addAttribute("x", Pagination.paginationX(page, 5));
						model.addAttribute("y", Pagination.paginationY(regListBySex.size(), page, numOnPage));
						result = "registrationlist";
					} else {
						result = "registrationlist";
					}
				}

				// Filter registration list by number of ticket
				if (filterAge != null) {
					Integer num = 0;
					List<BookTour> regListByTicket = filterService.regListByFilterAge(filterAge, idTour);
					if ((regListByTicket.size() % numOnPage) == 0) {
						num = regListByTicket.size() / numOnPage;
					} else {
						num = (regListByTicket.size() / numOnPage) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						model.addAttribute("bookTour", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("registrationList", regListByTicket);
						model.addAttribute("numBookTour", regListByTicket.size());
						model.addAttribute("pageNum", pageNum);
						model.addAttribute("numOnPage", numOnPage);
						model.addAttribute("page", page);
						model.addAttribute("pageE", new ArrayList<Integer>());
						model.addAttribute("x", Pagination.paginationX(page, 5));
						model.addAttribute("y", Pagination.paginationY(regListByTicket.size(), page, numOnPage));
						result = "registrationlist";
					} else {
						result = "registrationlist";
					}
				}

				// Display cancel registration list
				model.addAttribute("searchedValue2", valueSearch2);
				if (valueSearch2 != null) {
					Integer num2 = 0;
					List<BookTour> cancelListByKeyword = regInfoService.cancelListByValue(valueSearch2, idTour);
					if ((cancelListByKeyword.size() % numOnPage2) == 0) {
						num2 = cancelListByKeyword.size() / numOnPage2;
					} else {
						num2 = (cancelListByKeyword.size() / numOnPage2) + 1;
					}
					if (page2 <= num2) {
						List<Integer> pageNum2 = IntStream.rangeClosed(1, num2).boxed().collect(Collectors.toList());
						logger.info("Search active!");
						model.addAttribute("cancelReg", new BookTour());
						model.addAttribute("cancelList", cancelListByKeyword);
						model.addAttribute("numCancelReg", cancelListByKeyword.size());
						model.addAttribute("pageNum2", pageNum2);
						model.addAttribute("numOnPage2", numOnPage2);
						model.addAttribute("page2", page2);
						model.addAttribute("pageE2", new ArrayList<Integer>());
						model.addAttribute("x2", Pagination.paginationX(page2, numOnPage2));
						model.addAttribute("y2", Pagination.paginationY(cancelListByKeyword.size(), page2, numOnPage2));
						result = "registrationlist";
					} else {
						result = "registrationlist";
					}
				}

				// Search none active ! Update cancel registration list
				if (valueSearch2 == null && filterSex2 == null && filterAge2 == null) {
					Integer num2 = 0;
					List<BookTour> cancelList = regInfoService.cancelList(idTour);
					if ((cancelList.size() % numOnPage2) == 0) {
						num2 = cancelList.size() / numOnPage2;
					} else {
						num2 = (cancelList.size() / numOnPage2) + 1;
					}
					if (page2 <= num2) {
						List<Integer> pageNum2 = IntStream.rangeClosed(1, num2).boxed().collect(Collectors.toList());
						model.addAttribute("cancelReg", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("cancelList", cancelList);
						model.addAttribute("numCancelReg", cancelList.size());
						model.addAttribute("pageNum2", pageNum2);
						model.addAttribute("numOnPage2", numOnPage2);
						model.addAttribute("page2", page2);
						model.addAttribute("pageE2", new ArrayList<Integer>());
						model.addAttribute("x2", Pagination.paginationX(page2, numOnPage2));
						model.addAttribute("y2", Pagination.paginationY(cancelList.size(), page2, numOnPage2));
						result = "registrationlist";
					} else {
						result = "registrationlist";
					}
				}

				// Filter cancel registration list by sex
				if (filterSex2 != null) {
					Integer num2 = 0;
					List<BookTour> cancelListBySex = filterService.cancelListByFilterSex(filterSex2, idTour);
					if ((cancelListBySex.size() % numOnPage2) == 0) {
						num2 = cancelListBySex.size() / numOnPage2;
					} else {
						num2 = (cancelListBySex.size() / numOnPage2) + 1;
					}
					if (page2 <= num2) {
						List<Integer> pageNum2 = IntStream.rangeClosed(1, num2).boxed().collect(Collectors.toList());
						model.addAttribute("bookTour", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("cancelList", cancelListBySex);
						model.addAttribute("numCancelReg", cancelListBySex.size());
						model.addAttribute("pageNum2", pageNum2);
						model.addAttribute("numOnPage2", numOnPage2);
						model.addAttribute("page2", page2);
						model.addAttribute("pageE2", new ArrayList<Integer>());
						model.addAttribute("x2", Pagination.paginationX(page2, 5));
						model.addAttribute("y2", Pagination.paginationY(cancelListBySex.size(), page2, numOnPage2));
						result = "registrationlist";
					} else {
						result = "registrationlist";
					}
				}

				// Filter registration list by number of ticket
				if (filterAge2 != null) {
					Integer num2 = 0;
					List<BookTour> cancelListByTicket = filterService.cancelListByFilterAge(filterAge2, idTour);
					if ((cancelListByTicket.size() % numOnPage2) == 0) {
						num2 = cancelListByTicket.size() / numOnPage2;
					} else {
						num2 = (cancelListByTicket.size() / numOnPage2) + 1;
					}
					if (page2 <= num2) {
						List<Integer> pageNum2 = IntStream.rangeClosed(1, num2).boxed().collect(Collectors.toList());
						model.addAttribute("bookTour", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("cancelList", cancelListByTicket);
						model.addAttribute("numCancelReg", cancelListByTicket.size());
						model.addAttribute("pageNum2", pageNum2);
						model.addAttribute("numOnPage2", numOnPage2);
						model.addAttribute("page2", page2);
						model.addAttribute("pageE2", new ArrayList<Integer>());
						model.addAttribute("x2", Pagination.paginationX(page2, 5));
						model.addAttribute("y2", Pagination.paginationY(cancelListByTicket.size(), page2, numOnPage2));
						result = "registrationlist";
					} else {
						result = "registrationlist";
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

	// Delete customer booked tour
	@RequestMapping(value = "deletebooktour/{idBT}/{idTour}")
	public String deleteBookTour(@PathVariable("idBT") Integer idBT, @PathVariable("idBT") int idTour) {
		regInfoService.deleteBookTour(idBT, idTour);
		return "redirect:/registrationlist/{idTour}";
	}

	// Forward to Design form
	@RequestMapping(value = "designform/{idTour}", method = RequestMethod.GET)
	public String designForm(ModelMap model, @PathVariable("idTour") int idTour) throws ParseException {
		logger.info("Display design form page when admin request!");
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
			model.addAttribute("designForm", tour);
			model.addAttribute("idTour", idTour);
		} else {
			logger.info("Null Object!");
		}
		return "designform";
	}

	// Test errors
	@RequestMapping(value = "designform/{idTour}", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("designForm") @Valid Tour tour, BindingResult br,
			HttpSession session, @PathVariable("idTour") int idTour, @RequestParam("other") String other,
			@RequestParam("type") String type) {
		// Checking at least one field of registration is true
		if ((tour.getFieldAddress() || tour.getFieldEmail() || tour.getFieldIdCard() || tour.getFieldName()
				|| tour.getFieldPhone() || tour.getFieldSex()) || tour.getFieldYearOfBirth()) {
			// Have at least 1 field is true
			tourService.updateTour(tour);
			logger.info("Saved registration form into DB successfully");
			return "redirect:/manageregister";
		} else {
			// Haven't field is true
			return "designform";
		}
	}

	// Delete customer after cancel registration
	@RequestMapping(value = "delcuscancel/{idBT}/{idTour}")
	public String deleteCusCancel(@PathVariable("idBT") Integer idBT, @PathVariable("idBT") int idTour) {
		regInfoService.deleteBookTour(idBT, idTour);
		return "redirect:/registrationlist/{idTour}";
	}

	// Administration undo customer cancel registration
	@RequestMapping(value = "undocancel/{idBT}/{idTour}")
	public String undoCancel(@PathVariable("idBT") Integer idBT, @PathVariable("idTour") int idTour) {
		regInfoService.undoCancel(idBT);
		return "redirect:/registrationlist/{idTour}";
	}

	// Forward to Customer detail page
	@RequestMapping(value = "reginfodetail/{idBT}", method = RequestMethod.GET)
	public String showDetail(ModelMap model, @PathVariable("idBT") int idBT) {
		logger.info("Show registration infomation!");
		model.put("cusData", bookTourService.searchById(idBT));
		int re = bookTourService.searchById(idBT).getRelationship();
		model.put("register", regInfoService.getFirstElement(re));
		return "reginfodetail";
	}

	// Forward to Edit information of customer booked tour
	@RequestMapping(value = "editreginfo/{idBT}/{idTour}", method = RequestMethod.GET)
	public String showEditForm(ModelMap model, @PathVariable("idBT") int idBT, @PathVariable("idTour") int idTour) {
		logger.info("Display edit form when admin request!");
		model.put("cusData", bookTourService.searchById(idBT));
		return "editreginfo";
	}

	// Test errors
	@RequestMapping(value = "editreginfo/{idBT}/{idTour}", method = RequestMethod.POST)
	public String editRegInfo(@PathVariable("idBT") Integer idBT, @PathVariable("idTour") int idTour, ModelMap model,
			HttpSession session, @ModelAttribute("cusData") @Valid BookTour bookTour, BindingResult br,
			@Valid Tour tour) {
		logger.info("Handle edit information customer form when admin submit!");
		BookTourValidator bookTourValidator = new BookTourValidator();
		bookTourValidator.validate(bookTour, br);
		tour = tourService.findTourById(idTour);
		if (br.hasErrors()) {
			logger.info("Tour info: " + tour);
			if (tour != null) {
				model.addAttribute("tour", tour);
			}
			return "editreginfo";
		} else {
			bookTour.setTour(tour);
			logger.info("Edit registration infomation success!");
			bookTour.setDateBook(Calendar.getInstance().getTime());
			bookTourService.saveBookTour(bookTour, idTour);
			return "redirect:/registrationlist/{idTour}";
		}
	}

	// Customer cancel registration tour
	@RequestMapping(value = "cancelreg/{idBT}/{idTour}")
	public String cancelBookTour(@PathVariable("idBT") Integer idBT, @PathVariable("idTour") Integer idTour) {
		bookTourService.cancelBookTour(idBT);
		return "redirect:/registrationlist/{idTour}";
	}
}
