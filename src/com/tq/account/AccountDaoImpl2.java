package com.tq.account;

import java.util.List;

/**
 * 假设是一个新的实现类V2.0，功能更强大、代码更简洁
 * DAO接口定义，为了灵活性
 */
public class AccountDaoImpl2 implements AccountDao{

    @Override
    public int insert(Account account) {
        return 0;
    }

    @Override
    public int delete(String cardNo) {
        return 0;
    }

    @Override
    public int update(Account account) {
        return 0;
    }

    @Override
    public Account select(String cardNo) {
        return null;
    }

    @Override
    public List<Account> selectAll() {
        return null;
    }
}
