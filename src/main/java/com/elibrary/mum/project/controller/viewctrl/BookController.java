package com.elibrary.mum.project.controller.viewctrl;


import com.elibrary.mum.project.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/eLibraryFinal/secured/book")
public class BookController {

   /* @Autowired
    private IProductService productService;

    @Autowired
    private ISupplierService supplierService;*/

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfBooks() {
        ModelAndView modelAndView = new ModelAndView();
//        List<Product> products = productService.getAllProducts();
//        modelAndView.addObject("products", products);
        modelAndView.setViewName("secured/book/browse");
        return modelAndView;
    }

    @GetMapping(value = "/browseoverdue")
    public ModelAndView displayListOfOverdues() {
        ModelAndView modelAndView = new ModelAndView();
//        List<Product> products = productService.getAllProducts();
//        modelAndView.addObject("products", products);
        modelAndView.setViewName("secured/book/browseoverdue");
        return modelAndView;
    }

    @GetMapping(value = "/new")
//    public ModelAndView newProductForm(Model model) {
    public String newProductForm(Model model) {

//        List<Supplier> suppliers = supplierService.getAllSuppliers();
//        model.addAttribute("product", new Product());
//        model.addAttribute("suppliers", suppliers);
        return "secured/product/new";
    }

    @PostMapping(value = "/new")
    public String addNewProduct(@Valid @ModelAttribute("book") Book book,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
//            List<Supplier> suppliers = supplierService.getAllSuppliers();
//            model.addAttribute("suppliers", suppliers);
            return "secured/product/new";
        }
//        product = productService.addNewProduct(product);
        return "redirect:/srm/secured/product/browse";
    }

}
