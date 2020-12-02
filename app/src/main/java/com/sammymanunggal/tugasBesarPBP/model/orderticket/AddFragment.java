package com.sammymanunggal.tugasBesarPBP.model.orderticket;

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
import com.sammymanunggal.tugasBesarPBP.database.DatabaseClient;

import java.util.List;


public class AddFragment extends Fragment {

    TextInputEditText editText, editTotal;
    AutoCompleteTextView editMuseum;
    Button AddBtn, cancelBtn;
    User user;
    private RecyclerView recyclerView;
    private AutoCompleteTextView dropDownText;
    public AddFragment() {

    }

    private void addUser() {
        final String name = editText.getText().toString();
        final String museum =editMuseum.getText().toString();
        final String totalText = editTotal.getText().toString();
        int harga = 0;

        if(name.isEmpty() || museum.isEmpty() || totalText.isEmpty()){
            editTotal.setError("Please fill Total correctly");
            editText.setError("Please fill Name correctly");
            editMuseum.setError("Please fill Museum correctly");
        }
        else {
            final int total= Integer.parseInt(editTotal.getText().toString());

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


            final int finalHarga = harga;
            class AddUser extends AsyncTask<Void, Void, Void> {
                @Override
                protected Void doInBackground(Void... voids) {
                    User user = new User();
                    user.setFullName(name);
                    user.setMuseumName(museum);
                    user.setTotal(total);
                    user.setHarga(finalHarga);

                    DatabaseClient.getInstance(getActivity().getApplicationContext()).getDatabase()
                            .userDao()
                            .insert(user);

                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    Toast.makeText(getActivity().getApplicationContext(), "Order Is Success", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                    editTotal.setText("");
                    editMuseum.setText("");
                    getUsers();
                }
            }

            AddUser add = new AddUser();
            add.execute();
        }
    }

    private void getUsers() {
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = DatabaseClient
                        .getInstance(getActivity().getApplicationContext())
                        .getDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                if (users.isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Empty List", Toast.LENGTH_SHORT).show();

                }
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(AddFragment.this).commit();
            }
        }
        GetUsers get = new GetUsers();
        get.execute();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        editText = view.findViewById(R.id.input_name);
        editMuseum=view.findViewById(R.id.dropdown2_layout);
        editTotal = view.findViewById(R.id.input_total);
        AddBtn = view.findViewById(R.id.btn_add1);
        cancelBtn = view.findViewById(R.id.btn_cancel1);

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

                addUser();

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