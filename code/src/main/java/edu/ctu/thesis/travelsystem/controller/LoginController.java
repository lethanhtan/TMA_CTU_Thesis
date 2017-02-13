package edu.ctu.thesis.travelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("dang-nhap")
public class LoginController{
 
   @RequestMapping(method = RequestMethod.GET)
   public String loginController() {

      return "login";
   }

}
