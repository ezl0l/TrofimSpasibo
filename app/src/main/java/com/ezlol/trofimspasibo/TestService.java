package com.ezlol.trofimspasibo;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TestService extends Service {
    private MyThread myThread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(myThread == null) {
            myThread = new MyThread();
            myThread.start();
        }

        Notification notification =
                new Notification.Builder(this, Config.DEFAULT_NOTIFICATION_CHANNEL)
                        .setContentTitle("GPS")
                        .setContentText("Search for places")
                        .build();

        startForeground(101, notification);

        return START_STICKY;
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            Log.d(getClass().getSimpleName(), "Поток в сервисе запустился, шото начал делоть!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(getClass().getSimpleName(), "Поток в сервисе завершился, закончил шото делоть!");
        }
    }
}
