package com.tq.JDBC2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestORM {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T_Jobs> t_jobsList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from t_jobs");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String job_id = resultSet.getString("job_id");
                String job_title = resultSet.getString("job_title");
                String min_salary = resultSet.getString("min_salary");
                String max_salary = resultSet.getString("max_salary");
                //创建对象，封装查询到的零散数据
                T_Jobs t_jobs = new T_Jobs();
                t_jobs.setJob_id(job_id);
                t_jobs.setJob_title(job_title);
                t_jobs.setMin_salary(min_salary);
                t_jobs.setMax_salary(max_salary);
//                System.out.println(t_jobs);
                //每遍历一次得到对象，存放在集合里，方便后续的使用
                t_jobsList.add(t_jobs);
                //遍历集合
                for (T_Jobs t : t_jobsList) {
                    System.out.println(t);
                }
                //T_Jobs{job_id='AC_ACCOUNT', job_title='Public Accountant', min_salary='4200', max_salary='9000'}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(connection, preparedStatement, resultSet);
        }
    }
}
