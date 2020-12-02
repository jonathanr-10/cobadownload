package com.sammymanunggal.tugasBesarPBP.model.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.sammymanunggal.tugasBesarPBP.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowListNewsActivity extends AppCompatActivity {
    private ImageButton ibBack;
    private RecyclerView recyclerView;
    private NewsRecyclerAdapter recyclerAdapter;
    private List<NewsDAO> user= new ArrayList<>();
    private SearchView searchView;
    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_show_list_news);

        ibBack = findViewById(R.id.ibBack);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        searchView = findViewById(R.id.searchUser);
        swipeRefresh=findViewById(R.id.swipeRefresh);

        swipeRefresh.setRefreshing(true);
        loadUser();
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadUser();
            }
        });
    }

    public void loadUser(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> call = apiService.getAllUser("data");

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                generateDataList(response.body().getUsers());
                swipeRefresh.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(ShowListNewsActivity.this,"Kesalahan Jaringan", Toast.LENGTH_SHORT).show();
                swipeRefresh.setRefreshing(false);
            }
        });

    }

    private void generateDataList(List <NewsDAO> customerList) {
        recyclerView = findViewById(R.id.userRecyclerView);
        recyclerAdapter = new NewsRecyclerAdapter(this, customerList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ShowListNewsActivity.this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String queryString) {
                recyclerAdapter.getFilter().filter(queryString);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String queryString) {
                recyclerAdapter.getFilter().filter(queryString);
                return false;
            }
        });
    }
}
