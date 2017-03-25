package edu.ctu.thesis.travelsystem.controller;

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

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.RegistrationInfo;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.BookTourService;
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

	private static final Logger logger = Logger.getLogger(ManageRegController.class);

	// Display tour list
	@RequestMapping(value = "manageregister", method = RequestMethod.GET)
	public String manageRegController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page) {
		logger.info("Handle when manage register request from admin!");
		String result;
		try {
			if ((int) session.getAttribute("roleId") == 2) {
				model.addAttribute("searchedValue", valueSearch);
				if (valueSearch != null) {
					Integer num = 0;
					if ((tourService.getNumTourByValue(valueSearch) % 5) == 0) {
						num = tourService.getNumTourByValue(valueSearch) / 5;
					} else {
						num = (tourService.getNumTourByValue(valueSearch) / 5) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						logger.info("Search active!");
						model.addAttribute("tour", new Tour());
						model.addAttribute("tourList", tourService.listTourByValue(valueSearch));
						model.addAttribute("numTour", tourService.getNumTourByValue(valueSearch));
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", tourService.paginationX(page, 5));
						model.addAttribute("y",
								tourService.paginationY(tourService.listTourByValue(valueSearch).size(), page, 5));
						result = "manageregister";
					} else {
						result = "manageregister";
					}
				} else { // search none active ! Update list tour
					Integer num = 0;
					if ((tourService.getNumTour() % 5) == 0) {
						num = tourService.getNumTour() / 5;
					} else {
						num = (tourService.getNumTour() / 5) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						model.addAttribute("tour", new Tour());
						model.addAttribute("tourList", tourService.listTour()); // create
						model.addAttribute("numTour", tourService.getNumTour()); // create
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", tourService.paginationX(page, 5));
						model.addAttribute("y", tourService.paginationY(tourService.listTour().size(), page, 5));
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
	@RequestMapping(value = "/registrationlist/{idTour}", method = RequestMethod.GET)
	public String registrationList(ModelMap model, HttpSession session, @PathVariable("idTour") int idTour,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page) {
		logger.info("Handle when manage register request from admin!");
		String result;
		try {
			if ((int) session.getAttribute("roleId") == 2) {
				model.addAttribute("searchedValue", valueSearch);
				if (valueSearch != null) {
					Integer num = 0;
					if ((bookTourService.getNumBTBySearch(valueSearch, idTour) % 5) == 0) {
						num = bookTourService.getNumBTBySearch(valueSearch, idTour) / 5;
					} else {
						num = (bookTourService.getNumBTBySearch(valueSearch, idTour) / 5) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						logger.info("Search active!");
						model.addAttribute("bookTour", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("registrationList",
								bookTourService.registrationListByValue(valueSearch, idTour));
						model.addAttribute("numBookTour", bookTourService.getNumBTBySearch(valueSearch, idTour));
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", tourService.paginationX(page, 5));
						model.addAttribute("y", tourService.paginationY(
								bookTourService.registrationListByValue(valueSearch, idTour).size(), page, 5));
						result = "registrationlist";
					} else {
						result = "registrationlist";
					}
				} else { // search none active ! Update list tour
					Integer num = 0;
					if ((regInfoService.getNumBookTour(idTour) % 5) == 0) {
						num = regInfoService.getNumBookTour(idTour) / 5;
					} else {
						num = (regInfoService.getNumBookTour(idTour) / 5) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						model.addAttribute("bookTour", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("registrationList", regInfoService.registrationList(idTour)); // create
						model.addAttribute("numBookTour", regInfoService.getNumBookTour(idTour)); // create
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", tourService.paginationX(page, 5));
						model.addAttribute("y",
								tourService.paginationY(regInfoService.registrationList(idTour).size(), page, 5));
						result = "registrationlist";
					} else {
						result = "registrationlist";
					}
				}
			} else {
				result = "registrationlist";
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
	public String designForm(ModelMap model, @PathVariable("idTour") int idTour, @Valid RegistrationInfo regInfo) {
		logger.info("Display design form page when admin request!");
		regInfo = regInfoService.searchRegInfoById(idTour);
		logger.info("Reg Info: " + regInfo);
		if (regInfo != null) {
			model.addAttribute("designForm", regInfo);
			model.addAttribute("tour", idTour);
			logger.info("Design form for: " + idTour);
			Tour tour = tourService.findTourById(idTour);
			regInfo.setTour(tour);
		}
		logger.info("Load design form success");
		return "designform";
	}

	// Test errors
	@RequestMapping(value = "designform/{idTour}", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("designForm") @Valid RegistrationInfo regInfo,
			BindingResult br, HttpSession session, @PathVariable("idTour") int idTour) {
		// Checking at least one field of registration is true
		if ((regInfo.getFieldAddress() || regInfo.getFieldEmail() || regInfo.getFieldIdCard() || regInfo.getFieldName()
				|| regInfo.getFieldPhone() || regInfo.getFieldSex()) == true) {
			// Have at least 1 field is true
			regInfoService.saveRegInfoForm(regInfo, idTour);
			logger.info("Saved registration form into DB successfully");
			return "redirect:/manageregister";
		} else {
			// Haven't field is true
			return "designform";
		}
	}

	// Forward to Cancel list page
	@RequestMapping(value = "cancellist/{idTour}", method = RequestMethod.GET)
	public String cancelList(ModelMap model, HttpSession session, @PathVariable("idTour") int idTour,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page) {
		logger.info("Handle when manage cancel list request from admin!");
		String result;
		try {
			if ((int) session.getAttribute("roleId") == 2) {
				model.addAttribute("searchedValue", valueSearch);
				if (valueSearch != null) {
					Integer num = 0;
					if ((regInfoService.getNumCancelBySearch(valueSearch) % 5) == 0) {
						num = regInfoService.getNumCancelBySearch(valueSearch) / 5;
					} else {
						num = (regInfoService.getNumCancelBySearch(valueSearch) / 5) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						logger.info("Search active!");
						model.addAttribute("cancelReg", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("cancelList", regInfoService.cancelListByValue(valueSearch));
						model.addAttribute("numCancelReg", regInfoService.getNumCancelBySearch(valueSearch));
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", tourService.paginationX(page, 5));
						model.addAttribute("y",
								tourService.paginationY(regInfoService.cancelListByValue(valueSearch).size(), page, 5));
						result = "cancellist";
					} else {
						result = "cancellist";
					}
				} else { // search none active ! Update list tour
					Integer num = 0;
					if ((regInfoService.getNumCancelReg(idTour) % 5) == 0) {
						num = regInfoService.getNumCancelReg(idTour) / 5;
					} else {
						num = (regInfoService.getNumCancelReg(idTour) / 5) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						model.addAttribute("cancelReg", new BookTour());
						model.addAttribute("tour", tourService.findTourById(idTour));
						model.addAttribute("cancelList", regInfoService.cancelList(idTour)); // create
						model.addAttribute("numCancelReg", regInfoService.getNumCancelReg(idTour)); // create
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", tourService.paginationX(page, 5));
						model.addAttribute("y",
								tourService.paginationY(regInfoService.cancelList(idTour).size(), page, 5));
						result = "cancellist";
					} else {
						result = "cancellist";
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

	// Delete customer after cancel registration
	@RequestMapping(value = "delcuscancel/{idBT}/{idTour}")
	public String deleteCusCancel(@PathVariable("idBT") Integer idBT, @PathVariable("idBT") int idTour) {
		regInfoService.deleteBookTour(idBT, idTour);
		return "redirect:/cancellist/{idTour}";
	}

	// Administration undo customer cancel registration
	@RequestMapping(value = "undocancel/{idBT}/{idTour}")
	public String undoCancel(@PathVariable("idBT") Integer idBT, @PathVariable("idBT") int idTour) {
		regInfoService.undoCancel(idBT, idTour);
		return "redirect:/cancellist/{idTour}";
	}
	
	// Forward to Customer detail page
		@RequestMapping(value = "/reginfodetail/{idBT}/{idTour}", method = RequestMethod.GET)
		public String showDetail(ModelMap model, @PathVariable("idBT") int idBT, @PathVariable("idTour") int idTour,
				@Valid RegistrationInfo regInfo) {
			logger.info("Show information of customer when book tour");
			model.put("cusData", bookTourService.searchById(idBT));
			regInfo = regInfoService.searchRegInfoById(idTour);
			logger.info("Reg Info: " + regInfo);
			if (regInfo != null) {
				model.addAttribute("regInfo", regInfo);
			}
			return "reginfodetail";
		}

	// Forward to Edit information of customer booked tour
	@RequestMapping(value = "editreginfo/{idBT}/{idTour}", method = RequestMethod.GET)
	public String showEditForm(ModelMap model, @PathVariable("idBT") int idBT, @PathVariable("idTour") int idTour,
			@Valid RegistrationInfo regInfo) {
		logger.info("Display edit form when admin request!");
		model.put("cusData", bookTourService.searchById(idBT));
		regInfo = regInfoService.searchRegInfoById(idTour);
		logger.info("Reg Info: " + regInfo);
		if (regInfo != null) {
			model.addAttribute("regInfo", regInfo);
		}
		return "editreginfo";
	}

	// Test errors
	@RequestMapping(value = "editreginfo/{idBT}/{idTour}", method = RequestMethod.POST)
	public String editRegInfo(@PathVariable("idBT") Integer idBT, @PathVariable("idTour") int idTour, ModelMap model,
			HttpSession session, @ModelAttribute("cusData") @Valid BookTour bookTour, BindingResult br,
			@Valid RegistrationInfo regInfo) {
		logger.info("Handle edit information customer form when admin submit!");
		BookTourValidator bookTourValidator = new BookTourValidator();
		bookTourValidator.validate(bookTour, br);
		if (br.hasErrors()) {
			regInfo = regInfoService.searchRegInfoById(idTour);
			logger.info("Reg Info: " + regInfo);
			if (regInfo != null) {
				model.addAttribute("regInfo", regInfo);
			}
			return "editreginfo";
		} else {
			Tour tour = tourService.findTourById(idTour);
			bookTour.setTour(tour);
			logger.info("Edit success!");
			bookTour.setDateBook(Calendar.getInstance().getTime());
			bookTourService.editBookTour(bookTour);
			return "redirect:/registrationlist/{idTour}";
		}
	}
}