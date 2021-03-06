package com.tq.account;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService{
    //转账
    public void transfer(String fromNo,String pwd,String toNo,double money){//收参
        //接口引用指向实现类对象
        AccountDao accountDao= new AccountDaoImpl();
        //组织完善业务功能
        try {
            //调用DButils开启事务
            DBUtils.begin();

            //2.1验证fromNo是否存在
            Account account = accountDao.select(fromNo);
            if(account==null){
                throw new RuntimeException("卡号不存在");
            }
            //2.2验证fromNo的密码是否正确
            if(!account.getPassword().equals(pwd)){
                throw new RuntimeException("密码不正确");
            }
            //2.3验证余额是否充足
            if(account.getBalance() < money){
                throw new RuntimeException("余额不足");
            }
            //2.4验证toNo是否存在
            Account toAccount = accountDao.select(toNo);
            if(toAccount == null){
                throw new RuntimeException("对方卡号不存在");
            }
            //2.5减少fromNo的余额
            account.setBalance(account.getBalance()-money);
            accountDao.update(account);

            //假设出现异常 ArithmeticException
            //int a = 10/0;

            //2.6增加toNo的余额
            toAccount.setBalance(toAccount.getBalance()+money);
            accountDao.update(toAccount);
            System.out.println("转账成功");
            DBUtils.commit();
        } catch (RuntimeException e) {
            System.out.println("转账失败");
            DBUtils.rollback();
            e.printStackTrace();
        }
    }
}

