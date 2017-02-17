package edu.ctu.thesis.travelsystem.hibernate;

import java.util.ArrayList;
import antlr.collections.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ctu.thesis.travelsystem.entity.Account;

@Controller
@RequestMapping(value = "/dang-ky")
public class RegisterController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        Account accountForm = new  Account();    
        model.put("accountForm", accountForm);
         
        /*List<String> professionList = new ArrayList<>();
        professionList.add("Developer");
        professionList.add("Designer");
        professionList.add("IT Manager");
        model.put("professionList", professionList);*/
         
        return "signup";
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") Account account,
            Map<String, Object> model) {
         
        // implement your own registration logic here...
         
        // for testing purpose:
        System.out.println("username: " + account.getIdAcc());
        System.out.println("password: " + account.getPassAcc());
        System.out.println("email: " + account.getEmailAcc());
        //System.out.println("birth date: " + account.getBirthDate());
         
        return "RegistrationSuccess";
    }
}