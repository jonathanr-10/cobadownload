//package com.sammymanunggal.tugasBesarPBP.model;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.widget.SearchView;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.sammymanunggal.tugasBesarPBP.R;
//import com.sammymanunggal.tugasBesarPBP.adapter.PreferensiRecyclerViewAdapter;
//
////import com.sammymanunggal.tugasBesarPBP.database.DatabaseClientPreferensi;
//import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.Preferensi;
//
//
//import java.util.List;
//
//
//public class AccountFragment extends Fragment {
//    private RecyclerView recyclerView2;
//
//    private SwipeRefreshLayout refreshLayout2;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_account, container, false );
//
//        refreshLayout2= view.findViewById(R.id.swipe_refresh_preferensi);
//        recyclerView2= view.findViewById(R.id.user_rv_account);
//        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
//
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
//
//        refreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                Toast.makeText(getActivity().getApplicationContext(), "Terefresh", Toast.LENGTH_SHORT).show();
//                getUsers2();
//                refreshLayout2.setRefreshing(false);
//
//            }
//        });
//        getUsers2();
//
//    }
//
//
//    private void getUsers2(){
//        class GetUsers extends AsyncTask<Void,Void, List<Preferensi>> {
//
//            @Override
//            protected List<Preferensi> doInBackground(Void... voids){
//                List<Preferensi> PreferensiList = DatabaseClientPreferensi
//                        .getInstance2(getActivity().getApplicationContext())
//                        .getDatabasePreferensi()
//                        .PreferensiDao()
//                        .getAll();
//                return PreferensiList;
//            }
//
//            @Override
//            protected void onPostExecute(List<Preferensi> Preferensi){
//                super.onPostExecute(Preferensi);
//                final PreferensiRecyclerViewAdapter adapter = new PreferensiRecyclerViewAdapter(AccountFragment.this.getContext(),Preferensi);
//                recyclerView2.setAdapter(adapter);
//
//                if(Preferensi.isEmpty()){
//                    Toast.makeText(getActivity().getApplicationContext(), "Empty List", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        }
//        GetUsers get = new GetUsers();
//        get.execute();
//    }
//
//}