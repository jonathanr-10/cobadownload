package com.sammymanunggal.tugasBesarPBP.model.orderticket;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.adapter.TicketRecyclerViewAdapter;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiClient;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiInterface;
//import com.sammymanunggal.tugasBesarPBP.database.DatabaseClient;

import retrofit2.Call;
import retrofit2.Response;


public class TicketFragment extends Fragment {
    RecyclerView recyclerView;

    SwipeRefreshLayout refreshLayout;
    Button sendButton, historyButton;
    private String email;
    ProgressDialog dialog;

    public TicketFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_ticket, container, false );
        refreshLayout= view.findViewById(R.id.swipe_refresh);
        recyclerView= view.findViewById(R.id.user_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Tunggu Sebentar");
        dialog.show();

        sendButton = view.findViewById(R.id.addTiket);

        SharedPreferences mSettings = getContext().getSharedPreferences("MyPref2", Context.MODE_PRIVATE);
        email = mSettings.getString("email", "missing");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.layout_ticket, new AddFragment(), "secondFragmentTag").addToBackStack(null)
                        .commit();


            }


        });




        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "Terefresh", Toast.LENGTH_SHORT).show();
                getUsers();
                refreshLayout.setRefreshing(false);

            }
        });
        getUsers();

    }

    private void getUsers() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TransaksiResponse> add = apiService.getTransaksiByEmail(email,"data");


        add.enqueue(new retrofit2.Callback<TransaksiResponse>() {
            @Override
            public void onResponse(retrofit2.Call<TransaksiResponse> call, Response<TransaksiResponse> response) {
                //Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                final TicketRecyclerViewAdapter adapter = new TicketRecyclerViewAdapter(TicketFragment.this.getContext(),response.body().getUsers());
                recyclerView.setAdapter(adapter);
                dialog.dismiss();

            }

            @Override
            public void onFailure(retrofit2.Call<TransaksiResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

}