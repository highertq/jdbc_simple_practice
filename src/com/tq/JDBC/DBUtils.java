package com.tq.JDBC;

import java.sql.*;

/**
 * 获取连接
 * 释放资源
 */
public class DBUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //1.获取连接
    public static Connection getconnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //2.释放资源
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
