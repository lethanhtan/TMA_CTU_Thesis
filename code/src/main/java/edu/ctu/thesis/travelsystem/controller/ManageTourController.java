package edu.ctu.thesis.travelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("managetour")
public class ManageTourController {
 
   @RequestMapping(method = RequestMethod.GET)
   public String managetourController() {

      return "managetour";
   }
}
