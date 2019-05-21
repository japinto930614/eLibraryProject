package com.elibrary.mum.project.controller.viewctrl;



import com.elibrary.mum.project.model.User;
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

//    @Autowired
//    private ISupplierService supplierService;

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfSuppliers() {
        ModelAndView modelAndView = new ModelAndView();
//        List<Supplier> suppliers = supplierService.getAllSuppliers();
//        modelAndView.addObject("suppliers", suppliers);
        modelAndView.setViewName("secured/user/browse");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String newSupplierForm(Model model) {
//        model.addAttribute("user", new Supplier());
        return "secured/user/new";
    }

    @PostMapping(value = "/new")
    public String addNewSupplier(@Valid @ModelAttribute("user") User user,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/user/new";
        }
//        user = supplierService.addNewSupplier(user);
        return "redirect:/srm/secured/user/browse";
    }




}
