package cn.edu.scut.shoppinngweb.service;

import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService extends IService<User> {

    Result login(User user, HttpServletResponse response);

    Result register(User user);

    Result getUsers();
}
