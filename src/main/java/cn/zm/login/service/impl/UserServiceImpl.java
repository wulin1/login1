package cn.zm.login.service.impl;

import cn.zm.login.dao.UserDAO;
import cn.zm.login.dto.RegisterDTO;
import cn.zm.login.dto.ResultDTO;
import cn.zm.login.model.User;
import cn.zm.login.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author zfitness
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Override
    public User register(RegisterDTO registerDTO) {
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda();
        queryWrapper.eq(User::getEmail, registerDTO.getEmail());
        User user = userDAO.selectOne(queryWrapper);

        if (user == null) {
            user = new User();
            user.setEmail(registerDTO.getEmail());
            user.setName(registerDTO.getName());
            user.setPassword(registerDTO.getPassword());
            user.setToken(UUID.randomUUID().toString());
            userDAO.insert(user);

        }

        return user;
    }

    @Override
    public User login(String email, String password) {
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda();
        queryWrapper.eq(User::getEmail, email)
                .eq(User::getPassword, password);
        User user = userDAO.selectOne(queryWrapper);

        return user;
    }
}
