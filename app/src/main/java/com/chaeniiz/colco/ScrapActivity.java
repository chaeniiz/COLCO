package com.chaeniiz.colco;

import android.os.Bundle;

public class ScrapActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_scrap;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.menu_scrap;
    }
}
