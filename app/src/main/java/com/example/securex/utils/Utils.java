package com.example.securex.utils;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.List;

public class Utils {

    private String EXTRA_LAST_APP="EXTRA_LATE_APP";
    private Context context;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    public Utils(Context context){
        this.context=context;
        pref = context.getSharedPreferences("com.android.app.users",context.MODE_PRIVATE);
        editor =pref.edit();

    }
    public boolean isLock(String packageName){
        if(pref.getString(packageName,"").equals("locked")){
            return true;
        }
        return false;

    }

    public void lock(String pk){
        editor.putString(pk,"locked");
        editor.apply();
    }

    public void unlock(String pk){
        editor.putString(pk,"unlocked");
        editor.apply();
    }

    public void  setLastApp(String pk){
        editor.putString(EXTRA_LAST_APP,pk);
        editor.apply();
    }

    public String getLastApp(){
        return pref.getString(EXTRA_LAST_APP,"");
    }

    public void cleanLastApp(){
        editor.remove(EXTRA_LAST_APP);
        editor.commit();
    }






    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static boolean hasUsageStatsPermission(Context context) {
        AppOpsManager appOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow("android:get_usage_stats",
                android.os.Process.myUid(), context.getPackageName());
        boolean granted = mode == AppOpsManager.MODE_ALLOWED;
        return granted;
    }

    UsageStatsManager usageStatsManager;
    public String getLauncherTopApp(){
        ActivityManager manager =(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            usageStatsManager= (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);

        }
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP){
            List<ActivityManager.RunningTaskInfo> taskInfoList = manager.getRunningTasks(1);
            if(null!=taskInfoList && !taskInfoList.isEmpty()){
                return  taskInfoList.get(0).topActivity.getPackageName();
            }
        }
        else{

            long endTime = System.currentTimeMillis();
            long beginTime= endTime - 10000;

            String result ="";
            UsageEvents.Event event = new UsageEvents.Event();
            UsageEvents usageEvents = usageStatsManager.queryEvents(beginTime,endTime);

            while(usageEvents.hasNextEvent()){
                usageEvents.getNextEvent(event);
                if(event.getEventType()==UsageEvents.Event.MOVE_TO_FOREGROUND){
                    result = event.getPackageName();
                }
            }
            if(!TextUtils.isEmpty(result)){
                Log.d("APP",result);
                return result;
            }

        }

        return "";

    }
}
