package com.sammymanunggal.tugasBesarPBP.model.orderticket;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.adapter.UserRecyclerViewAdapter;
import com.sammymanunggal.tugasBesarPBP.database.DatabaseClient;

import java.util.List;


public class TicketFragment extends Fragment {
    RecyclerView recyclerView;

    SwipeRefreshLayout refreshLayout;
    Button sendButton, historyButton;

    public TicketFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_ticket, container, false );
        refreshLayout= view.findViewById(R.id.swipe_refresh);
        recyclerView= view.findViewById(R.id.user_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        sendButton = view.findViewById(R.id.addTiket);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.layout_ticket, new AddFragment(), "secondFragmentTag").addToBackStack(null)
                        .commit();


            }


        });




        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity().getApplicationContext(), "Terefresh", Toast.LENGTH_SHORT).show();
                getUsers();
                refreshLayout.setRefreshing(false);

            }
        });
        getUsers();

    }


    private void getUsers(){
        class GetUsers extends AsyncTask<Void,Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids){
                List<User> userList = DatabaseClient
                        .getInstance(getActivity().getApplicationContext())
                        .getDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users){
                super.onPostExecute(users);
                final UserRecyclerViewAdapter adapter = new UserRecyclerViewAdapter(TicketFragment.this.getContext(),users);
                recyclerView.setAdapter(adapter);

                if(users.isEmpty()){
                    Toast.makeText(getActivity().getApplicationContext(), "Empty List", Toast.LENGTH_SHORT).show();

                }
            }
        }
        GetUsers get = new GetUsers();
        get.execute();
    }

}