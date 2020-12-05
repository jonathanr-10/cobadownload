package com.sammymanunggal.tugasBesarPBP.model.admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.sammymanunggal.tugasBesarPBP.R;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditNewsActivity  extends AppCompatActivity {
    private ImageButton ibBack;
    private EditText etBerita, etIsi, etTanggal;

    private MaterialButton btnCancel, btnUpdate;
    private String sBerita, sIsi, sTanggal;
    public String id;
    public Bundle mBundle;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_edit_news);





        progressDialog = new ProgressDialog(this);
        ibBack = findViewById(R.id.ibBackEdit);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        etBerita= findViewById(R.id.etJudulBeritaEdit);
        etTanggal= findViewById(R.id.etTanggalEdit);
        etIsi= findViewById(R.id.etIsiBeritaEdit);
        btnCancel = findViewById(R.id.btnCancelEdit);
        btnUpdate= findViewById(R.id.btnUpdateEdit);


        mBundle= getIntent().getBundleExtra("id2");
        id=mBundle.getString("id2");
        loadUserById(id);





        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });





        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etBerita.getText().toString().isEmpty()){
                    etBerita.setError("Isikan dengan benar");
                    etBerita.requestFocus();
                }
                else if(etTanggal.getText().toString().isEmpty()){
                    etTanggal.setError("Isikan dengan benar");
                    etTanggal.requestFocus();
                }else if(etIsi.getText().toString().isEmpty()){
                    etIsi.setError("Isikan dengan benar");
                    etIsi.requestFocus();
                }
                else{
                    progressDialog.show();

                    UpdateUser(id);

                    Intent intent = new Intent(EditNewsActivity.this,ShowListNewsActivity.class);

                    startActivity(intent);
                }
            }
        });




    }

    private void loadUserById(String id){
        ApiInterface apiService =ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> add = apiService.getNewsById(id, "data");

        add.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                sBerita = response.body().getUsers().get(0).getBerita();
                sTanggal = response.body().getUsers().get(0).getTanggal();
                sIsi = response.body().getUsers().get(0).getIsi();



                etBerita.setText(sBerita);
                etTanggal.setText(sTanggal);
                etIsi.setText(sIsi);





                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(EditNewsActivity.this, "Kesalahan Jaringan", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }





    private void UpdateUser(String sIdUser){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> add = apiService.updateNews(sIdUser,etBerita.getText().toString(),
                etTanggal.getText().toString(), etIsi.getText().toString());


        add.enqueue(new retrofit2.Callback<NewsResponse>() {
            @Override
            public void onResponse(retrofit2.Call<NewsResponse> call, Response<NewsResponse> response) {
                Toast.makeText(EditNewsActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

                onBackPressed();
            }

            @Override
            public void onFailure(retrofit2.Call<NewsResponse> call, Throwable t) {
                Toast.makeText(EditNewsActivity.this, "Kesalahan Jaringan ", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

}
