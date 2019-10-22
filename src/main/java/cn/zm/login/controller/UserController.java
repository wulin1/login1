package cn.zm.login.controller;

import cn.zm.login.dao.UserDAO;
import cn.zm.login.dto.RegisterDTO;
import cn.zm.login.dto.ResultDTO;
import cn.zm.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * @author zfitness
 */
@Controller
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping(value = {"/", "/index"})
    public String profile() {
        return "profile";
    }

    @PostMapping("/modify")
    @ResponseBody
    public Object modify(@RequestBody RegisterDTO registerDTO, HttpServletRequest request) {
        System.out.println(registerDTO);
        User user = new User();
        user.setName(registerDTO.getName());
        user.setToken(UUID.randomUUID().toString());
        user.setId(registerDTO.getId());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        int i = userDAO.updateById(user);
        ResultDTO resultDTO = ResultDTO.errorOf(i, "修改成功");
        request.getSession().setAttribute("user", user);
        return resultDTO;
    }
}
