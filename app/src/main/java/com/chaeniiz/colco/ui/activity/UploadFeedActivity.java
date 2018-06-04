package com.chaeniiz.colco.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.chaeniiz.colco.R;

import java.io.IOException;

public class UploadFeedActivity extends BaseActivity {

    //RecyclerView rvUploadImage;
    //UploadImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        rvUploadImage = findViewById(R.id.rv_scrap);
//        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        rvUploadImage.setLayoutManager(lm);
//
//        List<UploadImage> items = new ArrayList<>();
//        UploadImage[] item = new UploadImage[10];
//        item[0] = new UploadImage(R.drawable.profile);
//
//        for(int i = 0; i < 10; i++) {
//            items.add(item[i]);
//        }
//
//        rvUploadImage.setAdapter(new UploadImageAdapter(this, items, R.layout.activity_upload_feed));

        ImageButton ibtnUploadFeed = (ImageButton) findViewById(R.id.ibtn_upload_feed);
        ibtnUploadFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

        ImageButton ibtnClose = (ImageButton) findViewById(R.id.btn_close);
        ibtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {
            try {
                Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                ImageView image = (ImageView)findViewById(R.id.iv_image);

                image.setImageBitmap(image_bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_upload_feed;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.menu_upload;
    }
}
