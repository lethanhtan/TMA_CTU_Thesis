package edu.ctu.thesis.travelsystem.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import edu.ctu.thesis.travelsystem.model.Role;
import edu.ctu.thesis.travelsystem.model.User;
import edu.ctu.thesis.travelsystem.service.UserService;
import edu.ctu.thesis.travelsystem.validator.UserValidator;

@Controller
public class ManageUserController {
	@Autowired
	private UserService userService;

	private static final Logger logger = Logger.getLogger(ManageUserController.class);
	private static int numOnPage = 6;

	// Handle for manage user request from admin
	@RequestMapping(value = "manageuser", method = RequestMethod.GET)
	public String manageUserController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page,
			@RequestParam(required = false, value = "numOn") Integer numOn) {
		logger.info("Handle when managetour request from admin!");
		String result;
		try {
			if (!numOn.equals(null)) {
				numOnPage = numOn + 1; // numOn
			}
		} catch (Exception e) {
			logger.info("None select number of account on page!");
		}
		int id = (int) session.getAttribute("idUser");
		try {
			if ((int) session.getAttribute("roleId") == 2) {
				model.addAttribute("searchedValue", valueSearch);
				if (valueSearch != null) {
					Integer num = 0;
					List<User> userList = userService.userListByValue(valueSearch);
					if ((userList.size() % numOnPage) == 0) {
						num = userList.size() / numOnPage;
					} else {
						num = (userList.size() / numOnPage) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						logger.info("Search active!");
						model.addAttribute("user", new User());
						model.addAttribute("id", id);
						model.addAttribute("userList", userList);
						model.addAttribute("numUser", userList.size());
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("numOnPage", numOnPage);
						model.addAttribute("page", page);
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", Pagination.paginationX(page, numOnPage));
						model.addAttribute("y", Pagination.paginationY(userList.size(), page, numOnPage));
						result = "manageuser";
					} else {
						result = "manageuser";
					}
				} else { // search none active ! Update list tour
					Integer num = 0;
					List<User> userList = userService.userList();
					if ((userList.size() % numOnPage) == 0) {
						num = userList.size() / numOnPage;
					} else {
						num = (userList.size() / numOnPage) + 1;
					}
					if (page <= num) {
						List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
						model.addAttribute("user", new User());
						model.addAttribute("id", id);
						model.addAttribute("userList", userList); // create
						model.addAttribute("numUser", userList.size()); // create
						model.addAttribute("pageNum", pageNum); // create number
						model.addAttribute("numOnPage", numOnPage);
						model.addAttribute("page", page);
						model.addAttribute("pageE", new ArrayList<Integer>()); // create
						model.addAttribute("x", Pagination.paginationX(page, numOnPage));
						model.addAttribute("y", Pagination.paginationY(userList.size(), page, numOnPage));
						result = "manageuser";
					} else {
						result = "manageuser";
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

	// Forward to User detail page
	@RequestMapping(value = "userdetail/{idUser}", method = RequestMethod.GET)
	public String showUserDetail(ModelMap model, @PathVariable("idUser") int idUser) {
		logger.info("Show user detail!");
		model.put("userData", userService.searchUserById(idUser));
		return "userdetail";
	}

	// Delete tour in Detail tour page
	@RequestMapping(value = "userdetail/delete/{idTour}")
	public String deleteUser(@PathVariable("idUser") int idUser) {
		userService.deleteUser(idUser);
		return "redirect:/manageuser";
	}

	// Handle required request from client
	@RequestMapping(value = "edituser/{idUser}", method = RequestMethod.GET)
	public String showEditForm(ModelMap model, @PathVariable("idUser") int idUser, HttpSession session)
			throws ParseException {
		logger.info("Handle edit form when administrator request!");
		logger.info("Display edit user form when administrator request!");
		User user = userService.searchUserById(idUser);
		if (user != null) {
			model.addAttribute("userData", userService.searchUserById(idUser));
			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String birthday = sdf.format(user.getBirthday());
			model.addAttribute("dateofbirth", birthday);
		} else {
			logger.info("Null Object!");
		}
		return "edituser";
	}

	// Handle form action edit user
	@RequestMapping(value = "edituser/{idUser}", method = RequestMethod.POST)
	public String editUser(ModelMap model, @PathVariable("idUser") int idUser,
			@ModelAttribute("userData") @Valid User user, BindingResult br, HttpSession session) {
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, br);
		if (br.hasErrors()) {
			return "edituser";
		} else {
			logger.info("Update user if haven't error!");
			Role role = new Role();
			if (user.getDescRole().equals("Khách hàng")) {
				role.setId(1);
			} else {
				role.setId(2);
			}
			user.setRole(role);
			userService.editUser(user);
			return "redirect:/manageuser";
		}
	}

	// Handle delete request from administrator
	@RequestMapping(value = "manageuser/deleteuser/{idUser}")
	public String delUser(@PathVariable("idUser") int idUser) {
		userService.deleteUser(idUser);
		return "redirect:/manageuser";
	}
}
