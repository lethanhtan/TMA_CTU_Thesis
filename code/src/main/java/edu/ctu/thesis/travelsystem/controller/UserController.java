package edu.ctu.thesis.travelsystem.controller;

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

import edu.ctu.thesis.travelsystem.model.Role;
import edu.ctu.thesis.travelsystem.model.User;
import edu.ctu.thesis.travelsystem.service.UserService;
import edu.ctu.thesis.travelsystem.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	private static final Logger logger = Logger.getLogger(UserController.class);

	// Processing for register when required request
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		logger.info("Handle register request when client send!");
		model.put("userData", new User());// put userData as a User
		return "register";
	}

	// Processing for form register when submit
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("userData") @Valid User user, BindingResult br,
			HttpSession session) {
		logger.info("Handle register form action when user submit!");
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, br);
		if (br.hasErrors()) { // form input have error
			return "register";
		} else { // form input is ok
			userService.saveUser(user);
			session.setAttribute("user", user);
			session.setAttribute("userName", user.getFullName());
			session.setAttribute("idUser", user.getIdUser());
			return "redirect:login";
		}
	}

	// Processing for login when required request
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model, HttpSession session) {
		logger.info("Handle login request when client send!");
		if (session.getAttribute("user") == null) {
			model.put("userData", new User()); // put userData as a user
			return "login";
		} else {
			return "redirect:home";
		}
	}

	// Handle for form login when submit
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(ModelMap model, @ModelAttribute("userData") User user, HttpSession session) {
		if (user.getUserName() != null && user.getPassword() != null && session.getAttribute("user") == null) {
			user = userService.loginUser(user);
			logger.info("Handle login form action when user submit!");
			if (user != null) {
				if (userService.getRoleUser(user) == 2) {
					session.setAttribute("user", user);
					session.setAttribute("userName", user.getFullName());
					session.setAttribute("roleId", user.getRole().getId());
					session.setAttribute("idUser", user.getIdUser());
					return "redirect:managetour";
				} else {
					session.setAttribute("user", user);
					session.setAttribute("userName", user.getFullName());
					session.setAttribute("idUser", user.getIdUser());
					return "redirect:login";
				}
			} else {
				logger.info("The username or password is incorrect");
				model.put("failed", "Tài khoản hoặc mật khẩu không đúng");
				return "login";
			}
		} else {
			return "redirect:home";
		}
	}

	// Handel for logout request
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(ModelMap model, HttpSession session) {
		session.removeAttribute("user"); // remove user object from session
		session.removeValue("userName"); // remove userName value
		session.removeValue("roleId"); // remove roleId value
		return "redirect:login";
	}

	// Forward to manage my account page
	@RequestMapping(value = "managemyacc/{idUser}", method = RequestMethod.GET)
	public String showMyAccDetail(ModelMap model, @PathVariable("idUser") int idUser) {
		logger.info("Show user detail!");
		model.put("userData", userService.searchUserById(idUser));
		return "managemyacc";
	}

	// Handle required request from client
	@RequestMapping(value = "editmyacc/{idUser}", method = RequestMethod.GET)
	public String showEditForm(ModelMap model, @PathVariable("idUser") int idUser) {
		logger.info("Handle edit form when administrator request!");
		logger.info("Display edit user form when administrator request!");
		model.addAttribute("userData", userService.searchUserById(idUser));
		return "editmyacc";
	}

	// Handle form action edit my account
	@RequestMapping(value = "editmyacc/{idUser}")
	public String editUser(ModelMap model, @PathVariable("idUser") int idUser,
			@ModelAttribute("userData") @Valid User user, BindingResult br, HttpSession session) {
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, br);
		if (br.hasErrors()) {
			return "editmyacc";
		} else {
			logger.info("Update user if haven't error!");
			Role role = new Role();
			role.setId(1);
			user.setRole(role);
			userService.editUser(user);
			return "redirect:/managemyacc/{idUser}";
		}
	}
}