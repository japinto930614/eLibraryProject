package com.elibrary.mum.project.controller.viewctrl;



import com.elibrary.mum.project.model.User;
import com.elibrary.mum.project.model.UserType;
import com.elibrary.mum.project.service.IUserService;
import com.elibrary.mum.project.service.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
        return "redirect:/eLibraryFinal/secured/user/browse";
    }

    @GetMapping(value = "/edit/{id}")
//    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String editUserForm(@PathVariable Long id, Model model){
//    public String editUserForm( Model model){

        List<UserType> userTypes = userTypeService.getAllUserTypes();

//        model.addAttribute("user", new User());

        model.addAttribute("user", userService.findByUserNumber(id));

        model.addAttribute("userTypes", userTypes);

        return "secured/user/edit";
    }

    @PostMapping(value = "/edit")
//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("user") User user,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
            List<UserType> userTypes = userTypeService.getAllUserTypes();
            model.addAttribute("userTypes", userTypes);
            model.addAttribute("errors", result.getAllErrors());
            return "secured/user/edit";
        }

        user = userService.addUser(user);
        return "redirect:/eLibraryFinal/secured/user/edit";

    }



    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model){
        userService.delete(id);
        return "redirect:/eLibraryFinal/secured/user/browse";
    }

    @RequestMapping(value="/payoverdue/{id}", method = RequestMethod.GET)
    public String payOverDue(@PathVariable Long id, Model model){
        User user = userService.findByUserNumber(id);
        user.setOverduefine(0.0);
        userService.addUser(user);
        return "redirect:/eLibraryFinal/secured/user/browse";
    }


}
