package cn.edu.scut.shoppinngweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CartController {
    @RequestMapping("/cart")
    public String cart(){
        return "cart.html";
    }
}
