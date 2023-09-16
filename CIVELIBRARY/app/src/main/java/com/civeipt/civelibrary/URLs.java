package com.civeipt.civelibrary;

public class URLs {
    private String URL;

    public String URLogin(){
        URL = "http://192.168.42.100/library/login.php";
        return URL;
    }

    public String URLSignUp(){
        URL = "http://192.168.42.100/library/registration.php";
        return URL;
    }

    public String URLProfile(){
        URL = "http://192.168.42.100/library/profileDisplay.php";
        return URL;
    }

    public String URLLoadBooks(){
        URL = "http://192.168.42.100/library/pdf_view.php";
        return URL;
    }

    public String URLPdfs(){
        URL = "http://192.168.42.100/library/books/";
        return URL;
    }

}
