package com.ffse2401.lab_b01;

import com.fasterxml.jackson.annotation.JsonProperty;

//I am POJO
public class PersonData {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("hkid_number")
    private String hkid;

    public PersonData(String firstName,String lastName,String hkid){
        this.firstName = firstName;
        this.lastName = lastName;
        this.hkid = hkid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHkid() {
        return hkid;
    }

    public void setHkid(String hkid) {
        this.hkid = hkid;
    }
}
