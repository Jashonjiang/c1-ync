package com.ync.mybatis.controller;

import com.ync.mybatis.entity.Account;
import com.ync.mybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@ResponseBody
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/all")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @RequestMapping("/account/selectByPrimaryKey")
    public Account selectByPrimaryKey(String id){
        return accountService.selectByPrimaryKey("1");
    }

    @RequestMapping("/account/deleteByPrimaryKey")
    public String deleteByPrimaryKey(String id){
        accountService.deleteByPrimaryKey("3");
        return "delete successfully!";
    }

    @RequestMapping("/account/insert")
    public String insert(Account record){
        accountService.insert(new Account("4", "lily", 1000, new Date(), new Date()));
        return "insert successfully!";
    }

    @RequestMapping("/account/updateByPrimaryKey")
    public String updateByPrimaryKey(Account record){
        accountService.updateByPrimaryKey(new Account("2", "tom", 1500, null, new Date()));
        return "update successfully!";
    }

    @RequestMapping("/account/zhuanzhang")
    public String zhuanzhang(String id1, String id2, Integer money){
        accountService.zhuanzhang("2", "1", 500);
        return "zhuanzhang successfully!";
    }
}
