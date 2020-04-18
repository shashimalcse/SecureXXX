package com.example.securex.applock;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.securex.R;
import com.example.securex.databinding.FragmentApplistBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApplistFragment extends Fragment {

    FragmentApplistBinding binding;
    RecyclerView recyclerView;
    PackageManager packageManager;
    List<PackageInfo> applicationInfos;

    public ApplistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentApplistBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String s[] = getResources().getStringArray(R.array.array);
        recyclerView = binding.recycleview;
        applicationInfos=getActivity().getPackageManager().getInstalledPackages(0);
        List<Application> apps = new ArrayList<>();

        for (int i=0;i<applicationInfos.size();i++){
            PackageInfo packageInfo = applicationInfos.get(i);
            if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)==0){
                Application application = new Application(packageInfo.applicationInfo.loadLabel(getActivity().getPackageManager()).toString(),packageInfo.applicationInfo.loadIcon(getActivity().getPackageManager()));
                apps.add(application);
                String appName = packageInfo.applicationInfo.loadLabel(getActivity().getPackageManager()).toString();
                Log.d("APP",appName);
            }
        }

        AppListAdapter appListAdapter = new AppListAdapter(getContext(),apps);
        recyclerView.setAdapter(appListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}
