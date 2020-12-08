package com.sammymanunggal.tugasBesarPBP.model.newsUser;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.sammymanunggal.tugasBesarPBP.R;

import com.sammymanunggal.tugasBesarPBP.model.admin.ApiClient;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiInterface;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsDAO;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsRecyclerAdapter;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsResponse;
import com.sammymanunggal.tugasBesarPBP.model.admin.ShowListNewsActivity;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.AddFragment;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.TicketFragment;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.TransaksiResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;

public class ShowListNewsUser extends Fragment {

    RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefresh;
    SwipeRefreshLayout refreshLayout;
    Button downloadButton;
    private NewsRecyclerAdapterUser recyclerAdapter;
    private List<NewsDAO> user= new ArrayList<>();

    public ShowListNewsUser() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.show_news_list_user, container, false );

            swipeRefresh=view.findViewById(R.id.swipeRefreshUser);
        recyclerView = view.findViewById(R.id.showListNewsUser);
            swipeRefresh.setRefreshing(true);
            loadUser();
            swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    loadUser();
                }
            });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

/*
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.layout_ticket, new AddFragment(), "secondFragmentTag").addToBackStack(null)
                        .commit();
            }
        });
 */



    }

    public void loadUser(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> call = apiService.getAllNews("data");

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                generateDataList(response.body().getUsers());
                swipeRefresh.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

                swipeRefresh.setRefreshing(false);
            }
        });

    }

    private void generateDataList(List<NewsDAO> customerList) {

        recyclerAdapter = new NewsRecyclerAdapterUser(getContext(), customerList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);


    }




}
