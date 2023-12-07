package cn.edu.scut.shoppinngweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    public Result newOrder(@CookieValue("user") Long userId){
        return orderService.newOrder(userId);
    }

    @PostMapping()
    public Result newOrder(@CookieValue("user") Long userId, @RequestBody List<Long> carts){
        return orderService.dhfidhf(userId);
    }

    @GetMapping("/{id}")
    public Result finishOrder(@PathVariable Long id){
        return orderService.finishOrder(id);
    }

    @GetMapping("/all")
    public Result getReport(){
        return orderService.getReport();
    }

    @GetMapping("/allOrder")
    public Result getAllOrder(){
        return orderService.getAllOrder();
    }
}
