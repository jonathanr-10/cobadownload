package com.sammymanunggal.tugasBesarPBP.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;

public class Museum implements Serializable {

    public String nama;
    public String penjelasan;
    public String hariBuka;
    public String jamBuka;
    public double harga;
    public String imgURL;
    public String alamat;



    public Museum(String nama, String penjelasan, double harga, String imgURL, String hariBuka, String jamBuka, String alamat) {
        this.hariBuka = hariBuka;
        this.alamat = alamat;
        this.jamBuka = jamBuka;
        this.nama = nama;
        this.penjelasan = penjelasan;
        this.harga = harga;
        this.imgURL = imgURL;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHariBuka() {
        return hariBuka;
    }

    public void setHariBuka(String hariBuka) {
        this.hariBuka = hariBuka;
    }

    public String getJamBuka() {
        return jamBuka;
    }

    public void setJamBuka(String jamBuka) {
        this.jamBuka = jamBuka;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getpenjelasan() {
        return penjelasan;
    }

    public void setpenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public double getharga() {
        return harga;
    }

    public void setharga(double harga) {
        this.harga = harga;
    }


    public String getStringHarga(){return String.valueOf(harga);}

    public void setStringIpk(String harga){
        if(!harga.isEmpty()){
            this.harga = Double.parseDouble(harga);
        }else{
            this.harga = 0;
        }

    }
    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @BindingAdapter("profileImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).apply(new RequestOptions())
                .into(view);
    }
}
