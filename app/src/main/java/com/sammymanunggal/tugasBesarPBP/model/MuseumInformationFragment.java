package com.sammymanunggal.tugasBesarPBP.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.sammymanunggal.tugasBesarPBP.MapActivity;
import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.databinding.FragmentMuseumInformationBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MuseumInformationFragment extends Fragment {

    Museum museum;
    FragmentMuseumInformationBinding binding;
    TextView beliTiketText;
    Button beliTiketBtn;
    Button btn_back;

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_museum_information,container,false);
        View view = binding.getRoot();

        museum = (Museum)getArguments().getSerializable("museum");
        binding.setMsm(museum);
        binding.setActivity(this);



        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public View.OnClickListener btnBackMuseum = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getContext(),MainActivity.class);
            startActivity(intent);
        }
    };
    public View.OnClickListener Arahkan = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getContext(),MapActivity.class);
            Bundle mBundle = new Bundle();

            //pengelompokan dengan bundle
            mBundle.putString("nama", museum.getNama());
            //Melakukan intent (parsing) dengan memanggil Bundlea
            intent.putExtra("nama", mBundle);
            startActivity(intent);
        }
    };


}