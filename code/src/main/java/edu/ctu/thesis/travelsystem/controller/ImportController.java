package edu.ctu.thesis.travelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.service.ImportDataService;

@Controller
public class ImportController {
	
	@Autowired
	ImportDataService importDataService;
	
	@RequestMapping(value = "/processExcel", method = RequestMethod.POST)
	public String processExcel(Model model, @RequestParam("file") MultipartFile excelfile) {
		importDataService.importExcel(excelfile);
		return "managetour";
	}
}
