package com.tq.JDBC;

import java.sql.*;
import java.util.Scanner;

public class LoginJdbc {
    public static void main(String[] args)throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from users where username='"+name+"' and password='"+password+"'");

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
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
