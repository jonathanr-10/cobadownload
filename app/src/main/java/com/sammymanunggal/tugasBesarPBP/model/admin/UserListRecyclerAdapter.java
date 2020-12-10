package com.sammymanunggal.tugasBesarPBP.model.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.Preferensi;

import java.util.ArrayList;
import java.util.List;

public class UserListRecyclerAdapter extends RecyclerView.Adapter<UserListRecyclerAdapter.RoomViewHolder>{
    private List<Preferensi> dataList;
    private List<Preferensi> filteredDataList;
    private Context context;

    public UserListRecyclerAdapter(Context context, List<Preferensi> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public UserListRecyclerAdapter.RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_user_list_recycler_adapter, parent, false);
        return new UserListRecyclerAdapter.RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListRecyclerAdapter.RoomViewHolder holder, int position) {
        final Preferensi brg = dataList.get(position);
        holder.twBerita.setText(brg.getEmailPreferensi());
        holder.twTanggal.setText(brg.getNamePreferensi());
        holder.twIsi.setText(brg.getPhoneNumber());

        holder.mParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
                DetailNewsFragment dialog = new DetailNewsFragment();
                dialog.show(manager,"dialog");

                Bundle args = new Bundle();
                dialog.setArguments(args);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder{
        private TextView twBerita,twIsi, twTanggal;
        private LinearLayout mParent;

        public RoomViewHolder(@NonNull View itemView){
            super(itemView);
            twBerita= itemView.findViewById(R.id.twEmailRecyclerUser);
            twIsi = itemView.findViewById(R.id.twNamaRecyclerUser);
            twTanggal = itemView.findViewById(R.id.twNoTelpRecyclerUser);
            mParent = itemView.findViewById(R.id.linearLayout);
        }
    }
}
