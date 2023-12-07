package cn.edu.scut.shoppinngweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.edu.scut.shoppinngweb.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectUserByName(String userName);
}
