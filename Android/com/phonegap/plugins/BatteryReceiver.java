package com.phonegap.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

public class BatteryReceiver extends BroadcastReceiver {
    private int batteryLevel = 0;

    public int getLevel() {
        return batteryLevel;
    }

	@Override
    public void onReceive(Context arg0, Intent intent) {
		batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
	}
}
