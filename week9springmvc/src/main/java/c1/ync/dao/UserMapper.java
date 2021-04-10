package c1.ync.dao;

import c1.ync.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //用户注册
    boolean register(User user);

    //用户登录
    User login(String mobile, String password);

    //查询用户信息
    User findById(int id);

    User findByMobile(String mobile);

}
