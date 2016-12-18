package com.vv.forceoffline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button forceOfflineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forceOfflineButton = (Button) findViewById(R.id.btn_force_offline);
        forceOfflineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.vv.forceoffline.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }

}
