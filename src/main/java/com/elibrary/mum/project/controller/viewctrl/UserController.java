package com.elibrary.mum.project.controller.viewctrl;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value = "/eLibraryFinal/secured/supplier")
public class UserController {
/*
    @Autowired
    private ISupplierService supplierService;

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfSuppliers() {
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.setViewName("secured/supplier/browse");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String newSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "secured/supplier/new";
    }

    @PostMapping(value = "/new")
    public String addNewSupplier(@Valid @ModelAttribute("supplier") Supplier supplier,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/supplier/new";
        }
        supplier = supplierService.addNewSupplier(supplier);
        return "redirect:/srm/secured/user/browse";
    }



 */
}
