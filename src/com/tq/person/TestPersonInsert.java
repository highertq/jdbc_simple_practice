package com.tq.person;

public class TestPersonInsert {
    public static void main(String[] args) {
        //测试新增
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person("Marry",22,DateUtils.strToUtil("1999-01-01"),"woman@xx.com","中国广东");
        int result = personDao.insert(person);
        if(result==1) System.out.println("新增成功");
        else System.out.println("新增失败");
    }
}
