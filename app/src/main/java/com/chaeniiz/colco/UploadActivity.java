package com.chaeniiz.colco;

import android.os.Bundle;

public class UploadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_upload;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.menu_upload;
    }
}
