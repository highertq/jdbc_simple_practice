package com.tq.person;

public class TestPersonDelete {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        int result = personDao.delete(1);
        if(result==1) System.out.println("修改成功");
        else System.out.println("失败");
    }
}
