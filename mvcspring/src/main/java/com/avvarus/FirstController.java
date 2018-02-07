package com.avvarus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class FirstController {

//
//    @RequestMapping (value = "/hello", method = RequestMethod.GET)
//    public ModelAndView sayHello () {
//
//        ModelAndView modelAndView = new ModelAndView ("hello");
//        modelAndView.addObject ("greeting", "Hello World !!!");
//
//        ArrayList arrayList = new ArrayList ();
//        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate (FormatStyle.FULL);
//        LocalDate date = LocalDate.now ();
//        LocalDateTime dateTime = LocalDateTime.now ();
//        modelAndView.addObject ("date", dateTime.format (formatter));
//        return modelAndView;
//    }
//
//
//    @RequestMapping (value = "/hello1", method = RequestMethod.GET)
//    public String sayHello1 (Model model) {
//
//        model.addAttribute ("message", "vijay devarakonda (Arujn Reddy) exclusive Interview");
//        return "hello1";
//    }

    @RequestMapping (value = "/welcome", method = RequestMethod.GET)
    public ModelAndView sayWelcome (Principal principal) {

        System.out.println ("Welcome to the world of Spring Security !!");

        ModelAndView modelAndView = new ModelAndView ("hello1");
        modelAndView.addObject ("username", principal.getName ());
        modelAndView.addObject ("message", principal.getName () + " has been autheticated !!");

        System.out.println ("------------------------------------->");
        //model.addAttribute ("username", principal.getName ());
        //model.addAttribute ("message", principal.getName () + " has been authenticated !!");
        // return "hello1";
        return modelAndView;
    }

    @RequestMapping (value = "/logout", method = RequestMethod.GET)
    public String sayLogout (Model model) {
        System.out.println ("Directing to logout page !!");
        return "login";
    }

    @RequestMapping (value = "/*", method = RequestMethod.GET)
    public String sayHome (Model model) {
        System.out.println ("Directing to home page !!");
        return "home";
    }
}
