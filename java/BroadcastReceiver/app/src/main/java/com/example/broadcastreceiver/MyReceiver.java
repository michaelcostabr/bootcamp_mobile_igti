package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            Toast.makeText(context, "Broadcast recebido: Airplane mode ativado.", Toast.LENGTH_LONG).show();
        } else if (intent.ACTION_BATTERY_LOW.equals(intent.getAction())) {
            Toast.makeText(context, "Broadcast recebido: Bateria baixa.", Toast.LENGTH_LONG).show();
        }
    }
}
