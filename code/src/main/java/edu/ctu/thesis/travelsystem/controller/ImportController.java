package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.extra.Authentication;
import edu.ctu.thesis.travelsystem.model.Import;
import edu.ctu.thesis.travelsystem.service.ImportDataService;
import edu.ctu.thesis.travelsystem.service.UserService;

@Controller
public class ImportController {
	
	public static int status;
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	ImportDataService importDataService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	Authentication authenication;
	
	@RequestMapping(value = "/processExcel", method = RequestMethod.POST)
	public String processExcel(Model model, @ModelAttribute("importData") Import objImp,
			@RequestParam("file") MultipartFile excelfile,
			@RequestParam("listType") String listType,
			HttpSession session) {
		logger.info("Processing for import file: " + listType);
		String jsp = "import";
		try {
			if (excelfile.getSize() > 1000000) {
				model.addAttribute("failedSize", "Vui lòng chọn file có kích thước dưới 1Mb");
			}
		} catch (Exception e) {
			logger.info("Exception size limit!");
			return "import";
		}
		
		importDataService.importExcel(excelfile, listType);
		if (status == 1) {
			model.addAttribute("formatError", "Lỗi định dạng file!");
			return "import";
		}
		objImp.setOwner(session.getAttribute("fullName").toString());
		objImp.setImportType(listType);
		importDataService.saveImport(objImp);
		if (listType.equals("Danh sách tour")) {
			jsp = "redirect:/managetour";
		}
		else if (listType.equals("Danh sách người dùng")) {
			jsp = "redirect:/manageuser";
		}
		return jsp;
	}
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest request, HttpSession session) {
		if (!authenication.authenticationUser(request.getRequestURI(), (int) session.getAttribute("roleId"))) {
			logger.info("Authenticaion user permission!");
			logger.info("Current uri: " + request.getRequestURI());
			return "forbidden";
		}
		model.addAttribute("importData", new Import());
		return "import";
	}
}
