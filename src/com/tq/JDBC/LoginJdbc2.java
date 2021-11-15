package com.tq.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginJdbc2 {
    public static void main(String[] args)throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();

        Connection connection = DBUtils.getconnection();

        //预编译 PreparedStatement继承自Statement
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username=? and password=?;");
        //为参数下标赋值
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        System.out.println(preparedStatement);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){ //查询到了数据
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败");
        }
        DBUtils.closeAll(connection,preparedStatement,resultSet);
    }
}
