//package com.sammymanunggal.tugasBesarPBP.database;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.Preferensi;
//
//import java.util.List;
//
//@Dao
//public interface PreferensiDao {
//    @Query("SELECT * FROM Preferensi")
//    List<Preferensi> getAll();
//
//    @Query("SELECT * FROM Preferensi WHERE email=:email")
//    Preferensi find(String email);
//
//    @Insert
//    void insert(Preferensi Preferensi);
//
//    @Update
//    void update(Preferensi preferensi);
//
////    @Query("UPDATE Preferensi SET nama= :nama, address= :address, phoneNumber= :phoneNumber,imgURI= :imgURI WHERE email= :email")
////    void update(String nama, String address, String phoneNumber, String imgURI,String email);
//
//    @Delete
//    void delete(Preferensi Preferensi);
//}
