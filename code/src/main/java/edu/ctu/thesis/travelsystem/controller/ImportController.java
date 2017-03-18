package edu.ctu.thesis.travelsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.model.Import;
import edu.ctu.thesis.travelsystem.service.ImportDataService;
import edu.ctu.thesis.travelsystem.service.UserService;

@Controller
public class ImportController {
	
	@Autowired
	ImportDataService importDataService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/processExcel", method = RequestMethod.POST)
	public String processExcel(Model model, @ModelAttribute("importData") Import objImp,@RequestParam("file") MultipartFile excelfile, 
			HttpSession session) {
		objImp.setOwner(session.getAttribute("userName").toString());
		importDataService.saveImport(objImp);
		importDataService.importExcel(excelfile);
		return "managetour";
	}
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.addAttribute("importData", new Import());
		return "import";
	}
}
