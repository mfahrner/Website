package com.theironyard.charlotte.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mfahrner on 9/23/16.
 */
@Controller
public class WebsiteController {

    @RequestMapping (path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }

    @RequestMapping (path = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        return "about";
    }

    @RequestMapping (path = "/blog", method = RequestMethod.GET)
    public String blog(Model model) {
        return "blog";
    }

    @RequestMapping (path = "/resume", method = RequestMethod.GET)
    public String resume(Model model) {
        return "resume";
    }
}
