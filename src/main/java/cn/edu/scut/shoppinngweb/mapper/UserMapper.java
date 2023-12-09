package cn.edu.scut.shoppinngweb.mapper;

import cn.edu.scut.shoppinngweb.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectUserByName(String userName);
}
