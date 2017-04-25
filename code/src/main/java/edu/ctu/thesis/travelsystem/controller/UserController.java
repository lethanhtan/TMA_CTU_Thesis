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

import edu.ctu.thesis.travelsystem.extra.CheckConnections;
import edu.ctu.thesis.travelsystem.extra.EncoderPassword;
import edu.ctu.thesis.travelsystem.extra.Pagination;
import edu.ctu.thesis.travelsystem.extra.VerifyRecaptcha;
import edu.ctu.thesis.travelsystem.mail.EMailSender;
import edu.ctu.thesis.travelsystem.mail.MailTemplate;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Role;
import edu.ctu.thesis.travelsystem.model.User;
import edu.ctu.thesis.travelsystem.service.BookTourService;
import edu.ctu.thesis.travelsystem.service.RegInfoService;
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
	@Autowired
	private RegInfoService regInfoService;

	private static final Logger logger = Logger.getLogger(UserController.class);
	private static final long serialVersionUID = -6506682026701304964L;
	private static int numOnPage = 5;
	private static int numOnPage2 = 5;
	private static int numOnPage3 = 5;

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
			HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "passwordConfirm") String passwordConfirm,
			@RequestParam(value = "userName") String userName) throws ServletException, IOException {
		logger.info("Handle register form action when user submit!");
		try {
			if (!userService.findUserByUserName(userName).equals(null)) {
				model.addAttribute("invalidUserName", "Tên người dùng đã tồn tại!");
			}
		} catch (NullPointerException e) {

		}
		if (passwordConfirm.equals(null)) {
			model.addAttribute("failedPasswordConfirm", "Xin vui lòng nhập lại mật khẩu!");
		} else if (!password.equals(passwordConfirm)) {
			logger.info(passwordConfirm);
			model.addAttribute("failedPasswordConfirm", "Vui lòng nhập lại chính xác mật khẩu!");
		}
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, br);
		boolean verify = true;
		if (CheckConnections.checkConnect("https://www.google.com")) {
			String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
			logger.info(gRecaptchaResponse);
			verify = VerifyRecaptcha.verify(gRecaptchaResponse);
			logger.info("Captcha Verify: " + verify);
		} else {
			model.addAttribute("failedConnect", "Không có kết nối internet!");
			return "register";
		}
		if (br.hasErrors()) {
			return "register"; // form input have error
		}
		if (verify == false) {
			String errorString = "Bạn phải chọn reCaptcha!";
			model.addAttribute("errorString", errorString);
			return "register";
		} else { // form input is ok
			if (CheckConnections.checkConnect("https://www.google.com")) {
				emailSenderService.SendEmail(user.getEmail(), MailTemplate.hostMail, MailTemplate.regTitle,
						MailTemplate.regBody);
				user.setDate(Calendar.getInstance().getTime());
				userService.saveUser(user);
				return "redirect:regsuccess";
			} else {
				model.addAttribute("failedConnect", "Không có kết nối internet!");
				return "register";
			}
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
					session.setAttribute("fullName", user.getFullName());
					session.setAttribute("userName", user.getUserName());
					session.setAttribute("roleId", user.getRole().getId());
					session.setAttribute("idUser", user.getIdUser());
					session.setAttribute("phone", user.getPhone());
					return "redirect:managetour";
				} else {
					session.setAttribute("user", user);
					session.setAttribute("fullName", user.getFullName());
					session.setAttribute("userName", user.getUserName());
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
		session.removeValue("fullName");
		session.removeValue("phone");
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
			@RequestParam(required = false, value = "numOn") Integer numOn,
			@RequestParam(required = false, value = "valueSearch2") String valueSearch2,
			@RequestParam(required = true, defaultValue = "1", value = "page2") Integer page2,
			@RequestParam(required = false, value = "numOn2") Integer numOn2,
			@RequestParam(required = false, value = "valueSearch3") String valueSearch3,
			@RequestParam(required = true, defaultValue = "1", value = "page3") Integer page3,
			@RequestParam(required = false, value = "numOn3") Integer numOn3) {
		logger.info("Handle when manage register request from admin!");
		String result;
		try {
			// Display registration list
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
				List<BookTour> myRegList = userService.myRegListByValue(valueSearch, idUser);
				if (myRegList.size() == 0) {
					num = myRegList.size() / numOnPage;
				} else {
					num = (myRegList.size() / numOnPage) + 1;
				}
				if (page <= num) {
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					logger.info("Search active!");
					model.addAttribute("bookTour", new BookTour());
					model.addAttribute("myRegList", myRegList);
					model.addAttribute("myNumBT", myRegList.size());
					model.addAttribute("pageNum", pageNum); // create number
					model.addAttribute("numOnPage", numOnPage);
					model.addAttribute("page", page);
					model.addAttribute("pageE", new ArrayList<Integer>()); // create
					model.addAttribute("x", Pagination.paginationX(page, numOnPage));
					model.addAttribute("y", Pagination.paginationY(myRegList.size(), page, numOnPage));
					result = "managemyreg";
				} else {
					result = "managemyreg";
				}
			} else { // search none active ! Update list tour
				Integer num = 0;
				List<BookTour> myRegList = userService.myRegList(idUser);
				if ((myRegList.size() % numOnPage) == 0) {
					num = myRegList.size() / numOnPage;
				} else {
					num = (myRegList.size() / numOnPage) + 1;
				}
				if (page <= num) {
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					model.addAttribute("bookTour", new BookTour());
					model.addAttribute("myRegList", myRegList);
					model.addAttribute("myNumBT", myRegList.size());
					model.addAttribute("pageNum", pageNum);
					model.addAttribute("numOnPage", numOnPage);
					model.addAttribute("page", page);
					model.addAttribute("pageE", new ArrayList<Integer>());
					model.addAttribute("x", Pagination.paginationX(page, numOnPage));
					model.addAttribute("y", Pagination.paginationY(myRegList.size(), page, numOnPage));
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
				if (myCancelList.size() == 0) {
					num2 = myCancelList.size() / numOnPage2;
				} else {
					num2 = (myCancelList.size() / numOnPage2) + 1;
				}
				if (page2 <= num2) {
					List<Integer> pageNum2 = IntStream.rangeClosed(1, num2).boxed().collect(Collectors.toList());
					logger.info("Search active!");
					model.addAttribute("myCancelReg", new BookTour());
					model.addAttribute("myCancelList", myCancelList);
					model.addAttribute("myNumCancelReg", myCancelList.size());
					model.addAttribute("pageNum2", pageNum2);
					model.addAttribute("numOnPage2", numOnPage2);
					model.addAttribute("page2", page2);
					model.addAttribute("pageE2", new ArrayList<Integer>());
					model.addAttribute("x2", Pagination.paginationX(page2, numOnPage2));
					model.addAttribute("y2", Pagination.paginationY(myCancelList.size(), page2, numOnPage2));
					result = "managemyreg";
				} else {
					result = "managemyreg";
				}
			} else { // search none active ! Update list tour
				Integer num2 = 0;
				List<BookTour> myCancelList = userService.myCancelList(idUser);
				if (myCancelList.size() == 0) {
					num2 = myCancelList.size() / numOnPage2;
				} else {
					num2 = (myCancelList.size() / numOnPage2) + 1;
				}
				if (page2 <= num2) {
					List<Integer> pageNum2 = IntStream.rangeClosed(1, num2).boxed().collect(Collectors.toList());
					model.addAttribute("myCancelReg", new BookTour());
					model.addAttribute("myCancelList", myCancelList);
					model.addAttribute("myNumCancelReg", myCancelList.size());
					model.addAttribute("pageNum2", pageNum2);
					model.addAttribute("numOnPage2", numOnPage2);
					model.addAttribute("page2", page2);
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
				if (myBookTourList.size() == 0) {
					num3 = myBookTourList.size() / numOnPage3;
				} else {
					num3 = (myBookTourList.size() / numOnPage3) + 1;
				}
				if (page3 <= num3) {
					List<Integer> pageNum3 = IntStream.rangeClosed(1, num3).boxed().collect(Collectors.toList());
					logger.info("Search active!");
					model.addAttribute("myBookTour", new BookTour());
					model.addAttribute("myBookTourList", myBookTourList);
					model.addAttribute("myNumBookTour", myBookTourList.size());
					model.addAttribute("pageNum3", pageNum3); // create number
					model.addAttribute("numOnPage3", numOnPage3);
					model.addAttribute("page3", page3);
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
				if (myBookTourList.size() == 0) {
					num3 = myBookTourList.size() / numOnPage3;
				} else {
					num3 = (myBookTourList.size() / numOnPage3) + 1;
				}
				if (page3 <= num3) {
					List<Integer> pageNum3 = IntStream.rangeClosed(1, num3).boxed().collect(Collectors.toList());
					model.addAttribute("myBookTour", new BookTour());
					model.addAttribute("myBookTourList", myBookTourList);
					model.addAttribute("myNumBookTour", myBookTourList.size());
					model.addAttribute("pageNum3", pageNum3);
					model.addAttribute("numOnPage3", numOnPage3);
					model.addAttribute("page3", page3);
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
	@RequestMapping(value = "undo/{idBT}")
	public String undoCancel(@PathVariable("idBT") Integer idBT, HttpSession session, ModelMap model) {
		userService.undoCancel(idBT);
		model.addAttribute("idUser", (int) session.getAttribute("idUser"));
		return "redirect:/managemyreg/{idUser}";
	}

	// Customer cancel registration tour
	@RequestMapping(value = "cancelall/{idBT}/{relationship}")
	public String cancelAllBookTour(@PathVariable("idBT") Integer idBT,
			@PathVariable("relationship") Integer relationship, HttpSession session, ModelMap model) {
		regInfoService.cancelAllBookTour(idBT, relationship);
		model.addAttribute("idUser", (int) session.getAttribute("idUser"));
		return "redirect:/managemyreg/{idUser}";
	}

	// Customer change your password
	@RequestMapping(value = "changepassword/{idUser}", method = RequestMethod.GET)
	public String showChangePassword(ModelMap model, @PathVariable("idUser") int idUser) {
		logger.info("Display change password form when user request!");
		User user = userService.searchUserById(idUser);
		if (user != null) {
			model.addAttribute("userData", user);
		} else {
			logger.info("Null Object!");
		}
		return "changepassword";
	}

	// Handle change my password form
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "changepassword/{idUser}", method = RequestMethod.POST)
	public String confirmChangePassword(ModelMap model, @PathVariable("idUser") int idUser,
			@ModelAttribute("userData") @Valid User user, BindingResult br, HttpSession session,
			@RequestParam String currentPass, @RequestParam String newPass, @RequestParam String comPass) {
		User user1 = userService.searchUserById(idUser);
		EncoderPassword ep = new EncoderPassword();
		if (currentPass.equals(ep.deCoded(user1.getPassword()))) {
			if (newPass.length() > 20 || newPass.length() < 8) {
				model.put("error", "Mật khẩu phải có ít nhất 8 ký tự và không quá 20 ký tự");
				return "changepassword";
			}
			if (newPass.equals(comPass)) {
				user1.setPassword(ep.enCoded(newPass));
				userService.editUser(user1);
				logger.info("Change password successfully!");
				if (session.getAttribute("roleId") != null) {
					return "redirect:/manageuser";
				} else {
					session.removeAttribute("user");
					session.removeValue("userName"); // Remove username value
					session.removeValue("fullName"); // Remove full name value
					session.removeValue("idUser"); // Remove idUser
					return "redirect:/changepasssucess";
				}
			} else {
				logger.info("The new password and confirm password is incorrect");
				model.put("confirmPass", "Nhập lại mật khẩu không đúng");
				return "changepassword";
			}
		} else {
			logger.info("The password is incorrect");
			model.put("wrongPass", "Mật khẩu không đúng");
			return "changepassword";
		}
	}

	// Forward to page change password success
	@RequestMapping(value = "changepasssucess", method = RequestMethod.GET)
	public String changePassSuccess() {
		return "changepasssucess";
	}
}
