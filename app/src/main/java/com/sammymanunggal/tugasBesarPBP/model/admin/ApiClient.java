package com.sammymanunggal.tugasBesarPBP.model.admin;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClient {
    public static final String BASE_URL ="https://kelompokgpbp.masuk.web.id/public/api/";
    public static Retrofit retrofit = null;
    public static Retrofit getClient(){
        if(retrofit ==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}

