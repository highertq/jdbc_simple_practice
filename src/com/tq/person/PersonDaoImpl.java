package com.tq.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * 增、删、改、查单个、查所有
 * 只做数据库访问操作，不参与逻辑判断
 */
public class PersonDaoImpl {
    //新增
    public int insert(Person person){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into person(name,age,borndate,email,address) values(?,?,?,?,?);";
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setDate(3,null);
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, person.getAddress());
            int result = preparedStatement.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,preparedStatement,null);
        }
        return 0;
    }

    //修改
    public int update(Person person){return 0;}
    //删除
    public int delete(int id){return 0;}
    //查单个
    public Person select(){return null;}
    //查所有
    public List<Person> selectAll(){return null;}
}
