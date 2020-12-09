package com.sammymanunggal.tugasBesarPBP.UnitTest;

import com.sammymanunggal.tugasBesarPBP.model.admin.NewsDAO;

public class NewsPresenter {
    private NewsView view;
    private NewsService service;
    private NewsCallback callback;

    public NewsPresenter(NewsView view, NewsService service) {
        this.view = view;
        this.service = service;
    }

    public void onUpdateClicked() {
        if (view.getBerita().isEmpty()) {
            view.showBeritaError("Judul Berita tidak boleh kosong");
            return;
        } else if (view.getTanggal().isEmpty()) {
            view.showTanggalError("Tanggal tidak boleh kosong");
            return;
        }else if(view.getIsi().isEmpty()){
            view.showIsiError("Isi Berita tidak boleh kosong");
            return;
        } else {
            service.news(view, view.getBerita(), view.getTanggal(), view.getIsi(), new NewsCallback() {

                @Override
                public void onSuccess(boolean value, NewsDAO newsDAO) {
//                    if (newsDAO.getNama().equalsIgnoreCase("admin")) {
//                        view.startMainActivity();
//                    } else {
                        view.startEditNewsActivity(newsDAO);
//                    }
                }

                @Override
                public void onError() {

                }
            });
            return;
        }
    }
}
