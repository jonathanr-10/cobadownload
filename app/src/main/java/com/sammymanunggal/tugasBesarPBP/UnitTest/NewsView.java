package com.sammymanunggal.tugasBesarPBP.UnitTest;

import com.sammymanunggal.tugasBesarPBP.model.admin.NewsDAO;

public interface NewsView {

    String getBerita();
    void showBeritaError(String message);

    String getTanggal();
    void showTanggalError(String message);

    String getIsi();
    void showIsiError(String message);

    void startMainActivity();

    void startEditNewsActivity(NewsDAO newsDAO);

    void showNewsError(String message);

    void showErrorResponse(String message);

}
