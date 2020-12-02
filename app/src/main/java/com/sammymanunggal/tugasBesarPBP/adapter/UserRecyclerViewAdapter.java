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
import com.sammymanunggal.tugasBesarPBP.model.orderticket.User;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.UpdateFragment;

import java.util.ArrayList;
import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.UserViewHolder>  {


    private Context context;
    private List<User> userList;
    private List<User> userListFull;


    public UserRecyclerViewAdapter(Context context, List<User> userList){
        this.context = context;
        this.userList = userList;
        userListFull = new ArrayList<>(userList);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }
    public Context getContext() {
        return context;
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position){
        User user = userList.get(position);
        holder.textView.setText(user.getFullName());
        holder.textMuseum.setText(user.getMuseumName());
        holder.textTotal.setText(String.valueOf(user.getTotal()));
        holder.textHarga.setText(String.valueOf(user.getHarga()));

    }

    @Override
    public int getItemCount(){
        return userList.size();
    }



    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView, textTotal, textMuseum, textHarga;

        public UserViewHolder(@NonNull View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.full_name_text);
            textTotal = itemView.findViewById(R.id.full_total_text);
            textMuseum = itemView.findViewById(R.id.full_museum_text);
            textHarga = itemView.findViewById(R.id.full_harga_text);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            User user = userList.get(getAdapterPosition());
            Bundle data = new Bundle();
            data.putSerializable("user", user);
            UpdateFragment updateFragment = new UpdateFragment();
            updateFragment.setArguments(data);
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout_ticket, updateFragment)
                    .commit();
        }
    }




}