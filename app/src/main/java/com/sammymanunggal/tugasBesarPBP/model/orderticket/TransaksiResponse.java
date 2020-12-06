package com.sammymanunggal.tugasBesarPBP.model.orderticket;

import android.text.method.TransformationMethod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsDAO;

import java.util.List;

public class TransaksiResponse {

    @SerializedName("data")
    @Expose
    private List<Transaksi> users=null;

    @SerializedName("message")
    @Expose
    private String message;

    public List<Transaksi> getUsers(){return users;}

    public String getMessage(){return message;}

    public void setNews(List<Transaksi> users){this.users=users;}

    public void setMessage(String message){this.message=message;}


}
