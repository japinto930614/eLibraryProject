package com.elibrary.mum.project.controller.viewctrl;



import com.elibrary.mum.project.model.User;
import com.elibrary.mum.project.service.impl.UserService;
import com.elibrary.mum.project.service.impl.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/eLibraryFinal/secured/user")
public class UserController {
    @Autowired
     private UserService userService;
    @Autowired
     private UserTypeService userTypeService;

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfSuppliers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users",  userService.getAllUsers());
        modelAndView.setViewName("secured/user/browse");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String newSupplierForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userTypes",userTypeService.getAllUserTypes());
        return "secured/user/new";
    }

    @PostMapping(value = "/new")
    public String addNewSupplier(@Valid @ModelAttribute("user") User user,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("userTypes",userTypeService.getAllUserTypes());
            return "secured/user/new";
        }
        user = userService.addUser(user);
        return "redirect:/secured/user/browse";
    }




}
