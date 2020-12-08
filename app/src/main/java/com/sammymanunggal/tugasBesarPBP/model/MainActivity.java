package com.sammymanunggal.tugasBesarPBP.model;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.adapter.RecyclerViewAdapter;
import com.sammymanunggal.tugasBesarPBP.model.newsUser.ShowListNewsUser;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.TicketFragment;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //BOTTOMNAVIGATION
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //BOTTOMNAVIGATION
        BottomNavigationView bottomNav =findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new DashboardFragment()).commit();

    }



    //BOTTOMNAVIGATION
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_dashboard :
                            selectedFragment= new DashboardFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                    selectedFragment).commit();
                            break;
                        case R.id.nav_account:
                            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_news:
                            selectedFragment= new ShowListNewsUser();
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                    selectedFragment).commit();
                                break;
                        case R.id.nav_ticket:
                            selectedFragment= new TicketFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                    selectedFragment).commit();
                            break;
                    }

                    return true;
                }
            };


}