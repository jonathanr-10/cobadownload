package com.sammymanunggal.tugasBesarPBP.model.admin;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sammymanunggal.tugasBesarPBP.R;

import java.util.ArrayList;
import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.RoomViewHolder> implements Filterable {
    private List<NewsDAO> dataList;
    private List<NewsDAO> filteredDataList;
    private Context context;

    public NewsRecyclerAdapter(Context context, List<NewsDAO> dataList){
        this.context = context;
        this.dataList = dataList;
        this.filteredDataList = dataList;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.news_activity_news_recycler_adapter, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerAdapter.RoomViewHolder holder, int position) {
        final NewsDAO brg = filteredDataList.get(position);
        holder.twBerita.setText(brg.getBerita());
        holder.twTanggal.setText(brg.getTanggal());
        holder.twIsi.setText(brg.getIsi());

        holder.mParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
                DetailNewsFragment dialog = new DetailNewsFragment();
                dialog.show(manager,"dialog");

                Bundle args = new Bundle();
                args.putString("id",brg.getId());
                dialog.setArguments(args);
                Toast.makeText(context,"INI ID",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredDataList.size();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder{
        private TextView twBerita,twIsi, twTanggal;
        private LinearLayout mParent;

        public RoomViewHolder(@NonNull View itemView){
            super(itemView);
            twBerita= itemView.findViewById(R.id.twJudulBeritaRecycler);
            twIsi = itemView.findViewById(R.id.twTanggalRecycler);
            twTanggal = itemView.findViewById(R.id.twIsiRecycler);
            mParent = itemView.findViewById(R.id.linearLayout);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter(){
            @Override
            protected FilterResults performFiltering(CharSequence constraint){
                String charSequenceString = constraint.toString();
                if(charSequenceString.isEmpty()){
                    filteredDataList = dataList;
                }else{
                    List<NewsDAO> filteredList = new ArrayList<>();
                    for(NewsDAO NewsDAO : dataList){
                        if(NewsDAO.getBerita().toLowerCase().contains(charSequenceString.toLowerCase())){
                            filteredList.add(NewsDAO);
                        }
                        filteredDataList = filteredList;
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filteredDataList;
                return results;
            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results){
                filteredDataList = (List<NewsDAO>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
