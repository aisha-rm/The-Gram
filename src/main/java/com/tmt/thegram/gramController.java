package com.tmt.thegram;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class gramController {

    private List<User> userList = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/submitForm")
    public String handleSubmit(@Valid User user, BindingResult bindingResult){
        if (user.getFirstName().equals(user.getLastName())){
            bindingResult.rejectValue("lastName", "", "Please enter valid data");
        }

        if(bindingResult.hasErrors()) return "sign-up";
        
        return "redirect:results";
    }

    @GetMapping("/results")
    public String getResult(Model model){
        model.addAttribute("users", userList);
        return "results";
    }
    
}
