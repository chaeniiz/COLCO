package com.chaeniiz.colco.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.ui.view.UploadDialog;

public class UploadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UploadDialog uploadDialog = new UploadDialog(this);
        uploadDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        uploadDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        uploadDialog.show();
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
