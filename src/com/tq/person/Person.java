package com.tq.person;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private int age;
    private Date bornDate;
    private String email;
    private String address;

    public Person() {
    }

//    public Person(int id) {
//        this.id = id;
//    }

    public Person(String name, int age, Date bornDate, String email, String address) {
        this.name = name;
        this.age = age;
        this.bornDate = bornDate;
        this.email = email;
        this.address = address;
    }

    public Person(int id, String name, int age, Date bornDate, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bornDate = bornDate;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bornDate=" + bornDate +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
