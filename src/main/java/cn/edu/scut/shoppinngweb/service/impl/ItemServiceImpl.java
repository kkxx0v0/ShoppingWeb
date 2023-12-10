package cn.edu.scut.shoppinngweb.service.impl;

import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.entity.Item;
import cn.edu.scut.shoppinngweb.mapper.ItemMapper;
import cn.edu.scut.shoppinngweb.service.ItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    @Transactional
    public Result getAllItem() {
        List<Item> allItem = itemMapper.selectAll();
        return Result.ok(allItem, (long) allItem.size());
    }

    @Override
    @Transactional
    public Result getItem(String name) {
        List<Item> allItem = itemMapper.selectByName(name);
        return Result.ok(allItem, (long) allItem.size());
    }

    @Override
    public Result insertItem(Item item) {
        if (save(item)) {
            return Result.ok("插入成功");
        } else {
            return Result.fail("插入失败");
        }
    }

    @Override
    public Result deleteItem(long id) {
        if (removeById(id)) {
            return Result.ok("删除成功");
        } else {
            return Result.fail("删除失败");
        }
    }

    @Override
    public Result modifyItem(Item item) {
        if (updateById(item)) {
            return Result.ok("修改成功");
        } else {
            return Result.fail("修改失败");
        }
    }
}
