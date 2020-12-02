package com.sammymanunggal.tugasBesarPBP.model.SignUpIn;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;
import java.io.Serializable;
@Entity
public class Preferensi implements Serializable {
    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nama")
    public String nama;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "email")
    public String emailPreferensi;

    @ColumnInfo(name = "password")
    public String passwordPreferensi;

    @ColumnInfo(name = "phoneNumber")
    public String phoneNumber;

    @ColumnInfo(name = "imgURI")
    public String imgURI;

    public String getImgURI() { return imgURI; }

    public void setImgURI(String imgURI) { this.imgURI = imgURI; }

    public String getNamePreferensi(){
        return nama;
    }

    public void setNamePreferensi(String nama){
        this.nama = nama;
    }


    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPassword(){
        return passwordPreferensi;
    }

    public void setPassword(String passwordPreferensi){
        this.passwordPreferensi = passwordPreferensi;
    }

    public String getEmailPreferensi(){
        return emailPreferensi;
    }

    public void setEmailPreferensi(String emailPreferensi){
        this.emailPreferensi = emailPreferensi;
    }

}
