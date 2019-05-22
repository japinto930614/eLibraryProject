package com.elibrary.mum.project.controller.viewctrl;


import com.elibrary.mum.project.model.Book;
import com.elibrary.mum.project.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/eLibraryFinal/secured/book")
public class BookController {

    @Autowired
    private IBookService bookService;




    @GetMapping(value = "/browse")
    public ModelAndView displayListOfBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> books = bookService.getListOfBook();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("secured/book/browse");
        return modelAndView;
    }

//    @GetMapping(value = "/new")
//    public String newBookForm(Model model) {
//
//        List<UserType> userTypes = userTypeService.getAllUserTypes();
//
//        model.addAttribute("user", new User());
//
//        model.addAttribute("userTypes", userTypes);
//
//        return "secured/user/new";
//    }
    @GetMapping(value="/new")
    public String BookAdditionForm(Model model){
        model.addAttribute("book", new Book());
        return "secured/book/new";
    }

//    @PostMapping(value = "/new")
//    public String addNewBook(@Valid @ModelAttribute("book") Book book,
//                             BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            List<UserType> userTypes = userTypeService.getAllUserTypes();
//            model.addAttribute("userTypes", userTypes);
//            return "secured/user/new";
//        }
//        user = userService.addUser(user);
//        return "redirect:/eLibraryFinal/secured/user/browse";
//    }
    @PostMapping(value = "/new")
    public String addNewBook(@Valid @ModelAttribute("book") Book book,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/book/new";
        }
        book = bookService.addBook(book);
        return "redirect:/eLibraryFinal/secured/book/browse";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("edit") Book book,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "secured/book/edit";
        }

        book = bookService.addBook(book);
        return "redirect:/eLibraryFinal/secured/book/browse";

    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.findOneBook(id));
        return "secured/book/edit";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model){
        bookService.removeBook(id);
        return "redirect:/eLibraryFinal/secured/book/browse";
    }
    @GetMapping(value = "/browseoverdue")
    public ModelAndView displayListOOverduefBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> books = bookService.getListOfBook();

        modelAndView.addObject("books", books);
        modelAndView.setViewName("secured/book/browseoverdue");
        return modelAndView;
    }


}
