package com.sammymanunggal.tugasBesarPBP.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.Preferensi;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.UpdateFragment;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.User;

import java.util.List;

public class PreferensiRecyclerViewAdapter extends RecyclerView.Adapter<PreferensiRecyclerViewAdapter.PreferensiViewHolder>   {
    private Context context;
    private List<Preferensi> PreferensiList;
    public PreferensiRecyclerViewAdapter(Context context, List<Preferensi> preferensi){
        this.context = context;
        this.PreferensiList = preferensi;

    }

    @NonNull
    @Override
    public PreferensiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_preferensi, parent, false);
        return new PreferensiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreferensiViewHolder holder, int position){
        Preferensi Preferensi = PreferensiList.get(position);
        holder.namaPreferensi.setText(Preferensi.getNamePreferensi());
        holder.notelp.setText(Preferensi.getPhoneNumber());
        holder.email.setText(Preferensi.getEmailPreferensi());
        holder.alamat.setText(Preferensi.getAddress());
    }


    public int getItemCount(){
        return PreferensiList.size();
    }



    public class PreferensiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView namaPreferensi, email, alamat, notelp;

        public PreferensiViewHolder(@NonNull View itemView){
            super(itemView);
            namaPreferensi = itemView.findViewById(R.id.nama_preferensi_data);
            alamat = itemView.findViewById(R.id.adress_preferensi_data);
            email = itemView.findViewById(R.id.email_preferensi_data);
            notelp = itemView.findViewById(R.id.phoneNumber_preferensi_data);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();

        }
    }
}
