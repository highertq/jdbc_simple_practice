package com.tq.person;

public class TestPersonInsert {
    public static void main(String[] args) {
        //测试新增
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person("Gavin",18,null,"man99@qq.com","中国浙江");
        int result = personDao.insert(person);
        if(result==1) System.out.println("新增成功");
        else System.out.println("新增失败");
    }
}
