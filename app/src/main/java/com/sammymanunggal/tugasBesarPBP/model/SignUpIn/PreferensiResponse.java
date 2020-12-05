package com.sammymanunggal.tugasBesarPBP.model.SignUpIn;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsDAO;

import java.util.List;

public class PreferensiResponse {
    @SerializedName("data")
    @Expose
    private List<Preferensi> users=null;

    @SerializedName("message")
    @Expose
    private String message;

    public List<Preferensi> getUsers(){return users;}

    public String getMessage(){return message;}

    public void setNews(List<Preferensi> users){this.users=users;}

    public void setMessage(String message){this.message=message;}

}
