package com.civeipt.civelibrary;

import android.os.Bundle;

import java.net.HttpURLConnection;

public class profileDetails {
    private String firstname, secondname, lastname, programme, email, phonenumber, reg_no;

    public profileDetails() {

    }

    public profileDetails(String firstname, String secondname, String lastname, String programme, String email, String phonenumber, String reg_no) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.programme = programme;
        this.email = email;
        this.phonenumber = phonenumber;
        this.reg_no = reg_no;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }
}
