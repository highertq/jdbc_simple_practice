package com.tq.account;

public class AccountServiceImpl {
    //转账
    public void transfer(String fromNo,String pwd,String toNo,double money){//收参
        AccountDaoImpl accountDao= new AccountDaoImpl();
        //组织完善业务功能
        try {
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
            //2.6增加toNo的余额
            toAccount.setBalance(toAccount.getBalance()+money);
            accountDao.update(toAccount);
            System.out.println("转账成功");
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("转账失败");
        }
    }
}
