package cn.edu.scut.shoppinngweb.mapper;

import cn.edu.scut.shoppinngweb.entity.Item;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper extends BaseMapper<Item> {
    List<Item> selectAll();

    List<Item> selectByName(String itemName);
}

