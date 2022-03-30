package com.example.kubsu.controller;

import com.example.kubsu.model.User;
import com.example.kubsu.repository.UserRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public String form(Model model, User form) {
        model.addAttribute("form", form);
        return "form";
    }

    @PostMapping("/form")
    public String fillForm(@Valid @ModelAttribute("form") User form, BindingResult bindingResult, Model model) {
        model.addAttribute("form", form);
        if (bindingResult.hasErrors()) {
            List<FieldError> err=bindingResult.getFieldErrors();

            for(FieldError e:err){
                System.out.println("Error on object ---> "+e.getObjectName()+" on field ---> "+e.getField()+". Message ---> "+e.getDefaultMessage());
            }
            return "form";
        }
        userRepository.save(form);
        return "result";
    }
}
