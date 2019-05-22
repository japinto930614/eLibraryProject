package com.elibrary.mum.project.controller.viewctrl;

import com.elibrary.mum.project.model.*;
import com.elibrary.mum.project.service.impl.BookCopyService;
import com.elibrary.mum.project.service.impl.CheckOutRecordService;
import com.elibrary.mum.project.service.impl.CheckinRecordService;
import com.elibrary.mum.project.service.impl.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/eLibraryFinal/secured/bookcopy")
public class BookCopyController {

    @Autowired
    private BookCopyService bookCopyService;

    @Autowired
    private CheckOutRecordService checkOutRecordService;

    @Autowired
    private CheckinRecordService checkinRecordService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/browseoverdue")
    public ModelAndView displayListOfOverdueBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<BookCopy> bookCopies = bookCopyService.getAllBookCopies();

        List<BookCopy> overdues = new ArrayList<BookCopy>();

        for(BookCopy bookCopy : bookCopies){
            int size = bookCopy.getCheckOutRecords().size();
            if(size > 0) {
                CheckOutRecord checkOutRecord = bookCopy.getCheckOutRecords().get(size - 1);
                if (checkOutRecord.getOverdueDate().isBefore(LocalDate.now()) ||
                checkOutRecord.getOverdueDate().isEqual(LocalDate.now())) {
                    overdues.add(bookCopy);
                }
            }
        }

        for(Iterator<BookCopy> it = overdues.iterator(); it.hasNext();) {
            BookCopy s = it.next();
            int size = s.getCheckinRecords().size();
            if(size > 0){

                CheckinRecord checkinRecord = s.getCheckinRecords().get(size - 1);
                if(checkinRecord.getCheckInDate().isBefore(LocalDate.now()) ||
                        checkinRecord.getCheckInDate().isEqual(LocalDate.now())){

                        it.remove();

                }
            }

        }



        modelAndView.addObject("bookCopies", overdues);
        modelAndView.setViewName("secured/bookcopy/browseoverdue");
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

    @RequestMapping(value="/check", method= RequestMethod.POST, params="action=out")
    public String checkOut(@RequestParam(value = "usernumber", required = false) String usernumber,
                           @RequestParam(value = "bookCopyNumber", required = false)String bookCopyNumber, Model model){


        List<User> users = userService.getAllUsers().stream()
                    .filter(x -> x.getUserNumber() == Long.parseLong(usernumber)).collect(Collectors.toList());

        List<BookCopy> bookCopies = bookCopyService.getAllBookCopies().stream()
                    .filter(x -> x.getBookCopyNumber() == Long.parseLong(bookCopyNumber)).collect(Collectors.toList());

        BookCopy bookCopy = bookCopies.get(0);
        if(!users.isEmpty()) {
            User user = users.get(0);
            CheckOutRecord checkOutRecord = new CheckOutRecord(user, bookCopy);
            checkOutRecordService.addCheckOutRecord(checkOutRecord);
        }

        return "redirect:/eLibraryFinal/secured/bookcopy/browse";
    }


    @RequestMapping(value="/check", method= RequestMethod.POST, params="action=in")
    public String checkIn(@RequestParam(value = "usernumber", required = false) String usernumber,
                           @RequestParam(value = "bookCopyNumber", required = false)String bookCopyNumber, Model model){


        List<User> users = userService.getAllUsers().stream()
                .filter(x -> x.getUserNumber() == Long.parseLong(usernumber)).collect(Collectors.toList());

        List<BookCopy> bookCopies = bookCopyService.getAllBookCopies().stream()
                .filter(x -> x.getBookCopyNumber() == Long.parseLong(bookCopyNumber)).collect(Collectors.toList());

        BookCopy bookCopy = bookCopies.get(0);
        if(!users.isEmpty()) {
            User user = users.get(0);
            CheckinRecord checkinrecord = new CheckinRecord( bookCopy, user);
            checkinRecordService.addCheckinRecord(checkinrecord);
        }

        return "redirect:/eLibraryFinal/secured/bookcopy/browse";
    }
}
