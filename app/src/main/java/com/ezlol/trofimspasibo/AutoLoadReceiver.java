package com.ezlol.trofimspasibo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoLoadReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            context.startForegroundService(new Intent(context, TestService.class));
        }
    }
}
