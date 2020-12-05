package com.sammymanunggal.tugasBesarPBP.model.SignUpIn;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
@Entity
public class Preferensi implements Serializable {
    @SerializedName("id")
    public int id;

    @SerializedName("nama")
    public String nama;

    @SerializedName("alamat")
    public String address;

    @SerializedName("email")
    public String emailPreferensi;

    @SerializedName("password")
    public String passwordPreferensi;

    @SerializedName("nohp")
    public String phoneNumber;

    @SerializedName("image")
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
