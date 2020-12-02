package com.sammymanunggal.tugasBesarPBP.model.admin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {
    @SerializedName("data")
    @Expose
    private List<NewsDAO> users=null;

    @SerializedName("message")
    @Expose
    private String message;

    public List<NewsDAO> getUsers(){return users;}

    public String getMessage(){return message;}

    public void setNews(List<NewsDAO> users){this.users=users;}

    public void setMessage(String message){this.message=message;}

}
