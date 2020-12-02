package com.sammymanunggal.tugasBesarPBP.model.admin;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.sammymanunggal.tugasBesarPBP.R;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Response;

public class CreateNewsActivity extends AppCompatActivity {
    private ImageButton ibBack;
    private EditText etBerita, etTanggal, etIsi;
    private MaterialButton btnCancel, btnCreate;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_create_news);

        progressDialog = new ProgressDialog(this);
        ibBack = findViewById(R.id.ibBack);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        etBerita= findViewById(R.id.etJudulBerita);
        etTanggal= findViewById(R.id.etTanggal);
        etIsi= findViewById(R.id.etIsiBerita);

        btnCancel = findViewById(R.id.btnCancel);
        btnCreate= findViewById(R.id.btnCreate);




        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etBerita.getText().toString().isEmpty()){
                    etBerita.setError("Isikan dengan benar");
                    etBerita.requestFocus();
                }
                else if(etTanggal.getText().toString().isEmpty()){
                    etTanggal.setError("Isikan dengan benar");
                    etTanggal.requestFocus();
                } else if(etIsi.getText().toString().isEmpty()){
                    etIsi.setError("Isikan dengan benar");
                    etIsi.requestFocus();
                }

               else{
                    progressDialog.show();
                    saveUser();
                }
            }
        });


    }


    private void saveUser(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> add = apiService.createUser(etBerita.getText().toString(),
                etTanggal.getText().toString(),  etIsi.getText().toString());


        add.enqueue(new retrofit2.Callback<NewsResponse>() {
            @Override
            public void onResponse(retrofit2.Call<NewsResponse> call, Response<NewsResponse> response) {
                Toast.makeText(CreateNewsActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                onBackPressed();
            }

            @Override
            public void onFailure(retrofit2.Call<NewsResponse> call, Throwable t) {
                Toast.makeText(CreateNewsActivity.this, "Kesalahan Jaringan ", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }

}
