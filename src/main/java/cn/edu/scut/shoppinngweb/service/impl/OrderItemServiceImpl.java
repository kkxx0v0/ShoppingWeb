package cn.edu.scut.shoppinngweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import cn.edu.scut.shoppinngweb.entity.OrderItem;
import cn.edu.scut.shoppinngweb.mapper.OrderItemMapper;
import cn.edu.scut.shoppinngweb.service.OrderItemService;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {
}
