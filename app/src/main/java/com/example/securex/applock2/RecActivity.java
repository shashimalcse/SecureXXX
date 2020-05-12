package com.example.securex.applock2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import com.example.securex.R;

import java.util.ArrayList;
import java.util.List;

public class RecActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);

        initView();

    }

    private void initView() {

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AppAdapter appAdpater = new AppAdapter(this,getAppApps());
        recyclerView.setAdapter(appAdpater);

        button = (Button) findViewById(R.id.permisiion);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPermission(v);
            }
        });
    }

    private List<AppItem> getAppApps() {
        List<AppItem> appItems = new ArrayList<>();

        PackageManager pk = getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN,null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = pk.queryIntentActivities(intent,0);

        for (ResolveInfo resolveInfo : resolveInfos){
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            appItems.add(new AppItem(activityInfo.loadIcon(pk),activityInfo.loadLabel(pk).toString(),activityInfo.packageName));
        }



        return appItems;
    }

    public  void  setPermission(View view){
        startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));

    }

    @Override
    protected void onResume() {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            if(Utils.checkPermission(this)){
                button.setVisibility(View.GONE);
            }
        }
        super.onResume();
    }


}
