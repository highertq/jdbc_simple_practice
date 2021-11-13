package com.tq.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteJdbc {
    public static void main(String[] args)throws Exception{
        //1.驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接
        String url = "jdbc:mysql://localhost/company";
        Connection connection = DriverManager.getConnection(url,"root","123456");
        //3.判断
        if(connection!=null) System.out.println("连接成功");
        //4.获取对象
        Statement statement = connection.createStatement();
        //5.操作
        String sql = "delete from t_jobs where JOB_ID='JAVA_mgr'";
        int result = statement.executeUpdate(sql);
        if(result==1) System.out.println("删除成功");
        //6.关闭
        statement.close();
        connection.close();
    }
}
