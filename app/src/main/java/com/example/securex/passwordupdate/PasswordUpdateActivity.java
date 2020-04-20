package com.example.securex.passwordupdate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.securex.BottomNavActivity;
import com.example.securex.R;
import com.example.securex.applock.AppLockActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PasswordUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_update);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.applock:
                        startActivity(new Intent(PasswordUpdateActivity.this, AppLockActivity.class));
                        finish();
                        break;
                    case R.id.home:
                        startActivity(new Intent(PasswordUpdateActivity.this, BottomNavActivity.class));
                        finish();
                        break;

                }
                return false;
            }
        });


    }
}
