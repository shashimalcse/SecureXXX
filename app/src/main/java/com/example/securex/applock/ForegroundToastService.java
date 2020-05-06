package com.example.securex.applock;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.securex.R;
import com.rvalerio.fgchecker.AppChecker;

import java.util.List;

public class ForegroundToastService extends Service {

    private final static int NOTIFICATION_ID = 1234;
    private final static String STOP_SERVICE = ForegroundToastService.class.getPackage()+".stop";
    public static final String CHANNEL_ID = "ForegroundServiceChannel";
    private BroadcastReceiver stopServiceReceiver;
    private AppChecker appChecker;
    private boolean unlocked;
    Intent dialogIntent;
    String current_app;
    String prev_app;


    public static void start(Context context) {
        context.startService(new Intent(context, ForegroundToastService.class));
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, ForegroundToastService.class));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dialogIntent = new Intent(this,UnlockActivity.class);
        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        registerReceivers();
        startChecker();
        createNotificationChannel();
        createStickyNotification();
        current_app="";
        prev_app="";
        unlocked=false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopChecker();
        removeNotification();
        unregisterReceivers();
        stopSelf();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notificationIntent = new Intent(this,PermissionActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);

        Notification notification = createStickyNotification();

        startForeground(1,notification);

        return START_NOT_STICKY;
    }

    private void startChecker() {
        appChecker = new AppChecker();
        appChecker
                .when(getPackageName(), new AppChecker.Listener() {
                    @Override
                    public void onForeground(String packageName) {

//                        Toast.makeText(getBaseContext(), "Our app is in the foreground.", Toast.LENGTH_SHORT).show();
                    }
                })
                .whenOther(new AppChecker.Listener() {
                    @Override
                    public void onForeground(final String packageName) {
                        Log.d("PACKGE",packageName);
                        Log.d("CURRET",current_app);
                        Log.d("PREV",prev_app);
                        if(packageName.equals("com.example.lock") && !current_app.equals(packageName) && !prev_app.equals(current_app)){
                            Log.d("CHECK","FUCK");
                            unlocked=true;
                            startActivity(dialogIntent);
                            new android.os.Handler().postDelayed(
                                    new Runnable() {
                                        public void run() {
                                            current_app=packageName;

                                        }
                                    },
                                    200);





                        }
                        if(unlocked && !packageName.equals(current_app)){
                            prev_app=current_app;
                            current_app=packageName;
                        }



//                        Toast.makeText(getBaseContext(), "Foreground: " + packageName, Toast.LENGTH_SHORT).show();
                    }
                })
                .timeout(100)
                .start(this);
    }

    private void stopChecker() {
        appChecker.stop();
    }

    private void registerReceivers() {
        stopServiceReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                stopSelf();
            }
        };
        registerReceiver(stopServiceReceiver, new IntentFilter(STOP_SERVICE));
    }

    private void unregisterReceivers() {
        unregisterReceiver(stopServiceReceiver);
    }

    private Notification createStickyNotification() {
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("SecureX")
                .build();
        return notification;
    }

    private void removeNotification() {
        NotificationManager manager = ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
        manager.cancel(NOTIFICATION_ID);
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
}
