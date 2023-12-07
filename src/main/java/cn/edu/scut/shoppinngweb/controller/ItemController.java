package cn.edu.scut.shoppinngweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.entity.Item;
import cn.edu.scut.shoppinngweb.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping()
    public Result getAll(){
        return itemService.getAllItem();
    }

    @GetMapping("/{name}")
    public Result getItem(@PathVariable String name){
        return itemService.getItem(name);
    }

    @PostMapping()
    public Result insertItem(@RequestBody Item item){
        if (item.getId() != null) {
            return itemService.modifyItem(item);
        } else {
            return itemService.insertItem(item);
        }
    }

    @DeleteMapping()
    public Result deleteItem(@RequestBody Item item){
        return itemService.deleteItem(item.getId());
    }

    @PutMapping()
    public Result modifyItem(@RequestBody Item item){
        return itemService.modifyItem(item);
    }
}
