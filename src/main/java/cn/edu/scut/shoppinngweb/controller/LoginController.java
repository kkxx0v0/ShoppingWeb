package cn.edu.scut.shoppinngweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = {
            "/",
            "/login"
    })
    public String login() {
        return "login.html";
    }

    @RequestMapping(value = "signup")
    public String signup() {
        return "signup.html";
    }
}

