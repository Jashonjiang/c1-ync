package com.ync.mybatis.mapper;

import com.ync.mybatis.entity.Account;

import java.util.List;

public interface AccountDao {
    // 查询所有记录
    List<Account> findAll();

    // 通过id删除记录
    void deleteByPrimaryKey(String id);

    // 插入记录
    void insert(Account record);

    // 通过id查找对象
    Account selectByPrimaryKey(String id);

    // 更新Account
    void updateByPrimaryKey(Account record);
}
