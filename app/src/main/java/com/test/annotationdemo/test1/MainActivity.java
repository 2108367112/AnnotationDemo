package com.test.annotationdemo.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.test.annotationdemo.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @ActionListenerFor(listener = ClickProcess.class)
    private Button btnAnnotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAnnotation = findViewById(R.id.btn_annotation);
        ActionListenerForProcessor.processAnnotations(this);
    }
}