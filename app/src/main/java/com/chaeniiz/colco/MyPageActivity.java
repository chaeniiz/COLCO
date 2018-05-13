package com.chaeniiz.colco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MyPageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);

        ImageButton btnSetting = (ImageButton) findViewById(R.id.btn_setting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyPageActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_my_page;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.menu_my_page;
    }
}
