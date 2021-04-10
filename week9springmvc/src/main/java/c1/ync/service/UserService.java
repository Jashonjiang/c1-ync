package c1.ync.service;

import c1.ync.dao.UserMapper;
import c1.ync.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    //用户注册
    @Transactional
    public boolean register(User user) {
        //调用 dao 层的方法
        //TODO：在注册的时候取出手机号去判断此手机号是否被注册（拓展功能，学员 自己去实现)
        if(userMapper.findByMobile(user.getMobile()) != null){
            return false;
        }else{
            userMapper.register(user);
            return true;
        }
    }

    //用户登录
    public boolean login(String mobile, String password) {
        //调用 dao 层的方法
        User user = userMapper.login(mobile, password);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    //查询用户信息
    public User findById(int id) {
        //调用 dao 层的方法
        return userMapper.findById(id);
    }

    //查询用户信息
    public User findByMobile(String mobile){
        return userMapper.findByMobile(mobile);
    }
}
