package com.sammymanunggal.tugasBesarPBP.model.admin;

import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.Preferensi;
import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.PreferensiResponse;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.Transaksi;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.TransaksiResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("news")
    Call<NewsResponse> getAllNews(@Query("data") String data);

    @GET("news/{id}")
    Call<NewsResponse> getNewsById(@Path("id") String id,
                                   @Query("data") String data);




    @POST("news")
    @FormUrlEncoded
    Call<NewsResponse> createNews(@Field("berita")String judul,
                                  @Field("tanggal") String tanggal,
                                  @Field("isi") String isi);

    @PUT("news/update/{id}")
    @FormUrlEncoded
    Call<NewsResponse> updateNews(@Path("id") String id, @Field("berita")String judul,
                                  @Field("tanggal") String tanggal,
                                  @Field("isi") String isi);

    @DELETE("news/delete/{id}")
    Call<NewsResponse> deleteNews(@Path("id") String id);

    // ======================= TRANSAKSI ===========================

    @GET("transaksi")
    Call<TransaksiResponse> getAllTransaksi(@Query("data") String data);

    @GET("transaksi/{id}")
    Call<TransaksiResponse> getTransaksiById(@Path("id") String id,
                                   @Query("data") String data);

    @POST("transaksi")
    @FormUrlEncoded
    Call<TransaksiResponse> createTransaksi(@Field("nama")String name,
                                  @Field("email") String email,
                                  @Field("museum") String museum,
                                  @Field("jumlah")String jumlah,
                                  @Field("harga") String harga);

    @PUT("transaksi/update/{email}")
    @FormUrlEncoded
    Call<TransaksiResponse> updateTransaksi(@Path("email") String email,
                                        @Field("name")String name,
                                            @Field("email") String email2,
                                      @Field("museum")String museum,
                                      @Field("jumlah") String jumlah,
                                      @Field("harga") String harga);

    @DELETE("transaksi/delete/{id}")
    Call<TransaksiResponse> deleteTransaksi(@Path("id") String id);

    // ======================= USER ===========================

    @GET("user")
    Call<PreferensiResponse> getAllUser(@Query("data") String data);

    @GET("user/{email}")
    Call<PreferensiResponse> getUserById(@Path("email") String email,
                                         @Query("data") String data);

    @POST("user")
    @FormUrlEncoded
    Call<PreferensiResponse> createUser(@Field("name")String name,
                                        @Field("email") String email,
                                        @Field("password") String password,
                                        @Field("alamat")String alamat,
                                        @Field("nohp") String nohp);

    @PUT("user/update/{email}")
    @FormUrlEncoded
    Call<PreferensiResponse> updateUser(@Path("email") String email,
                                        @Field("name")String name,

                                        @Field("alamat")String alamat,
                                        @Field("nohp") String nohp,
                                        @Field("image") String image);



}
