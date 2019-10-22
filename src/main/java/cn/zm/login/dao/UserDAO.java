package cn.zm.login.dao;

import cn.zm.login.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zfitness
 */
@Mapper
@Component
public interface UserDAO extends BaseMapper<User> {
}
