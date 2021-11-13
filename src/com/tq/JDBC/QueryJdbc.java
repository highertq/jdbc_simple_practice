package com.tq.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryJdbc {
    public static void main(String[] args)throws Exception {
        //1.驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/company","root","123456");
        //3.judge
        if(connection!=null) System.out.println("sucess");
        //4.statement
        Statement statement = connection.createStatement();
        //5.operate
        ResultSet resultSet = statement.executeQuery("select * from t_jobs");
        while(resultSet.next()){ //判断下一行是否有数据
            String id = resultSet.getString("JOB_ID"); //获取列值
            String title = resultSet.getString(2);
            int min = resultSet.getInt("MIN_SALARY");
            int max = resultSet.getInt(4);
            System.out.println(id+"\t"+title+"\t"+min+"\t"+max);
        }
        //6.close
        resultSet.close();
        statement.close();
        connection.close();
    }
}
