package com.sammymanunggal.tugasBesarPBP.model.admin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("news")
    Call<NewsResponse> getAllUser(@Query("data") String data);

    @GET("news/{id}")
    Call<NewsResponse> getUserById(@Path("id") String id,
                                   @Query("data") String data);




    @POST("news")
    @FormUrlEncoded
    Call<NewsResponse> createUser(@Field("berita")String judul,
                                  @Field("tanggal") String tanggal,
                                  @Field("isi") String isi);

    @POST("news/update/{id}")
    @FormUrlEncoded
    Call<NewsResponse> updateUser(@Path("id") String id, @Field("berita")String judul,
                                  @Field("tanggal") String tanggal,
                                  @Field("isi") String isi);

    @POST("news/delete/{id}")
    Call<NewsResponse> deleteUser(@Path("id") String id);

}
