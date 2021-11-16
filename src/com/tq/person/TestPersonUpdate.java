package com.tq.person;

public class TestPersonUpdate {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person(1,"Mark",18,null,"fuck@qq.com","中南海");
        int result = personDao.update(person);
        if(result==1) System.out.println("修改成功");
        else System.out.println("失败");
    }
}
