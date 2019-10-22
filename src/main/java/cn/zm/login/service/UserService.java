package cn.zm.login.service;

import cn.zm.login.dto.RegisterDTO;
import cn.zm.login.dto.ResultDTO;
import cn.zm.login.model.User;

/**
 * @author zfitness
 */
public interface UserService {



    /**
     * 根据输出的用户注册
     * @param registerDTO
     * @return
     */
    User register(RegisterDTO registerDTO);

    /**
     * 登录
     * @param email  用户的邮箱
     * @param password  用户的密码
     * @return  结果
     */
    User login(String email, String password);
}
