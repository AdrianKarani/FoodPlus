package com.foodplus.foodplus.Model;

public class DeliveryGuy {

    private String name;
    private String email;
    private int contacts;

    private String trainer;

    public DeliveryGuy(String name, String email, int contacts) {
        this.name = name;
        this.email = email;
        this.contacts = contacts;

    }

    //    Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //    Contacts
    public Integer getContacts() {
        return contacts;
    }

    public void setContacts(Integer contacts) {
        this.contacts = contacts;
    }
}

