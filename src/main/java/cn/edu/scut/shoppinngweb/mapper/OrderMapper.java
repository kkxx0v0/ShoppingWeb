package cn.edu.scut.shoppinngweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.edu.scut.shoppinngweb.entity.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}

