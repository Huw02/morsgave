package org.example.morbirthday.model;

import java.time.LocalDate;


public class Dinner {
    private String name;
    private String email;


    public Dinner(String name, String email, String date){
        this.name = name;
        this.email = email;

    }
    public Dinner(){

    }
    public Dinner(String name, String email){
        this.name= name;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
