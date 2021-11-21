package com.tq.account;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static final Properties PROPERTIES = new Properties();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    static {
        InputStream is = DBUtils.class.getResourceAsStream("/db.properties");
        try {
            PROPERTIES.load(is);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获得连接
    public static Connection getConnection() {
        Connection connection = threadLocal.get();//将当前线程中绑定的Connection对象赋值给connection
        try {
            if(connection==null){
                connection = DriverManager.getConnection(PROPERTIES.getProperty("url"), PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
                threadLocal.set(connection);//把连接存在当前线程共享中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //开启事务
    public static void begin(){
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public static void commit(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,null,null);
        }
    }

    //事务回滚
    public static void rollback(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,null,null);
        }
    }


    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null) {
                connection.close();
                threadLocal.remove();//移除已关闭的connection对象
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
