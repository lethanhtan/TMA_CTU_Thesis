package edu.ctu.thesis.travelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ctu.thesis.travelsystem.service.BookTourService;

@Controller
public class NotificationController {
	
	@Autowired
	BookTourService bookTourService;

	@RequestMapping(value = "/regsuccess", method = RequestMethod.GET)
	public String successReg() {
		return "regsuccess";
	}
	
	@RequestMapping(value = "/booksuccess", method = RequestMethod.GET)
	public String successBook() {
		return "booksuccess";
	}
	
	@RequestMapping(value = "/cancelsuccess", method = RequestMethod.GET)
	public String successCancel() {
		return "cancelsuccess";
	}
	
	@RequestMapping(value = "/cancelbook/{idBT}", method = RequestMethod.GET)
	public String CancelBook(@PathVariable("idBT") int idBT) {
		return "cancelbook";
	}
	
	@RequestMapping(value = "/cancelbook/{idBT}", method = RequestMethod.POST)
	public String confirmCancelBook(@RequestParam("confirmCode") String confirmCode, 
			@PathVariable("idBT") int idBT,
			ModelMap model ){
		if (confirmCode.equals(bookTourService.searchById(idBT).getConfirmCode())) {
			bookTourService.cancelBookTour(idBT);
			// send cancel success email
			return "redirect:/cancelsuccess";
		} else {
			model.addAttribute("failed", "Vui lòng nhập chính xác mã xác nhận!");
			return "cancelbook";
		}
	}
}
