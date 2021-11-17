package com.tq.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonServiceImpl {
    //注册
    public void register(Person person){
        //1.查询用户是否存在
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person1 = personDao.select(person.getName());
        //2.不存在则注册
        if(person1==null){
            int result = personDao.insert(person);
            if(result==1) System.out.println("注册成功");
            if(result==0) System.out.println("注册失败");
        }
        //3.存在,返回已注册
        if(person1!=null){
            System.out.println("用户已注册");
        }
    }
}
