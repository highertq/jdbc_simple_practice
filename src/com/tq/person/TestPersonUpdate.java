package com.tq.person;

public class TestPersonUpdate {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person(3,"Mark",34,DateUtils.strToUtil("1988-06-01"),"man@xx.com","中国上海");
        int result = personDao.update(person);
        if(result==1) System.out.println("修改成功");
        else System.out.println("失败");
    }
}
