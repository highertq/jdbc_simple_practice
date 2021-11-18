package com.tq.account;

/**
 * 实体需要的几点：数据私有变量、有参和无参构造函数、getter和setter、tostring方法
 */
public class Account {
    private String cardNo;
    private String password;
    private String name;
    private double balance;

    public Account(String cardNo, String password, String name, double balance) {
        this.cardNo = cardNo;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }

    public Account() {
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardNo='" + cardNo + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
