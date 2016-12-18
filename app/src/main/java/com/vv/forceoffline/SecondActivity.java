package com.vv.forceoffline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onSkip(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
