package com.sammymanunggal.tugasBesarPBP.UnitTest;

import com.sammymanunggal.tugasBesarPBP.model.admin.NewsDAO;

public interface NewsCallback {
    void onSuccess(boolean value, NewsDAO newsDAO);
    void onError();
}
