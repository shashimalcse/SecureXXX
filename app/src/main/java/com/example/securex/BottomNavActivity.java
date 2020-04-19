package com.example.securex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.securex.applock.AppLockActivity;
import com.example.securex.passwordupdate.PasswordUpdateActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_otton_nav);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.home);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.applock:
                        startActivity(new Intent(BottomNavActivity.this, AppLockActivity.class));
                        break;
                    case R.id.profile:
                        startActivity(new Intent(BottomNavActivity.this, PasswordUpdateActivity.class));
                        break;

                }

                return false;
            }
        });
    }
}
