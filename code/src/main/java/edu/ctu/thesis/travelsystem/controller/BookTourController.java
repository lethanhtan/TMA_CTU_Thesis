package edu.ctu.thesis.travelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("booktour")
public class BookTourController {
 
   @RequestMapping(method = RequestMethod.GET)
	public String booktourController() {

      return "booktour";
   }

}
