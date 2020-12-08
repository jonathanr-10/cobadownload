package com.sammymanunggal.tugasBesarPBP.model.orderticket;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Transaksi implements Serializable {
    @SerializedName("id")
    public int id;


    @SerializedName("nama")
    public String fullName;

    @SerializedName("emailUser")
    public String emailUser;

    @SerializedName("museum")
    public String museumName;

    @SerializedName("jumlah")
    public int total;

    @SerializedName("harga")
    public double harga;

    //@ColumnInfo(name = "status")
    //public String status;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getMuseumName(){
        return museumName;
    }

    public void setMuseumName(String museumName){
        this.museumName = museumName;
    }

    public int getTotal(){
        return total;
    }

    public void setTotal(int total){
        this.total = total;
    }

    public double getHarga(){
        return harga;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    /*
    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

     */


}
