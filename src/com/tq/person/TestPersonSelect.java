package com.tq.person;

public class TestPersonSelect {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = personDao.select(1);
        System.out.println(person);
    }
}
