package cn.edu.scut.shoppinngweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.entity.Item;

public interface ItemService extends IService<Item> {

    public Result getAllItem();

    Result insertItem(Item item);

    Result deleteItem(long id);

    Result modifyItem(Item item);

    Result getItem(String name);
}
