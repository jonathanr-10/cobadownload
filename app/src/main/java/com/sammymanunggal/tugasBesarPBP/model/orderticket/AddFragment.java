package com.sammymanunggal.tugasBesarPBP.model.orderticket;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.PreferensiResponse;
import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.SignUp;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiClient;
import com.sammymanunggal.tugasBesarPBP.model.admin.ApiInterface;
//import com.sammymanunggal.tugasBesarPBP.database.DatabaseClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;


public class AddFragment extends Fragment {

    TextInputEditText editText, editTotal;
    AutoCompleteTextView editMuseum;
    Button AddBtn, cancelBtn;
    Transaksi transaksi;
    private RecyclerView recyclerView;
    private AutoCompleteTextView dropDownText;
    private String email;
    private double harga;
    public AddFragment() {

    }

    private void addTransaksi() {

        final String name = editText.getText().toString();
        final String museum =editMuseum.getText().toString();
        final String totaltext = editTotal.getText().toString();
        final int total= Integer.parseInt(editTotal.getText().toString());

        if(museum.equals("Museum Affandi")){
            harga = 3000*total;
        } else if( museum.equals("Museum Merapi") ){
            harga = 10000*total;
        }else  if( museum.equals("Museum Vredeburg") ){
            harga = 2000*total;
        }else  if( museum.equals("Museum Kraton") ){
            harga = 15000*total;
        }else  if( museum.equals("Museum Sandi") ){
            harga = 3000*total;
        }else  if( museum.equals("Museum Jogja Kembali") ){
            harga = 1000 * total;
        }


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TransaksiResponse> add = apiService.createTransaksi(name,email,museum,totaltext,Double.toString(harga));


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        editText = view.findViewById(R.id.input_name);
        editMuseum=view.findViewById(R.id.dropdown2_layout);
        editTotal = view.findViewById(R.id.input_total);
        AddBtn = view.findViewById(R.id.btn_add1);
        cancelBtn = view.findViewById(R.id.btn_cancel1);

        SharedPreferences mSettings = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        email = mSettings.getString("email", "missing");


        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        dropDownText = view.findViewById(R.id.dropdown2_layout);
        String[] Item = new String[]{
                "Museum Affandi",
                "Museum Merapi",
                "Museum Vredeburg",
                "Museum Kraton",
                "Museum Sandi",
                "Museum Jogja Kembali",
        };
        ArrayAdapter<String> adapter= new ArrayAdapter<>(
                getActivity(),
                R.layout.dropdown_item,
                Item
        );

        dropDownText.setAdapter(adapter);

        dropDownText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item2 = adapterView.getItemAtPosition(i).toString();

            }
        });

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addTransaksi();

            }

        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(AddFragment.this).commit();
            }
        });


    }
}