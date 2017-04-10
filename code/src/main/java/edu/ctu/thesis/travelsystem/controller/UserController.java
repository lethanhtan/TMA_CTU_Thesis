package edu.ctu.thesis.travelsystem.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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

import edu.ctu.thesis.travelsystem.extra.Pagination;
import edu.ctu.thesis.travelsystem.extra.VerifyRecaptcha;
import edu.ctu.thesis.travelsystem.mail.EMailSender;
import edu.ctu.thesis.travelsystem.mail.MailTemplate;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Role;
import edu.ctu.thesis.travelsystem.model.User;
import edu.ctu.thesis.travelsystem.service.BookTourService;
import edu.ctu.thesis.travelsystem.service.UserService;
import edu.ctu.thesis.travelsystem.validator.UserValidator;

@Controller
public class UserController extends HttpServlet {
	@Autowired
	private UserService userService;
	@Autowired
	private BookTourService bookTourService;
	@Autowired
	private EMailSender emailSenderService;

	private static final Logger logger = Logger.getLogger(UserController.class);
	private static final long serialVersionUID = -6506682026701304964L;

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
			HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Handle register form action when user submit!");
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, br);
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		logger.info(gRecaptchaResponse);
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		logger.info("Captcha Verify: " + verify);
		if (br.hasErrors()) {
			return "register"; // form input have error
		}
		if (verify == false) {
			String errorString = "Bạn phải chọn reCaptcha!";
			model.addAttribute("errorString", errorString);
			return "register";
		} else { // form input is ok
			user.setDate(Calendar.getInstance().getTime());
			userService.saveUser(user);
			emailSenderService.SendEmail(user.getEmail(), MailTemplate.hostMail, MailTemplate.regTitle,
					MailTemplate.regBody);
			return "redirect:regsuccess";
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

	// Handle for logout request
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(ModelMap model, HttpSession session) {
		session.removeAttribute("user"); // remove user object from session
		session.removeValue("userName"); // remove userName value
		session.removeValue("roleId"); // remove roleId value
		session.removeValue("idUser");
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
	public String showEditForm(ModelMap model, @PathVariable("idUser") int idUser) throws ParseException {
		logger.info("Handle edit form when administrator request!");
		logger.info("Display edit user form when administrator request!");
		User user = userService.searchUserById(idUser);
		if (user != null) {
			model.addAttribute("userData", user);
			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String birthday = sdf.format(user.getBirthday());
			model.addAttribute("dateofbirth", birthday);
			model.addAttribute("idRole", user.getDescRole());
		} else {
			logger.info("Null Object!");
		}
		return "editmyacc";
	}

	// Handle form action edit my account
	@RequestMapping(value = "editmyacc/{idUser}", method = RequestMethod.POST)
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

	// Forward to Registration List page
	@RequestMapping(value = "managemyreg/{idUser}", method = RequestMethod.GET)
	public String myRegList(ModelMap model, HttpSession session, @PathVariable("idUser") int idUser,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page,
			@RequestParam(required = false, value = "valueSearch2") String valueSearch2,
			@RequestParam(required = true, defaultValue = "1", value = "page2") Integer page2,
			@RequestParam(required = false, value = "valueSearch3") String valueSearch3,
			@RequestParam(required = true, defaultValue = "1", value = "page3") Integer page3) {
		logger.info("Handle when manage register request from admin!");
		String result;
		try {
			// Display registration list
			model.addAttribute("searchedValue", valueSearch);
			if (valueSearch != null) {
				Integer num = 0;
				List<BookTour> myRegList = userService.myRegListByValue(valueSearch, idUser);
				if ((myRegList.size() % 5) == 0) {
					num = myRegList.size() / 5;
				} else {
					num = (myRegList.size() / 5) + 1;
				}
				if (page <= num) {
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					logger.info("Search active!");
					model.addAttribute("bookTour", new BookTour());
					model.addAttribute("myRegList", myRegList);
					model.addAttribute("myNumBT", myRegList.size());
					model.addAttribute("pageNum", pageNum); // create number
					model.addAttribute("pageE", new ArrayList<Integer>()); // create
					model.addAttribute("x", Pagination.paginationX(page, 5));
					model.addAttribute("y", Pagination.paginationY(myRegList.size(), page, 5));
					result = "managemyreg";
				} else {
					result = "managemyreg";
				}
			} else { // search none active ! Update list tour
				Integer num = 0;
				List<BookTour> myRegList = userService.myRegList(idUser);
				if ((myRegList.size() % 5) == 0) {
					num = myRegList.size() / 5;
				} else {
					num = (myRegList.size() / 5) + 1;
				}

				if (page <= num) {
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					model.addAttribute("bookTour", new BookTour());
					model.addAttribute("myRegList", myRegList);
					model.addAttribute("myNumBT", myRegList.size());
					model.addAttribute("pageNum", pageNum);
					model.addAttribute("pageE", new ArrayList<Integer>());
					model.addAttribute("x", Pagination.paginationX(page, 5));
					model.addAttribute("y", Pagination.paginationY(myRegList.size(), page, 5));
					result = "managemyreg";
				} else {
					result = "managemyreg";
				}
			}
			// Display cancel registration list
			model.addAttribute("searchedValue2", valueSearch2);
			if (valueSearch2 != null) {
				Integer num2 = 0;
				List<BookTour> myCancelList = userService.myCancelListByValue(valueSearch2, idUser);
				if ((myCancelList.size() % 5) == 0) {
					num2 = myCancelList.size() / 5;
				} else {
					num2 = (myCancelList.size() / 5) + 1;
				}
				if (page2 <= num2) {
					List<Integer> pageNum2 = IntStream.rangeClosed(1, num2).boxed().collect(Collectors.toList());
					logger.info("Search active!");
					model.addAttribute("myCancelReg", new BookTour());
					model.addAttribute("myCancelList", myCancelList);
					model.addAttribute("myNumCancelReg", myCancelList.size());
					model.addAttribute("pageNum2", pageNum2);
					model.addAttribute("pageE2", new ArrayList<Integer>());
					model.addAttribute("x2", Pagination.paginationX(page2, 5));
					model.addAttribute("y2", Pagination.paginationY(myCancelList.size(), page2, 5));
					result = "managemyreg";
				} else {
					result = "managemyreg";
				}
			} else { // search none active ! Update list tour
				Integer num2 = 0;
				List<BookTour> myCancelList = userService.myCancelList(idUser);
				if ((myCancelList.size() % 5) == 0) {
					num2 = myCancelList.size() / 5;
				} else {
					num2 = (myCancelList.size() / 5) + 1;
				}
				if (page2 <= num2) {
					List<Integer> pageNum2 = IntStream.rangeClosed(1, num2).boxed().collect(Collectors.toList());
					model.addAttribute("myCancelReg", new BookTour());
					model.addAttribute("myCancelList", myCancelList);
					model.addAttribute("myNumCancelReg", myCancelList.size());
					model.addAttribute("pageNum2", pageNum2);
					model.addAttribute("pageE2", new ArrayList<Integer>());
					model.addAttribute("x2", Pagination.paginationX(page2, 5));
					model.addAttribute("y2", Pagination.paginationY(myCancelList.size(), page2, 5));
					result = "managemyreg";
				} else {
					result = "managemyreg";
				}
			}

			// Display my tour gone
			model.addAttribute("searchedValue3", valueSearch3);
			if (valueSearch3 != null) {
				Integer num3 = 0;
				List<BookTour> myBookTourList = userService.myBookTourListByValue(valueSearch3, idUser);
				if ((myBookTourList.size() % 5) == 0) {
					num3 = myBookTourList.size() / 5;
				} else {
					num3 = (myBookTourList.size() / 5) + 1;
				}
				if (page3 <= num3) {
					List<Integer> pageNum3 = IntStream.rangeClosed(1, num3).boxed().collect(Collectors.toList());
					logger.info("Search active!");
					model.addAttribute("myBookTour", new BookTour());
					model.addAttribute("myBookTourList", myBookTourList);
					model.addAttribute("myNumBookTour", myBookTourList.size());
					model.addAttribute("pageNum3", pageNum3); // create number
					model.addAttribute("pageE3", new ArrayList<Integer>()); // create
					model.addAttribute("x3", Pagination.paginationX(page3, 5));
					model.addAttribute("y3", Pagination.paginationY(myBookTourList.size(), page3, 5));
					result = "managemyreg";
				} else {
					result = "managemyreg";
				}
			} else { // search none active ! Update list tour
				Integer num3 = 0;
				List<BookTour> myBookTourList = userService.myBookTourList(idUser);
				if ((myBookTourList.size() % 5) == 0) {
					num3 = myBookTourList.size() / 5;
				} else {
					num3 = (myBookTourList.size() / 5) + 1;
				}
				if (page3 <= num3) {
					List<Integer> pageNum3 = IntStream.rangeClosed(1, num3).boxed().collect(Collectors.toList());
					model.addAttribute("myBookTour", new BookTour());
					model.addAttribute("myBookTourList", myBookTourList);
					model.addAttribute("myNumBookTour", myBookTourList.size());
					model.addAttribute("pageNum3", pageNum3);
					model.addAttribute("pageE3", new ArrayList<Integer>());
					model.addAttribute("x3", Pagination.paginationX(page3, 5));
					model.addAttribute("y3", Pagination.paginationY(myBookTourList.size(), page3, 5));
					result = "managemyreg";
				} else {
					result = "managemyreg";
				}
			}
		} catch (Exception e) {
			logger.error("Occured ex", e);
			result = "forbidden";
		}
		return result;
	}

	// Customer cancel registration tour
	@RequestMapping(value = "cancel/{idBT}")
	public String cancelBookTour(@PathVariable("idBT") Integer idBT, HttpSession session, ModelMap model) {
		bookTourService.cancelBookTour(idBT);
		model.addAttribute("idUser", (int) session.getAttribute("idUser"));
		return "redirect:/managemyreg/{idUser}";
	}

	// User undo cancel registration
	@RequestMapping(value = "undo/{idBT}/{idTour}")
	public String undoCancel(@PathVariable("idBT") Integer idBT, @PathVariable("idBT") int idTour, HttpSession session,
			ModelMap model) {
		userService.undoCancel(idBT, idTour);
		model.addAttribute("idUser", (int) session.getAttribute("idUser"));
		return "redirect:/managemyreg/{idUser}";
	}
}
