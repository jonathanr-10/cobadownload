package com.sammymanunggal.tugasBesarPBP.model.orderticket;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.database.DatabaseClient;

public class UpdateFragment extends Fragment {

    private TextInputEditText editText, editMuseum, editTotal;
    private Button saveBtn, payBtn, cancelBtn;
    private User user;

    public  UpdateFragment(){

    }

    private void update(final User user){

        final String museum =user.getMuseumName();
        final int total= user.getTotal();
        int harga = 0;
        if( museum.equals("Museum Affandi") ){
            harga = 3000*total;
        } else  if( museum.equals("Museum Merapi") ){
            harga = 10000*total;
        } else  if( museum.equals("Museum Vredeburg") ){
            harga = 2000*total;
        }else  if( museum.equals("Museum Kraton") ){
            harga = 15000*total;
        }else  if( museum.equals("Museum Sandi") ){
            harga = 3000*total;
        }else  if( museum.equals("Museum Jogja Kembali") ){
            harga = 1000*total;
        }
        int finalHarga = harga;





        class UpdateUser extends AsyncTask<Void,Void,Void> {

            @Override
            protected Void doInBackground(Void... voids){
                user.setHarga(finalHarga);

                DatabaseClient.getInstance(getActivity().getApplicationContext()).getDatabase()
                        .userDao()
                        .update(user);
                return null;
            }

            @Override

            protected void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);
                Toast.makeText(getActivity().getApplicationContext(), "Your Ticket is Updated", Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(UpdateFragment.this).commit();
            }

        }
        UpdateUser update = new UpdateUser();
        update.execute();
    }


    private void delete(final User user){
        class DeleteUser extends AsyncTask<Void, Void, Void>{
            @Override
            protected Void doInBackground(Void... voids){
                DatabaseClient.getInstance(getActivity().getApplicationContext()).getDatabase()
                        .userDao()
                        .delete(user);
                return null;
            }

            @Override

            protected void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);
                Toast.makeText(getActivity().getApplicationContext(), "Your Order is Deleted", Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(UpdateFragment.this).commit();
            }
        }
        DeleteUser delete = new DeleteUser();
        delete.execute();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_update, container, false );
        user = (User) getArguments().getSerializable("user");
        editText = view.findViewById(R.id.input_name2);
        editTotal = view.findViewById(R.id.input_total2);

        saveBtn = view.findViewById(R.id.btn_update2);
        payBtn = view.findViewById(R.id.btn_delete2);
        cancelBtn = view.findViewById(R.id.btn_cancel2);





        try{
            if(user.getFullName() != null   ){



                editText.setText(user.getFullName());
                editTotal.setText(String.valueOf(user.getTotal()));

            } else {
                editText.setText("-");

                editTotal.setText("-");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                user.setFullName(editText.getText().toString());
                user.setTotal(Integer.parseInt(editTotal.getText().toString()));

                update(user);
            }
        });

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                delete(user);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(UpdateFragment.this).commit();
            }
        });
    }

}