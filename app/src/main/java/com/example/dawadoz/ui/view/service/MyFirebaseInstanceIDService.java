package com.example.dawadoz.ui.view.service;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.dawadoz.ui.view.SharedPrefManager;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.List;

import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_ACCESS_TOKEN;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String deviceToken) {
        super.onNewToken(deviceToken);

        storeToken(deviceToken);
    }

    private void storeToken(String deviceToken) {
        SharedPrefManager.getInstance(getApplicationContext()).setValue(KEY_ACCESS_TOKEN, deviceToken);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (!isAppIsInBackground(getApplicationContext())) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), remoteMessage.getNotification().getBody(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private Boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo processInfo : runningAppProcesses) {
            if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                for (String activeProcess : processInfo.pkgList) {
                    if (activeProcess.equals(context.getPackageName())) {
                        isInBackground = false;
                    }
                }
            }
        }
        return isInBackground;
    }
}
