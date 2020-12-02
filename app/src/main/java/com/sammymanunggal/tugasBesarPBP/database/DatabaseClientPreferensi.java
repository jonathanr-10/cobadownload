package com.sammymanunggal.tugasBesarPBP.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClientPreferensi {
    private Context context2;
    private static DatabaseClientPreferensi databaseClientPreferensi;

    private AppDatabasePreferensi database;

    private DatabaseClientPreferensi(Context context){
        this.context2 =context;
        database = Room.databaseBuilder(context, AppDatabasePreferensi.class, "preferensi").build();

    }

    public static synchronized DatabaseClientPreferensi  getInstance2(Context context){
        if (databaseClientPreferensi ==null){
            databaseClientPreferensi =new DatabaseClientPreferensi (context);
        }
        return databaseClientPreferensi;
    }

    public AppDatabasePreferensi getDatabasePreferensi(){
        return database;
    }

}
