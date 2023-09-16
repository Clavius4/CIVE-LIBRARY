package com.civeipt.civelibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;


import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    public static String regNo, reg_no;


    public static ArrayList<profileDetails> profileDetailsArrayList;

    static {
        profileDetailsArrayList = new ArrayList<>();
    }

    ImageButton btnhome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        btnhome = findViewById(R.id.btnhome);

        Intent i = getIntent();
        regNo = i.getStringExtra(reg_no);

        Bundle bundle = new Bundle();
        bundle.putString("reg_no", String.valueOf(regNo));
        Fragment fragment = new HomeFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.navHostFragment, fragment, null)
                .commit();


        btnhome.setOnClickListener(view -> {
            Bundle bundle1 = new Bundle();
            bundle1.putString("reg_no", String.valueOf(regNo));
            Fragment fragment1 = new HomeFragment();
            fragment1.setArguments(bundle1);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.navHostFragment, fragment1, null)
                    .commit();
        });

    }

}