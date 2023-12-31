package cn.edu.scut.shoppinngweb.service.impl;

import cn.edu.scut.shoppinngweb.dto.Result;
import cn.edu.scut.shoppinngweb.entity.User;
import cn.edu.scut.shoppinngweb.mapper.UserMapper;
import cn.edu.scut.shoppinngweb.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Result login(User user, HttpServletResponse response) {
        User u = userMapper.selectUserByName(user.getUsername());
        if (u != null) {
            if (u.getPassword().equals(user.getPassword())) {
                response.addCookie(new Cookie("user", u.getId().toString()));
                Result ok = Result.ok();
                ok.setErrorMsg(u.getRole());
                return ok;
            } else {
                return Result.fail("密码错误");
            }
        } else {
            return Result.fail("用户不存在");
        }
    }

    @Override
    @Transactional
    public Result register(User user) {
        User u = userMapper.selectUserByName(user.getUsername());
        if (u != null) {
            return Result.fail("用户已存在");
        } else {
            user.setBalance(new BigDecimal("100"));
            boolean b = save(user);
            if (b) {
                return Result.ok("注册成功");
            } else {
                return Result.fail("注册失败");
            }
        }
    }

    @Override
    @Transactional
    public Result getUsers() {
        return Result.ok(userMapper.selectList(null));
    }
}
