package c1.ync.controller;

import c1.ync.entity.User;
import c1.ync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户注册
    @RequestMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("name") String name,
                           @RequestParam("mobile") String mobile,
                           @RequestParam("sex") String sex,
                           @RequestParam("birthday") String birthday)
            throws Exception {
        //调用业务层方法
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setMobile(mobile);
        user.setSex(sex);
        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        user.setCreatetime(new Date());
        user.setUpdateTime(new Date());
        System.out.println(user);
        boolean flag = userService.register(user);
        if(flag){
            return "注册成功！！";
        }else {
            return "该手机已经被注册过！！";
        }
    }

    //用户登录
    @RequestMapping("/login")
    public String login(@RequestParam("mobile") String mobile,
                        @RequestParam("password") String password) {
        //调用业务层方法
        boolean flag = userService.login(mobile, password);
        if (flag) {
            return "登录成功";
        }
        return "用户名或密码错误";
    }

    //查询用户信息
    @RequestMapping("/findById")
    public User findById(@RequestParam("id") int id) {
        //调用业务层方法
        return userService.findById(id);
    }

    //查询用户信息
    @RequestMapping("/findByMobile")
    public User findByMobile(@RequestParam("mobile") String mobile) {
        //调用业务层方法
        return userService.findByMobile(mobile);
    }
}
