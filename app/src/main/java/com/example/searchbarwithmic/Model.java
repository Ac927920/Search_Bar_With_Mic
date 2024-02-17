package com.example.searchbarwithmic;

public class Model {
    private String name;
    private String address;
    private String contactStatus;

    public Model(String name, String address, String contactStatus) {
        this.name = name;
        this.address = address;
        this.contactStatus = contactStatus;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactStatus() {
        return contactStatus;
    }
}
