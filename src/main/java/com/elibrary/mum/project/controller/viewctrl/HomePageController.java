package com.elibrary.mum.project.controller.viewctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = {"/","/eLibraryFinal", "/eLibraryFinal/home"})
    public String displayHomePage() {
        return "public/home/index";
    }
}
