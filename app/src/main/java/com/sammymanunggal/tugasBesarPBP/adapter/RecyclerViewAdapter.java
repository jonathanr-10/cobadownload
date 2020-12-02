package com.sammymanunggal.tugasBesarPBP.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.databinding.AdapterRecyclerViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.sammymanunggal.tugasBesarPBP.model.Museum;
import com.sammymanunggal.tugasBesarPBP.model.MuseumInformationFragment;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Museum> result;
    private AdapterRecyclerViewBinding binding;

    public RecyclerViewAdapter(){}

    public RecyclerViewAdapter(Context context, List<Museum> result){
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AdapterRecyclerViewBinding binding;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = AdapterRecyclerViewBinding.inflate(layoutInflater,
                parent,false);
        final MyViewHolder holder = new MyViewHolder(binding);

        return holder;
    }

    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Museum mhs = result.get(position);
        holder.binding.setMsm(mhs);
        
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        AdapterRecyclerViewBinding binding;
        private MaterialCardView itemCard;
        public MyViewHolder(@NonNull AdapterRecyclerViewBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

            binding.itemCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.getMsm();
                    Museum museum = result.get(getAdapterPosition());
                    Bundle data = new Bundle();
                    data.putSerializable("museum", museum);
                    Toast.makeText(context, "You touch me?", Toast.LENGTH_SHORT).show();
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    MuseumInformationFragment museumInformationFragment = new MuseumInformationFragment();
                    museumInformationFragment.setArguments(data);
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_layout, museumInformationFragment)
                            .commit();
                }
            });


        }
        public void onClick(View view) {
            Toast.makeText(context, "You touch me?", Toast.LENGTH_SHORT).show();
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            MuseumInformationFragment museumInformationFragment = new MuseumInformationFragment();
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, museumInformationFragment)
                    .commit();
        }
    }

}
