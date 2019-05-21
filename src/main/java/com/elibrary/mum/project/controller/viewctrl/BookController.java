package com.elibrary.mum.project.controller.viewctrl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/eLibraryFinal/secured/product")
public class BookController {
/*
    @Autowired
    private IProductService productService;

    @Autowired
    private ISupplierService supplierService;

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfProducts() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.getAllProducts();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("secured/product/browse");
        return modelAndView;
    }

    @GetMapping(value = "/new")
//    public ModelAndView newProductForm(Model model) {
    public String newProductForm(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
//        modelAndView.addObject("suppliers", suppliers);
//        modelAndView.setViewName("secured/book/new");
        model.addAttribute("product", new Product());
        model.addAttribute("suppliers", suppliers);
//        return modelAndView;
        return "secured/product/new";
    }

    @PostMapping(value = "/new")
    public String addNewProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Supplier> suppliers = supplierService.getAllSuppliers();
            model.addAttribute("suppliers", suppliers);
            return "secured/product/new";
        }
        product = productService.addNewProduct(product);
        return "redirect:/srm/secured/book/browse";
    }


 */
}
