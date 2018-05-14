package com.chaeniiz.colco;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton ibtnBack = (ImageButton) findViewById(R.id.btn_back);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView tvComplete = (TextView) findViewById(R.id.tv_complete);
        tvComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_setting;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.menu_my_page;
    }
}
