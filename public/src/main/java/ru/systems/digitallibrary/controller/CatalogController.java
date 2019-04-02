package ru.systems.digitallibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CatalogController {
    @RequestMapping(value = "/")
    public ModelAndView landingPage() {
        return new ModelAndView("redirect:/catalog");
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ModelAndView showUserCreationForm() {
        ModelAndView modelAndView = new ModelAndView("books");
        return modelAndView;
    }
}
