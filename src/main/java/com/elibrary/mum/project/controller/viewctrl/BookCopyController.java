package com.elibrary.mum.project.controller.viewctrl;

import com.elibrary.mum.project.model.Book;
import com.elibrary.mum.project.model.BookCopy;
import com.elibrary.mum.project.model.CheckOutRecord;
import com.elibrary.mum.project.service.impl.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookCopyController {

    @Autowired
    private BookCopyService bookCopyService;

    @GetMapping(value = "/browseoverdue")
    public ModelAndView displayListOfOverdueBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<BookCopy> bookCopies = bookCopyService.getAllBookCopies();
        List<BookCopy> overdues = new ArrayList<BookCopy>();
        for(BookCopy bookCopy : bookCopies){
            for(CheckOutRecord checkOutRecord : bookCopy.getCheckOutRecords()){
                if(checkOutRecord.getOverdureDate().compareTo(LocalDate.now())>15){
                    overdues.add(bookCopy);
                }
            }
        }
        modelAndView.addObject("bookCopies", overdues);
        modelAndView.setViewName("secured/book/browseoverdue");
        return modelAndView;
    }

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfBookCopies() {
        ModelAndView modelAndView = new ModelAndView();
        List<BookCopy> bookCopies = bookCopyService.getAllBookCopies();
        modelAndView.addObject("bookCopies", bookCopies);
        modelAndView.setViewName("secured/bookcopy/browse");
        return modelAndView;
    }

    @GetMapping(value = "/search")
    public ModelAndView displayListSearchedBooks(@RequestParam(value = "search", required = false) String q, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<BookCopy> bookCopies = bookCopyService.getAllBookCopies().stream()
                .filter(x -> x.getBookCopyNumber() == Long.parseLong(q))
                .collect(Collectors.toList());
        modelAndView.addObject("bookCopies", bookCopies);
        modelAndView.setViewName("secured/bookcopy/browse");
        return modelAndView;
    }
}
