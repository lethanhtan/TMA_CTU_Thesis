package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.ctu.thesis.travelsystem.model.User;
import edu.ctu.thesis.travelsystem.service.UserService;
import edu.ctu.thesis.travelsystem.validator.UserValidator;
/*------------------------------------------------------------*/
/*					UserController                            */
/*This controller be used to handle login, register and logout*/
/*request                                                     */
/*------------------------------------------------------------*/
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//Processing for register when required request
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.put("customerData", new User());
		return "register";
	}
	
	//Processing for form register
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("customerData") @Valid User user, BindingResult br, HttpSession session) {
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, br);
		if (br.hasErrors()) {//form input have error
			return "register";
		} else {//form input is ok
			userService.saveUser(user);
			session.setAttribute("user", user);
			session.setAttribute("userName", user.getNameUser());
			return "redirect:login";
		}
		
	}
	
	//Processing for login when required request
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			model.put("customerData", new User());
			return "login";
		}
		else {
			return "redirect:home";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(ModelMap model, @ModelAttribute("customerData") User user, HttpSession session) {
		if (user.getUserName() != null && user.getPassword() != null && session.getAttribute("user") == null) {
			user = userService.loginUser(user);
			if (user != null) {
				if (userService.getRoleUser(user) == 2) {
					session.setAttribute("user", user);
					session.setAttribute("userName", user.getNameUser());
					session.setAttribute("roleId", user.getRole().getIdRole());
					return "redirect:managetour";
				}
				else {
					session.setAttribute("user", user);
					session.setAttribute("userName", user.getNameUser());
					return "redirect:login";
				}
			}
			else {
				System.out.println("The username or password is incorrect");
				model.put("failed", "Tài khoản hoặc mật khẩu không đúng");
				return "login";
			}
		}
		else {
			return "redirect:home";
		}
	}
	
	//handel for logout request
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(ModelMap model, HttpSession session) {
		session.removeAttribute("user"); //remove user object from session
		session.removeValue("userName"); //remove userName value
		session.removeValue("roleId");	//remove roleId value
		return "redirect:login";
	}
}