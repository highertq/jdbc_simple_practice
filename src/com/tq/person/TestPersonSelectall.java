package com.tq.person;

import java.util.List;

public class TestPersonSelectall {
    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        List<Person> personList = personDao.selectAll();
        for(Person person : personList){
            System.out.println(person);
        }
    }
}
