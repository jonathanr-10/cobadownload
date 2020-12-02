package com.sammymanunggal.tugasBesarPBP.model.admin;

import com.google.gson.annotations.SerializedName;

public class NewsDAO {
    @SerializedName("id")
    private String id;

    @SerializedName("berita")
    private String berita;

    @SerializedName("tanggal")
    private String tanggal;

    @SerializedName("isi")
    private String isi;


    public NewsDAO(String id, String berita, String tanggal, String isi){
        this.id = id;
        this.berita = berita;
        this.tanggal= tanggal;
        this.isi = isi;

    }

    public String getId(){return id;}

    public String getBerita(){return berita;}

    public String getTanggal(){return tanggal;}

    public String getIsi(){return isi;}



    public void setId(String id){this.id=id;}

    public void setBerita(String berita){this.berita=berita;}

    public void setIsi(String isi){this.isi=isi;}

    public void setTanggal(String tanggal){this.tanggal=tanggal;}




}
