package com.sammymanunggal.tugasBesarPBP.model.SignUpIn;

public class SignUpUser {

    public String nameUser, address, phoneNumber, email;

    public SignUpUser(){

    }
    public SignUpUser(String nameUser, String address, String phoneNumber,String email ){
        this.nameUser= nameUser;
        this.address = address;
        this.phoneNumber= phoneNumber;
        this.email=email;
    }
}

