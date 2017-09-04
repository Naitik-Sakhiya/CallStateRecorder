package com.naitiks.callstaterecorder;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by Naitik on 9/4/2017.
 */

public class CallStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int permissionCheck = ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_PHONE_STATE);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context, "Please grant permission first", Toast.LENGTH_SHORT).show();
            return;
        }
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if(TelephonyManager.EXTRA_STATE_RINGING.equals(state)){
            Toast.makeText(context, "Phone is Ringing", Toast.LENGTH_SHORT).show();
        }else if(TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state)){
            Toast.makeText(context, "Call Receiver", Toast.LENGTH_SHORT).show();
        }else if(TelephonyManager.EXTRA_STATE_IDLE.equals(state)){
            Toast.makeText(context, "Phone is Idle", Toast.LENGTH_SHORT).show();
        }
    }
}
