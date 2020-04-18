package com.example.securex.applock;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.securex.R;

import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppViewHolder> {

    Context context;
    List<Application> s;

    public AppListAdapter(Context context,List<Application> s){
        this.context= context;
        this.s=s;
    }


    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.recycleviewcard,parent,false);
        return new AppViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        holder.description.setText(s.get(position).getName());
        holder.icon.setImageDrawable(s.get(position).getIcon());


    }

    @Override
    public int getItemCount() {
        return s.size();
    }

    public class AppViewHolder extends RecyclerView.ViewHolder{

        TextView description;
        ImageView icon;

        public AppViewHolder(@Nullable View itemView){
            super(itemView);
            description =itemView.findViewById(R.id.description);
            icon=itemView.findViewById(R.id.icon);
        }

        }

}
