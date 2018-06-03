package com.chaeniiz.colco.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chaeniiz.colco.R;

public class UploadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);

        Button btnUploadFeed = (Button) findViewById(R.id.btn_upload_feed);
        Button btnUploadItem = (Button) findViewById(R.id.btn_upload_item);

        btnUploadFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadActivity.this, UploadFeedActivity.class);
                startActivity(intent);
            }
        });

        btnUploadItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadActivity.this, UploadItemActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_upload;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.menu_upload;
    }

}
