package com.ync.mapper;

import com.ync.entity.Account;

import java.util.List;

public interface AccountDao {

    // 1查询所有记录
     List<Account> findAll();

    // 2通过id删除记录
     void deleteById(String id);

    // 3插入记录
     void insert(Account record);

    // 4通过id查找对象
     Account findById(String id);

    // 5更新Account
     void update(Account record);
}
