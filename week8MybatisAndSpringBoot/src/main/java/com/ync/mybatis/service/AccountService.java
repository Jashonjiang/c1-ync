package com.ync.mybatis.service;

import com.ync.mybatis.entity.Account;
import com.ync.mybatis.mapper.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    //查询所有
    public List<Account> findAll(){
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    // 通过id删除记录
    public void deleteByPrimaryKey(String id){
        accountDao.deleteByPrimaryKey(id);
    }

    // 插入记录
    public void insert(Account record){
        accountDao.insert(record);
    }

    // 通过id查找对象
    public Account selectByPrimaryKey(String id){
        Account account = accountDao.selectByPrimaryKey(id);
        return account;
    }

    // 更新Account
    public void updateByPrimaryKey(Account record){
        accountDao.updateByPrimaryKey(record);
    }

    //转账
    public void zhuanzhang(String id1, String id2, Integer money){
        Account account1 = accountDao.selectByPrimaryKey(id1);
        Account account2 = accountDao.selectByPrimaryKey(id2);
        account1.setMoney(account1.getMoney()-money);
        account1.setUpdatetime(new Date());
        account2.setMoney(account2.getMoney()+money);
        account2.setUpdatetime(new Date());
        accountDao.updateByPrimaryKey(account1);
        accountDao.updateByPrimaryKey(account2);
    }
}
