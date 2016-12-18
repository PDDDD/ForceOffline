package com.vv.forceoffline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by VV on 2016/12/18.
 */

public class BaseActivity extends AppCompatActivity {

    private ForceOfflineBroadcast forceOfflineBroadcast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        forceOfflineBroadcast = new ForceOfflineBroadcast();
        registerReceiver(forceOfflineBroadcast, new IntentFilter("com.vv.forceoffline.FORCE_OFFLINE"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(forceOfflineBroadcast);
    }

    class ForceOfflineBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            if (intent.getAction().equals("com.vv.forceoffline.FORCE_OFFLINE")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("您已在其他地方登录，请重新登录");
                builder.setCancelable(false);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent1 = new Intent(context, LoginActivity.class);
                        startActivity(intent1);
                        ActivityCollector.finishAll();
                    }
                });
                builder.create().show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
