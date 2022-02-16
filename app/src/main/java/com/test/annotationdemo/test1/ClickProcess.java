package com.test.annotationdemo.test1;

import android.util.Log;
import android.view.View;

public class ClickProcess implements View.OnClickListener {

    private static final String TAG = "ClickProcess";

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: 点我吧");
    }
}
