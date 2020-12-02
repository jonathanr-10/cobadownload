package com.sammymanunggal.tugasBesarPBP.model.orderticket;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;


    @ColumnInfo(name = "full_name")
    public String fullName;

    @ColumnInfo(name = "museum_name")
    public String museumName;

    @ColumnInfo(name = "total")
    public int total;

    @ColumnInfo(name = "harga")
    public int harga;

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

    public int getHarga(){
        return harga;
    }

    public void setHarga(int harga){
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
