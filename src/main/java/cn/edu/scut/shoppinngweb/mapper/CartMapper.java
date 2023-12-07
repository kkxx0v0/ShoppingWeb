package cn.edu.scut.shoppinngweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.edu.scut.shoppinngweb.entity.Cart;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    Cart selectByUserItem(long userId, long itemId);

    List<Cart> selectByUserId(long userId);

    int deleteByUserItem(long userId, long itemId);

    Integer selectCountByItemId(Long itemId);
}
