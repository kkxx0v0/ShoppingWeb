package cn.edu.scut.shoppinngweb.service.impl;

import cn.edu.scut.shoppinngweb.VO.ViewReport;
import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.entity.Cart;
import cn.edu.scut.shoppinngweb.entity.Item;
import cn.edu.scut.shoppinngweb.mapper.CartMapper;
import cn.edu.scut.shoppinngweb.mapper.ItemMapper;
import cn.edu.scut.shoppinngweb.mapper.UserMapper;
import cn.edu.scut.shoppinngweb.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Result addCart(Long userId, Long itemId) {
        Cart cart = cartMapper.selectByUserItem(userId, itemId);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
            cart.setItemId(itemId);
            cart.setCount(1);
            if (save(cart)) {
                return Result.ok("成功加入一件商品,商品数量：1");
            }
        } else {
            cart.setCount(cart.getCount() + 1);
            if (updateById(cart)) {
                return Result.ok("成功加入一件商品，商品数量：" + cart.getCount());
            }
        }
        return Result.fail("加入失败");
    }

    @Override
    @Transactional
    public Result getCart(Long userId) {
        List<Cart> carts = cartMapper.selectByUserId(userId);
        List<Item> items = new ArrayList<>();
        for (Cart cart : carts) {
            Item item = itemMapper.selectById(cart.getItemId());
            item.setCount(cart.getCount());
            items.add(item);
        }
        return Result.ok(items, (long) items.size());
    }

    @Override
    @Transactional
    public Result deleteCart(Long userId, Long itemId) {
        int i = cartMapper.deleteByUserItem(userId, itemId);
        if (i > 0) {
            return Result.ok("删除成功");
        } else {
            return Result.fail("删除失败");
        }
    }

    @Override
    @Transactional
    public Result getViewReport() {
        List<Cart> carts = cartMapper.selectList(null);
        List<ViewReport> viewReports = new ArrayList<>();
        for (Cart cart : carts) {
            ViewReport viewReport = new ViewReport();
            viewReport.setViewCount(cart.getCount());
            viewReport.setName(userMapper.selectById(cart.getUserId()).getUsername());
            Item item = itemMapper.selectById(cart.getItemId());
            viewReport.setPrice(item.getPrice());
            viewReport.setItemName(item.getName());
            viewReports.add(viewReport);
        }
        return Result.ok(viewReports);
    }
}
