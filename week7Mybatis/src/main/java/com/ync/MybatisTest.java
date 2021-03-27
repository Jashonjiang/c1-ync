package com.ync;

import com.ync.entity.Account;
import com.ync.service.AccountService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //插入数据
        AccountService accountService = new AccountService();
        Account jack = new Account("1","jack",1000, new Date(), new Date());
        Account tom = new Account("2","tom",500, new Date(), new Date());
        Account mick = new Account("3","mick",800, new Date(), new Date());
        Account lily = new Account("4","lily",100, new Date(), new Date());
//        accountService.insert(jack);
//        accountService.insert(tom);
//        accountService.insert(mick);
//        accountService.insert(lily);
        //查询所有
        List<Account> accounts = accountService.findAll();
        for(Account account : accounts){
            System.out.println(account);
        }
        //通过id查找
        Account account = accountService.findById("2");
        System.out.println(account);
        //通过id删除
        accountService.deleteById("4");
        //更新account，把mick的账户金额变成1500
        mick.setMoney(1500);
        mick.setUpdatetime(new Date());
        accountService.update(mick);

        //转账，jack向tom转账500
        jack.setMoney(jack.getMoney()-500);
        jack.setUpdatetime(new Date());
        tom.setMoney(tom.getMoney()+500);
        tom.setUpdatetime(new Date());
        accountService.update(jack);
        accountService.update(tom);


    }
}
