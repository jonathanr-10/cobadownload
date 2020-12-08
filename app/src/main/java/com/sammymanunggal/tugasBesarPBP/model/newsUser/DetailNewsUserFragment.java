package com.sammymanunggal.tugasBesarPBP.model.newsUser;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.button.MaterialButton;
import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiClient;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiInterface;
import com.sammymanunggal.tugasBesarPBP.model.admin.EditNewsActivity;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsResponse;
import com.sammymanunggal.tugasBesarPBP.model.admin.ShowListNewsActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailNewsUserFragment extends DialogFragment {
    private TextView  twBerita, twIsi, twTanggal;
    private String sIdUser, sBerita, sTanggal, sIsi;
    private ImageButton ibClose;
    private ProgressDialog progressDialog;
    private MaterialButton btnDelete, btnUpdate;
    public static com.sammymanunggal.tugasBesarPBP.model.admin.DetailNewsFragment newInstance(){return new com.sammymanunggal.tugasBesarPBP.model.admin.DetailNewsFragment();}
    public String tampung;
    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_fragment_detail_news, container, false );

        progressDialog = new ProgressDialog(getContext());
        progressDialog.show();

        ibClose = v.findViewById(R.id.ibCloseUser);
        ibClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        twBerita = v.findViewById(R.id.twJudulBeritaDetailUser);
        twIsi = v.findViewById(R.id.twIsiDetailUser);
        twTanggal= v.findViewById(R.id.twTanggalDetailUser);



        sIdUser = getArguments().getString("id", "");


        loadUserById(sIdUser);
        return v;
    }


    private void loadUserById(String id){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> add = apiService.getNewsById(id, "data");

        add.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, final Response<NewsResponse> response) {
                sBerita = response.body().getUsers().get(0).getBerita();
                sIsi = response.body().getUsers().get(0).getIsi();
                sTanggal = response.body().getUsers().get(0).getTanggal();



                twTanggal.setText(sTanggal);
                twBerita.setText(sBerita);
                twIsi.setText(sIsi);

                progressDialog.dismiss();



            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Kesalahan Jaringan", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }



    private void deleteUser(String id){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> delete = apiService.deleteNews(id);


        delete.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, final Response<NewsResponse> response) {
                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getActivity(), ShowListNewsActivity.class));
                getActivity().finish();
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Kesalahan Jaringan ", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
