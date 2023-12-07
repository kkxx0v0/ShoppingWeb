package cn.edu.scut.shoppinngweb.controller;

import cn.edu.scut.shoppinngweb.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.service.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping()
    public Result getCart(@CookieValue("user") Long userId){
        return cartService.getCart(userId);
    }

    @GetMapping("/{itemId}")
    public Result addCart(@CookieValue("user") Long userId, @PathVariable Long itemId){
        return cartService.addCart(userId, itemId);
    }

    @GetMapping("/all")
    public Result getViewReport(){
        return cartService.getViewReport();
    }

    @DeleteMapping("/{itemId}")
    public Result deleteCart(@CookieValue("user") Long userId, @PathVariable Long itemId){
        return cartService.deleteCart(userId, itemId);
    }

}
