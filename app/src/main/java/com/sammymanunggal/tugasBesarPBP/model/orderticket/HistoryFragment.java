//package com.sammymanunggal.tugasBesarPBP.model.orderticket;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.Toast;
//
//
//import com.sammymanunggal.tugasBesarPBP.R;
//
//import com.sammymanunggal.tugasBesarPBP.adapter.UserRecyclerViewAdapter;
////import com.sammymanunggal.tugasBesarPBP.database.DatabaseClient;
//
//import java.util.List;
//
//
//public class HistoryFragment extends Fragment {
//
//    RecyclerView recyclerView;
//
//    SwipeRefreshLayout refreshLayout;
//    Button sendButton;
//
//    public HistoryFragment() {
//
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//        View view = inflater.inflate(R.layout.fragment_history, container, false );
//        refreshLayout= view.findViewById(R.id.swipe_refresh_history);
//        recyclerView= view.findViewById(R.id.user_rv_history);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
//        sendButton = view.findViewById(R.id.BackHistory);
//
//
//
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
//        sendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//
//            }
//
//
//        });
//
//
//
//
//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                Toast.makeText(getActivity().getApplicationContext(), "Terefresh", Toast.LENGTH_SHORT).show();
//                getUsers();
//                refreshLayout.setRefreshing(false);
//
//            }
//        });
//        getUsers();
//
//    }
//
//
//    private void getUsers(){
//        class GetUsers extends AsyncTask<Void,Void, List<User>>{
//
//            @Override
//            protected List<User> doInBackground(Void... voids){
//                List<User> HistoryList = DatabaseClient
//                        .getInstance(getActivity().getApplicationContext())
//                        .getDatabase()
//                        .userDao()
//                        .getAll();
//                return HistoryList;
//            }
//
//            @Override
//            protected void onPostExecute(List<User> oke){
//                super.onPostExecute(oke);
//                final UserRecyclerViewAdapter adapter = new UserRecyclerViewAdapter(HistoryFragment.this.getContext(),oke);
//                recyclerView.setAdapter(adapter);
//
//                if(oke.isEmpty()){
//                    Toast.makeText(getActivity().getApplicationContext(), "Empty List", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        }
//        GetUsers get = new GetUsers();
//        get.execute();
//    }
//}