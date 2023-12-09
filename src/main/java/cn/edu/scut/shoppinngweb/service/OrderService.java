package cn.edu.scut.shoppinngweb.service;

import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OrderService extends IService<Order> {
    Result newOrder(Long userId);

    Result finishOrder(Long id);

    Result getReport();

    Result getAllOrder();

}
