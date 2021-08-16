package controller;

import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/home")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("/views/index.jsp");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("languagesArray",new String[] {"English" , "VietNamese", "Japan" , "Korea"});
        modelAndView.addObject("sizeArray", new int[] {25, 30, 40});
        modelAndView.addObject("spamArray", new String[] {"clear"});
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("email") User user) {
        ModelAndView modelAndView = new ModelAndView("/views/result.jsp");
        modelAndView.addObject("email" , user);
        return modelAndView;
    }
}
