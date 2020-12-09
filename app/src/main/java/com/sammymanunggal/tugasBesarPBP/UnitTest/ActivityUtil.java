package com.sammymanunggal.tugasBesarPBP.UnitTest;

import android.content.Context;
import android.content.Intent;

import com.sammymanunggal.tugasBesarPBP.model.MainActivity;
import com.sammymanunggal.tugasBesarPBP.model.admin.EditNewsActivity;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsDAO;

public class ActivityUtil {
    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startMainActivity() {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    public void startUserProfile(NewsDAO newsDAO){
        Intent i = new Intent(context, EditNewsActivity.class);
        i.putExtra("id",newsDAO.getId());
        i.putExtra("berita",newsDAO.getBerita());
        i.putExtra("tanggal",newsDAO.getTanggal());
        i.putExtra("isi",newsDAO.getIsi());
        context.startActivity(i);
    }
}
