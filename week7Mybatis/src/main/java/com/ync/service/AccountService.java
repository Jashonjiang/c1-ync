package com.ync.service;

import com.ync.entity.Account;
import com.ync.mapper.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountService {

    private AccountDao accountDao;

    /**
     * 初始化,由于没有学spring,所以有点臃肿
     * @throws IOException
     */
    //初始化,反向代理生成一个持久层的对象,这部分有些麻烦，学了springboot这块就会十分简洁
    public AccountService() throws IOException {
        //1.读取mybatis的配置文件
        InputStream in = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession session = factory.openSession(true);//自动提交事务
        //5.使用 SqlSession 创建 dao 接口的代理对象
        accountDao = session.getMapper(AccountDao.class);
    }

    // 1.添加账户信息
    public void insert(Account account) {
        accountDao.insert(account);
    }
    // 2.查询所有account
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    // 3.通过id删除一条账户记录
    public void deleteById(String id) {
        accountDao.deleteById(id);
    }

    // 4.通过id查询一条账户记录
    public Account findById(String id) {
        return accountDao.findById(id);
    }

    // 5.根据id更新账户信息
    public void update(Account account) {
        accountDao.update(account);
    }
}
