package edu.ctu.thesis.travelsystem.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.TourService;

@Controller
public class ManageDataController {

	@Autowired
	TourService tourService;

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView showFormData(@RequestParam(value = "nameFile", required = false) String nameFile,
			@RequestParam(value = "exportList", required = false) String exportList,
			@RequestParam(value = "Date1", required = false) @DateTimeFormat(pattern = "mm/dd/yyyy") Date Date1,
			@RequestParam(value = "Date2", required = false) @DateTimeFormat(pattern = "mm/dd/yyyy") Date Date2,
			@RequestParam(value = "exportType", required = false) String exportType) {
		ModelAndView model = new ModelAndView();
		List<Tour> listTours = tourService.listTour();
		String failedName = "Bạn phải nhập tên file!";
		String failedDate = "Bạn phải nhập ngày hợp lệ!";
		if (exportType != null) {
			if (exportType.equals("Pdf")) {
				if (nameFile.length() != 0 && Date1 != null && Date2 != null) {//1
					if (Date1.after(Date2)) {
						model.addObject("failedDate", failedDate);
						model.setViewName("export");
					} else {
						model.addObject("fileName", nameFile);
						model.addObject("listTours", listTours);
						model.setViewName("pdfView");
					}
				} else if (nameFile.length() != 0 && Date1 == null && Date2 == null) {//2
					model.addObject("listTours", listTours);
					model.setViewName("pdfView");
				} else if (nameFile.length() != 0 && (Date1 == null || Date2 == null)) {//3
					model.addObject("failedDate", failedDate);
					model.setViewName("export");
				} else {//4
					model.addObject("failedName", failedName);
					model.setViewName("export");
				}
				
			} else {
				model.addObject("listTours", listTours);
				model.setViewName("excelView");
			}
		}
		return model;
	}
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public ModelAndView showImport(){
		ModelAndView model = new ModelAndView();
		model.setViewName("/import");
		return model;
	}
}
