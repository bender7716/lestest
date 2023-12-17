package org.example.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String list() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
