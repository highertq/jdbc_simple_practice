package com.tq.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestJdbc {
    public static void main(String[] args)throws Exception{
        //1.注册驱动 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.创建连接
        String url = "jdbc:mysql://localhost/company";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,user,password);
        //判断是否连接成功
        if(connection!=null){
            System.out.println("连接成功！");
        }else{
            System.out.println("false");
        }
        //3.获取连接后的对象
        Statement statement = connection.createStatement();

        //4.编写SQL语句
        String sql = "insert into t_jobs(JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY)values('JAVA_mgr','JAVA_Lecturer',4000,12000)";//注意DML语句中字符串是单引号

        //5.接收结果
        int result = statement.executeUpdate(sql);
        System.out.println(result);//执行DML语句 增删改时，返回受影响行数（INT类型）

        //6.释放资源 先开后关
        statement.close();
        connection.close();
    }

}
