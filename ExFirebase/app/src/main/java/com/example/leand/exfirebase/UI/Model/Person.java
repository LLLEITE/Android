package com.example.leand.exfirebase.UI.Model;

public class Person {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person" +
                "\nName: " + name +
                "\nAge: " + age;
    }
}
