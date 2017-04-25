package edu.ctu.thesis.travelsystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Export;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.BookTourService;
import edu.ctu.thesis.travelsystem.service.ExportDataService;
import edu.ctu.thesis.travelsystem.service.TourService;

@Controller
public class ExportController {

	private static final Logger logger = Logger.getLogger(ExportController.class);

	@Autowired
	TourService tourService;

	@Autowired
	ExportDataService exportDataService;

	@Autowired
	BookTourService bookTourService;

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView showFormData(@RequestParam(value = "nameFile", required = false) String nameFile,
			@RequestParam(value = "exportList", required = false) String exportList,
			@RequestParam(value = "Date1", required = false) @DateTimeFormat(pattern = "mm/dd/yyyy") Date Date1,
			@RequestParam(value = "Date2", required = false) @DateTimeFormat(pattern = "mm/dd/yyyy") Date Date2,
			@RequestParam(value = "exportType", required = false) String exportType, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Export objExport = new Export();
		List<Tour> listTours = tourService.listTour();
		model.addObject("listTours", listTours);
		List<BookTour> listBookTours = bookTourService.bookTourList();
		String failedName = "Bạn phải nhập tên export!";
		String failedDate = "Bạn phải nhập ngày hợp lệ!";
		if (exportType != null) {
			if (exportType.equals("Pdf")) {
				if (nameFile.length() != 0 && Date1 != null && Date2 != null) {// 1
					logger.info("Export data from: " + Date1 + " to " + Date2);
					if (Date1.after(Date2)) {
						model.addObject("failedDate", failedDate);
						model.setViewName("export");
					} else {
						model.addObject("fileName", nameFile);
						model.addObject("listTours", listTours);
						model.addObject("listBookTours", listBookTours);
						model.addObject("exportList", exportList);
						objExport.setOwner(session.getAttribute("userName").toString());
						objExport.setFileType(exportType);
						objExport.setExportType(exportList);
						exportDataService.saveExport(objExport);
						model.setViewName("pdfView");
					}
				} else if (nameFile.length() != 0 && Date1 == null && Date2 == null) {// 2
					logger.info("Export all list!");
					model.addObject("listTours", listTours); // List object for
																// export list
																// tour
					model.addObject("listBookTours", listBookTours); // List
																		// object
																		// for
																		// export
																		// list
																		// book
																		// tour
					model.addObject("exportList", exportList); // Name list
																// export
					objExport.setOwner(session.getAttribute("userName").toString());
					objExport.setFileType(exportType);
					objExport.setExportType(exportList);
					exportDataService.saveExport(objExport);
					model.setViewName("pdfView");

					return model;
				} else if (nameFile.length() != 0 && (Date1 == null || Date2 == null)) {// 3
					model.addObject("failedDate", failedDate);
					model.setViewName("export");
				} else {// 4
					model.addObject("failedName", failedName);
					model.setViewName("export");
				}

			} else {// type excel
				if (nameFile.length() != 0 && Date1 != null && Date2 != null) {// 1
					if (Date1.after(Date2)) {
						model.addObject("failedDate", failedDate);
						model.setViewName("export");
					} else {
						model.addObject("fileName", nameFile);
						model.addObject("listTours", listTours);
						model.addObject("listBookTours", listBookTours);
						model.addObject("exportList", exportList);
						objExport.setOwner(session.getAttribute("userName").toString());
						objExport.setFileType(exportType);
						objExport.setExportType(exportList);
						exportDataService.saveExport(objExport);
						model.setViewName("excelView");
					}
				} else if (nameFile.length() != 0 && Date1 == null && Date2 == null) {// 2
					model.addObject("listTours", listTours);
					model.addObject("listBookTours", listBookTours);
					model.addObject("exportList", exportList);
					objExport.setOwner(session.getAttribute("userName").toString());
					objExport.setFileType(exportType);
					objExport.setExportType(exportList);
					exportDataService.saveExport(objExport);
					model.setViewName("excelView");
				} else if (nameFile.length() != 0 && (Date1 == null || Date2 == null)) {// 3
					model.addObject("failedDate", failedDate);
					model.setViewName("export");
				} else {// 4
					model.addObject("failedName", failedName);
					model.setViewName("export");
				}
			}
		}
		return model;
	}

	@RequestMapping(value = "export/{idTour}", method = RequestMethod.GET)
	public ModelAndView exportData(@PathVariable("idTour") int idTour, HttpSession session) {
		ModelAndView model = new ModelAndView();
		// Export objExport = new Export();
		model.addObject("exportList", "Tour");
		model.addObject("listBookTours", bookTourService.listBookTourById(idTour));
		// objExport.setOwner(session.getAttribute("userName").toString());
		// objExport.setFileType("Pdf");
		// objExport.setExportType("Registration list");
		// exportDataService.saveExport(objExport);
		model.setViewName("pdfView");
		return model;
	}
}
