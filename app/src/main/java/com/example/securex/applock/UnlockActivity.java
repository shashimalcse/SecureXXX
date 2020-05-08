package com.example.securex.applock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.securex.R;
import com.example.securex.utils.Utils;
import com.goodiebag.pinview.Pinview;

public class UnlockActivity extends AppCompatActivity {


    String current_app;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock);
        pref = getApplicationContext().getSharedPreferences("com.android.app.users",getApplicationContext().MODE_PRIVATE);
        Pinview pinview =(Pinview) findViewById(R.id.PinUnlockApp);
        current_app = getIntent().getStringExtra("current_app");

    pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
        @Override
        public void onDataEntered(Pinview pinview, boolean fromUser) {
            String pin = pinview.getValue().toString();
            if(pin.equals(pref.getString("Pin",""))){
                finish();
            }
            else{
                pinview.clearValue();
            }
        }
    });




    }

    @Override
    public void onBackPressed() {

    }



}
