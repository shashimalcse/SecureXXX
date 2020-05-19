package com.example.securex.scanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.securex.R;
import com.example.securex.applock2.RecActivity;
import com.example.securex.filesecurity.Home;
import com.example.securex.passwordupdate.PasswordUpdateActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ListPermission extends AppCompatActivity {






    TextView naslov,critical;
    int position;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_app);
        setContentView(R.layout.fragment_screen_slide_page);

        listView = (ListView) findViewById(R.id.Lista);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.appsecurity);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.applock:
                        startActivity(new Intent(ListPermission.this, RecActivity.class));
                        finish();
                        break;
                    case R.id.profile:
                        startActivity(new Intent(ListPermission.this, PasswordUpdateActivity.class));
                        finish();
                        break;
                    case R.id.filescurity:
                        startActivity(new Intent(ListPermission.this, Home.class));
                        finish();
                }

                return false;
            }
        });




        for(int i=0;i<300;i++) {
            if (position == i) {
                Intent intent = getIntent();
                Bundle bundle = this.getIntent().getExtras();
                ArrayList<String> count = intent.getStringArrayListExtra("size1");
                ArrayList<String> newList = new ArrayList<String>();
                for(int j=0;j<count.size();j++){
                    String s = count.get(j);
                    //List<String> myList = new ArrayList<String>(Arrays.asList(s.split("\\s*.\\s*")));
                    String mystring = s.substring(19,s.length());
                    newList.add(mystring);

                }
                //ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,newList);
                //critical.setText(count.get(0));
                final CustomAdapter adapter = new CustomAdapter(ListPermission.this, newList);

                listView.setAdapter(adapter);
                //listView.setAdapter(arrayAdapter);

            }
        }

    }
    public class CustomAdapter extends BaseAdapter {
        private Activity activity;
        private LayoutInflater inflater;
        private ArrayList<String> data;

        public CustomAdapter(Activity activity, ArrayList<String> items) {
            this.activity = activity;
            this.data = items;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentList", "Item clicked: " + id);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            if (inflater == null)
                inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null)
                convertView = inflater.inflate(R.layout.list_activity, null);

            try {


                TextView paket = (TextView) convertView.findViewById(R.id.paket);


                paket.setText(data.get(position));
                //progressBar.setProgress(50);

                /*ProgressBar mProgress = (ProgressBar) findViewById(R.id.progressBar2);
                mProgress.setVisibility(View.VISIBLE);
                mProgress.setMax(100);*/

                //LinearLayout view = (LinearLayout) findViewById(R.id.)






                    /*progressBar.getProgress();
                    progressBar.setMax(100);
                    progressBar.setProgress(75);*/




                //critical.setText(""+1000);
                //critical.setText(""+data.get(position).critical.size());

                //progressBar.setMax(100);
                //mProgress.setProgress(50);
                //progressBar.setProgress(50);
                //critical.setBackgroundColor(Color.parseColor(getClor(data.get(position).critical.size()*100/19)));




            } catch (ParseException e) {

                e.printStackTrace();

            }

            return convertView;

        }
    }

}
