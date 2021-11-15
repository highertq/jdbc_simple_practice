package com.tq.JDBC2;

import java.sql.Connection;

public class TestDBUtils {
    public static void main(String[] args) {
        Connection connection = DBUtils.getConnection();
        System.out.println(connection);
    }
}
