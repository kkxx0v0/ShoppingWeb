package cn.edu.scut.shoppinngweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletResponse;
import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.entity.User;

public interface UserService extends IService<User> {

    Result login(User user, HttpServletResponse response);
    Result register(User user);

    Result getUsers();
}
