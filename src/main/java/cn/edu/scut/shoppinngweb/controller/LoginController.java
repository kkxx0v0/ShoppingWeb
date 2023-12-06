package cn.edu.scut.shoppinngweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class LoginController {

    @RequestMapping(value = {
            "/",
            "/login"
    })
    public String login(){
        return "login.html";
    }
    @RequestMapping(value = "signup")
    public String signup(){
        return "signup.html";
    }
}

