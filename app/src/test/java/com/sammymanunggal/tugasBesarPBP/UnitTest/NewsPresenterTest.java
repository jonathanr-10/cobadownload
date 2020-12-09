package com.sammymanunggal.tugasBesarPBP.UnitTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class NewsPresenterTest {
    @Mock
    private NewsView view;

    @Mock
    private NewsService service;
    private NewsPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new NewsPresenter(view, service);
    }

    @Test
    public void ShowErrorWhenJudulIsEmpty() throws Exception {
        when(view.getBerita()).thenReturn("");
        System.out.println("judul      : "+view.getBerita());
        presenter.onUpdateClicked();
        verify(view).showBeritaError("Judul Berita tidak boleh kosong");
    }

    @Test
    public void shouldShowErrorMessageWhenTanggalIsEmpty() throws Exception {
        when(view.getBerita()).thenReturn("Judul Berita");
        System.out.println("judul      : "+ view.getBerita());

        when(view.getTanggal()).thenReturn("");
        System.out.println("tanggal : "+view.getTanggal());
        presenter.onUpdateClicked();

        verify(view).showTanggalError("Tanggal tidak boleh kosong");
    }

    @Test
    public void shouldShowErrorMessageWhenIsiIsEmpty() throws Exception {
        when(view.getBerita()).thenReturn("Judul Berita");
        System.out.println("judul      : "+ view.getBerita());

        when(view.getTanggal()).thenReturn("8/12/2020");
        System.out.println("tanggal      : "+ view.getTanggal());

        when(view.getIsi()).thenReturn("");
        System.out.println("isi : "+view.getIsi());
        presenter.onUpdateClicked();

        verify(view).showIsiError("Isi Berita tidak boleh kosong");
    }

    @Test
    public void shouldStartMainActivityWhenBeritaAndTanggalAndIsiAreCorrect() throws Exception {
        when(view.getBerita()).thenReturn("Judul Berita");
        System.out.println("judul      : "+view.getBerita());

        when(view.getTanggal()).thenReturn("8/12/2020");
        System.out.println("password : "+view.getTanggal());

        when(view.getIsi()).thenReturn("Isi berita hari ini");
        System.out.println("isi : "+view.getIsi());

        when(service.getValid(view, view.getBerita(), view.getTanggal(), view.getIsi())).thenReturn(true);
        System.out.println("Hasil    : "+service.getValid(view,view.getBerita(), view.getTanggal(), view.getIsi()));
        presenter.onUpdateClicked();
        //verify(view).startMainActivity();
    }
}