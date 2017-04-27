package edu.ctu.thesis.travelsystem.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ctu.thesis.travelsystem.extra.Pagination;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.FilterService;
import edu.ctu.thesis.travelsystem.service.TourService;

@Controller
public class HomeController {
	@Autowired
	private TourService tourService;
	@Autowired
	private FilterService filterService;

	private static final Logger logger = Logger.getLogger(HomeController.class);
	private static int numOnPage = 5;

	@RequestMapping(value = { "/", "home" }, method = RequestMethod.GET)
	public String redirectController(ModelMap model, HttpSession session,
			@RequestParam(required = false, value = "valueSearch") String valueSearch,
			@RequestParam(required = true, defaultValue = "1", value = "page") Integer page,
			@RequestParam(required = false, value = "numOn") Integer numOn,
			@RequestParam(required = false, value = "filterPrice") String filterPrice,
			@RequestParam(required = false, value = "filterSale") String filterSale) {
		logger.info("Handle home request!");
		model.addAttribute("tour", new Tour());
		model.addAttribute("current", new Date());
		logger.info("Handle when managetour request from admin!");
		String result = null; // view page mapping
		try {
			if (!numOn.equals(null)) {
				numOnPage = numOn; // numOn
			}
		} catch (Exception e) {
			logger.info("None select number of tour on page!");
		}
		try {
			model.addAttribute("searchedValue", valueSearch);
			if (valueSearch != null) {
				List<Tour> tourList = tourService.listTourByValue(valueSearch);
				Integer num = 0;
				if ((tourList.size() % numOnPage) == 0) {
					num = tourList.size() / numOnPage;
				} else {
					num = (tourList.size() / numOnPage) + 1;
				}
				if (page <= num) {
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					logger.info("Search active!");
					model.addAttribute("tour", new Tour());
					model.addAttribute("tourList", tourList);
					model.addAttribute("numTour", tourList.size());
					model.addAttribute("pageNum", pageNum); // create number
					model.addAttribute("numOnPage", numOnPage);
					model.addAttribute("page", page);
					model.addAttribute("pageE", new ArrayList<Integer>()); // create
					model.addAttribute("x", Pagination.paginationX(page, numOnPage));
					model.addAttribute("y", Pagination.paginationY(tourList.size(), page, numOnPage));
					result = "home";
				} else {
					result = "home";
				}
			}

			// search none active ! Update list tour
			if (valueSearch == null && filterPrice == null && filterSale == null) {
				Integer num = 0;
				List<Tour> tourList = tourService.showTourList();
				if ((tourList.size() % numOnPage) == 0) {
					num = tourList.size() / numOnPage;
				} else {
					num = (tourList.size() / numOnPage) + 1;
				}
				if (page <= num) {
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					model.addAttribute("tour", new Tour());
					model.addAttribute("tourList", tourList); // create
					model.addAttribute("numTour", tourList.size()); // create
					model.addAttribute("pageNum", pageNum); // create number
					model.addAttribute("numOnPage", numOnPage);
					model.addAttribute("page", page);
					model.addAttribute("pageE", new ArrayList<Integer>()); // create
					model.addAttribute("x", Pagination.paginationX(page, numOnPage));
					model.addAttribute("y", Pagination.paginationY(tourList.size(), page, numOnPage));
					result = "home";
				} else {
					result = "home";
				}
			}

			
			// Tour list filter by price
			if (filterPrice != null) {
				Integer num = 0;
				List<Tour> tourListByPrice = filterService.tourListByFilterPrice(filterPrice);
				if ((tourListByPrice.size() % numOnPage) == 0) {
					num = tourListByPrice.size() / numOnPage;
				} else {
					num = (tourListByPrice.size() / numOnPage) + 1;
				}
				if (page <= num) {
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					model.addAttribute("tour", new Tour());
					model.addAttribute("tourList", tourListByPrice); // create
					model.addAttribute("numTour", tourListByPrice.size()); // create
					model.addAttribute("pageNum", pageNum); // create number
					model.addAttribute("numOnPage", numOnPage);
					model.addAttribute("page", page);
					model.addAttribute("pageE", new ArrayList<Integer>()); // create
					model.addAttribute("x", Pagination.paginationX(page, numOnPage));
					model.addAttribute("y", Pagination.paginationY(tourListByPrice.size(), page, numOnPage));
					result = "home";
				} else {
					result = "home";
				}
			}

			// Tour list filter by sale
			if (filterSale != null) {
				Integer num = 0;
				List<Tour> tourListBySale = filterService.tourListByFilterSale(filterSale);
				if ((tourListBySale.size() % numOnPage) == 0) {
					num = tourListBySale.size() / numOnPage;
				} else {
					num = (tourListBySale.size() / numOnPage) + 1;
				}
				if (page <= num) {
					List<Integer> pageNum = IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
					model.addAttribute("tour", new Tour());
					model.addAttribute("tourList", tourListBySale); // create
					model.addAttribute("numTour", tourListBySale.size()); // create
					model.addAttribute("pageNum", pageNum); // create number
					model.addAttribute("numOnPage", numOnPage);
					model.addAttribute("page", page);
					model.addAttribute("pageE", new ArrayList<Integer>()); // create
					model.addAttribute("x", Pagination.paginationX(page, numOnPage));
					model.addAttribute("y", Pagination.paginationY(tourListBySale.size(), page, numOnPage));
					result = "home";
				} else {
					result = "home";
				}
			}
		} catch (Exception e) {
			logger.error("Occured ex", e);
			result = "forbidden";
		}
		return result;
	}
}