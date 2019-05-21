package com.elibrary.mum.project.controller.viewctrl;



import com.elibrary.mum.project.model.User;
import com.elibrary.mum.project.model.UserType;
import com.elibrary.mum.project.service.IUserService;
import com.elibrary.mum.project.service.IUserTypeService;
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
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/eLibraryFinal/secured/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserTypeService userTypeService;

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.getAllUsers();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("secured/user/browse");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String newUserForm(Model model) {

        List<UserType> userTypes = userTypeService.getAllUserTypes();

        model.addAttribute("user", new User());

        model.addAttribute("userTypes", userTypes);

        return "secured/user/new";
    }

    @PostMapping(value = "/new")
    public String addNewUser(@Valid @ModelAttribute("user") User user,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<UserType> userTypes = userTypeService.getAllUserTypes();
            model.addAttribute("userTypes", userTypes);
            return "secured/user/new";
        }
        user = userService.addUser(user);
        return "redirect:/srm/secured/user/browse";
    }




}
