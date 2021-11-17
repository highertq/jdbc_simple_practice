package com.tq.person;

public class TestPersonServiceRegister {
    public static void main(String[] args) {
        Person person = new Person("MRsLiu",20,DateUtils.strToUtil("2001-01-01"),"xx@xx.com","中国北京");
        PersonServiceImpl personService = new PersonServiceImpl();
        personService.register(person);
    }
}
