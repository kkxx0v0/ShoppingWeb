package cn.edu.scut.shoppinngweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.entity.Cart;

public interface CartService extends IService<Cart> {
    Result addCart(Long userId, Long itemId);

    Result getCart(Long userId);

    Result deleteCart(Long userId, Long itemId);

    Result getViewReport();
}
