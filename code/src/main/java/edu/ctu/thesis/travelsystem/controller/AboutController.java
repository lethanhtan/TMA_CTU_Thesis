package edu.ctu.thesis.travelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/aboutus")
public class AboutController{
 
   @RequestMapping(method = RequestMethod.GET)
   public String aboutController() {

      return "aboutus";
   }

}
