package com.example.navigationdrawerhometask;

public class Members {
    public String Name;
    public int Age;
    public Boolean Status;

    public Members(String name, int age, Boolean status) {
        Name = name;
        Age = age;
        Status = status;
    }

    public Members() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }
}
