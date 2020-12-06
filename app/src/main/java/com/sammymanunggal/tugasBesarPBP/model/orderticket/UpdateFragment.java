package com.sammymanunggal.tugasBesarPBP.model.orderticket;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiClient;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiInterface;

import retrofit2.Call;
import retrofit2.Response;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;
//import com.sammymanunggal.tugasBesarPBP.database.DatabaseClient;

public class UpdateFragment extends Fragment {

    private TextInputEditText editText, editMuseum, editTotal;
    private Button saveBtn, payBtn, cancelBtn;
    private Transaksi transaksi;
    private String email;

    public  UpdateFragment(){

    }

    private void update(final Transaksi transaksi){

        final String museum = transaksi.getMuseumName();
        final int total= transaksi.getTotal();
        int harga = 0;
        if( museum.equals("Museum Affandi") ){
            harga = 3000*total;
        } else  if( museum.equals("Museum Merapi") ){
            harga = 10000*total;
        } else  if( museum.equals("Museum Vredeburg") ){
            harga = 2000*total;
        }else  if( museum.equals("Museum Kraton") ){
            harga = 15000*total;
        }else  if( museum.equals("Museum Sandi") ){
            harga = 3000*total;
        }else  if( museum.equals("Museum Jogja Kembali") ){
            harga = 1000*total;
        }
        int finalHarga = harga;



        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TransaksiResponse> update = apiService.updateTransaksi(email,transaksi.getFullName(),email,museum,Integer.toString(transaksi.getTotal()),Double.toString(harga));


        update.enqueue(new retrofit2.Callback<TransaksiResponse>() {
            @Override
            public void onResponse(retrofit2.Call<TransaksiResponse> call, Response<TransaksiResponse> response) {
                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(retrofit2.Call<TransaksiResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void delete(final Transaksi transaksi){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TransaksiResponse> add = apiService.deleteTransaksi(Integer.toString(transaksi.getId()));


        add.enqueue(new retrofit2.Callback<TransaksiResponse>() {
            @Override
            public void onResponse(retrofit2.Call<TransaksiResponse> call, Response<TransaksiResponse> response) {
                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(retrofit2.Call<TransaksiResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_update, container, false );

        transaksi = (Transaksi) getArguments().getSerializable("user");
        editText = view.findViewById(R.id.input_name2);
        editTotal = view.findViewById(R.id.input_total2);

        saveBtn = view.findViewById(R.id.btn_update2);
        payBtn = view.findViewById(R.id.btn_delete2);
        cancelBtn = view.findViewById(R.id.btn_cancel2);

        SharedPreferences mSettings = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        email = mSettings.getString("email", "missing");



        try{
            if(transaksi.getFullName() != null   ){
                editText.setText(transaksi.getFullName());
                editTotal.setText(String.valueOf(transaksi.getTotal()));

            } else {
                editText.setText("-");

                editTotal.setText("-");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                transaksi.setFullName(editText.getText().toString());
                transaksi.setTotal(Integer.parseInt(editTotal.getText().toString()));;

                update(transaksi);
            }
        });

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                delete(transaksi);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(UpdateFragment.this).commit();
            }
        });
    }

}