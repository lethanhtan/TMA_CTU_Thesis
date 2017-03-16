package edu.ctu.thesis.travelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("faq")
public class FaqController{
   @RequestMapping(method = RequestMethod.GET)
   public String faqController() {

      return "faq";
   }
}
