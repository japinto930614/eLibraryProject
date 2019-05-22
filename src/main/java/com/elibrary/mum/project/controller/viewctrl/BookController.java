package com.elibrary.mum.project.controller.viewctrl;


import com.elibrary.mum.project.model.*;
import com.elibrary.mum.project.service.*;
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

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPositionService positionService;


    @GetMapping(value = "/browse")
    public ModelAndView displayListOfBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> books = bookService.getListOfBook();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("secured/book/browse");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String newBookForm(Model model) {

        List<Category> categories = categoryService.getAllCategories();

        List<Position> positions = positionService.getAllPositions();

        model.addAttribute("book", new Book());

        model.addAttribute("categories", categories);

        model.addAttribute("positions", positions);

        return "secured/book/new";
    }

    @PostMapping(value = "/new")
    public String addNewBook(@Valid @ModelAttribute("book") Book book,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Category> categories = categoryService.getAllCategories();

            List<Position> positions = positionService.getAllPositions();
            model.addAttribute("categories", categories);

            model.addAttribute("positions", positions);
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


}
