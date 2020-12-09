package com.sammymanunggal.tugasBesarPBP.UnitTest;

import com.sammymanunggal.tugasBesarPBP.model.admin.ApiClient;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiInterface;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsDAO;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsService {
    public void news(final NewsView view, String berita, String tanggal, String isi, final NewsCallback callback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> newsDAOCall = apiService.createNews(berita, tanggal, isi);
        newsDAOCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.body().getMessage().equalsIgnoreCase("berhasil login" )){
                    callback.onSuccess(true, response.body().getUsers().get(0));
                }
                else{
                    callback.onError();
                    view.showNewsError(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                view.showErrorResponse(t.getMessage());
                callback.onError();
            }
        });
    }

    public Boolean getValid(final NewsView view, String berita, String tanggal, String isi) {
        final Boolean[] bool = new Boolean[1];
        news(view, berita, tanggal, isi, new NewsCallback() {
            @Override
            public void onSuccess(boolean value, NewsDAO newsDAO) {
                bool[0] = true;
            }

            @Override
            public void onError() {
                bool[0] = false;
            }
        });
        return bool[0];

    }
}
