package com.sammymanunggal.tugasBesarPBP.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.adapter.UserRecyclerViewAdapter;
import com.sammymanunggal.tugasBesarPBP.database.DatabaseClient;
import com.sammymanunggal.tugasBesarPBP.database.DatabaseClientPreferensi;
import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.Preferensi;
import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.PreferensiResponse;
import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.SignIn;
import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.SignUp;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiClient;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiInterface;
import com.sammymanunggal.tugasBesarPBP.model.admin.EditNewsActivity;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsResponse;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.TicketFragment;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.User;

import java.net.URI;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    private Button takePhoto,signout,btnSave,btnBack;
    private TextInputLayout nama_layout,alamat_layout,nohp_layout;
    private TextInputEditText nama,alamat,nohp;
    private TextView header;
    private ImageView imageView;
    private static final int PERMISSION_CODE = 100;
    private static final int IMAGE_CAPTURE_CODE = 101;
    private Uri imageUri;
    private String email,password;
    private Preferensi preferensi;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.show();

        takePhoto = findViewById(R.id.takePhoto);
        signout = findViewById(R.id.btn_signout);
        btnBack = findViewById(R.id.btn_back);
        header = findViewById(R.id.id_header);
        btnSave = (Button)findViewById(R.id.btn_save);
        nama_layout = findViewById(R.id.profile_nama_layout);
        alamat_layout = findViewById(R.id.profile_alamat_layout);
        nohp_layout = findViewById(R.id.profile_nohp_layout);
        nama = findViewById(R.id.profile_nama);
        alamat = findViewById(R.id.profile_alamat);
        nohp = findViewById(R.id.profile_nohp);
        imageView = findViewById(R.id.imgProfile);

        SharedPreferences mSettings = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        email = mSettings.getString("email", "missing");
        String email2 = email;
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();



        GetPreferensi(email);

        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED ||
                        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED) {

                    String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

                    ActivityCompat.requestPermissions(ProfileActivity.this, permission, PERMISSION_CODE);

                }else if(checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED ||
                        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){

                    openCamera();

                }
            }
        });

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putInt("isLogin",0);                                 // set 0 supaya app meminta login saat user masuk app
                editor.apply();

                Intent intent = new Intent(ProfileActivity.this, SignIn.class);// Balik ke login
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),imageUri.toString(),Toast.LENGTH_SHORT).show();
//                if(imageUri.toString() == null){
//                    preferensi.setImgURI(imageUri.toString());
//                }
//                preferensi.setNamePreferensi(nama.getText().toString());
//                preferensi.setAddress(alamat.getText().toString());
//                preferensi.setPhoneNumber(nohp.getText().toString());
                UpdateUser(email,nama.getText().toString(),alamat.getText().toString(),nohp.getText().toString(),imageUri.toString());


            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(ProfileActivity.this,
                        "Camera Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(ProfileActivity.this,
                        "Camera Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            if (grantResults.length > 0
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(ProfileActivity.this,
                        "Storage Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(ProfileActivity.this,
                        "Storage Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }


    private void openCamera(){
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION,"From tubes APP");
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);

        //START CAMERA
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(intent,IMAGE_CAPTURE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            imageView.setImageURI(imageUri);
        }
    }

    private void GetPreferensi(String email){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<PreferensiResponse> add = apiService.getUserById(email, "data");

        add.enqueue(new Callback<PreferensiResponse>() {
            @Override
            public void onResponse(Call<PreferensiResponse> call, final Response<PreferensiResponse> response) {

                nama.setText(response.body().getUsers().get(0).getNamePreferensi());
                alamat.setText(response.body().getUsers().get(0).getAddress());
                nohp.setText(response.body().getUsers().get(0).getPhoneNumber());
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<PreferensiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Kesalahan Jaringan", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    private void UpdateUser(String email,String nama, String alamat, String nohp, String image){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<PreferensiResponse> add = apiService.updateUser(email,nama,alamat,nohp,image);


        add.enqueue(new retrofit2.Callback<PreferensiResponse>() {
            @Override
            public void onResponse(retrofit2.Call<PreferensiResponse> call, Response<PreferensiResponse> response) {
                Toast.makeText(ProfileActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

                onBackPressed();
            }

            @Override
            public void onFailure(retrofit2.Call<PreferensiResponse> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Kesalahan Jaringan ", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }


}