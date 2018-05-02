package com.chaeniiz.colco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
    }
}
