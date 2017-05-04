package com.example.sangameswaran.nammachennai;

/**
 * Created by Sangameswaran on 24-03-2017.
 */

public class UserModelClass {

    String name,password;
    UserModelClass(String name,String password)
    {
        this.name=name;
        this.password=password;
    }
    UserModelClass()
    {
        //default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
