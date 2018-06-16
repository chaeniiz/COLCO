package com.chaeniiz.colco.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageButton;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.data.model.UploadedFeed;
import com.chaeniiz.colco.data.model.UploadedItem;
import com.chaeniiz.colco.ui.adapter.MyPageFeedAdapter;
import com.chaeniiz.colco.ui.adapter.MyPageItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPageActivity extends BaseActivity {

    RecyclerView rvUploadedFeed;
    RecyclerView rvUploadedItem;
    MyPageFeedAdapter myPageFeedAdapter;
    MyPageItemAdapter myPageItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);

        rvUploadedFeed = findViewById(R.id.rv_uploaded_feed);
        rvUploadedItem = findViewById(R.id.rv_uploaded_item);

        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        StaggeredGridLayoutManager sgm2 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvUploadedFeed.setLayoutManager(sgm);
        rvUploadedItem.setLayoutManager(sgm2);

        List<UploadedFeed> feeds = new ArrayList<>();
        UploadedFeed[] feed = new UploadedFeed[8];
        feed[0] = new UploadedFeed(R.drawable.thumbnail);
        feed[1] = new UploadedFeed(R.drawable.thumbnail);
        feed[2] = new UploadedFeed(R.drawable.thumbnail);
        feed[3] = new UploadedFeed(R.drawable.thumbnail);
        feed[4] = new UploadedFeed(R.drawable.thumbnail);
        feed[5] = new UploadedFeed(R.drawable.thumbnail);
        feed[6] = new UploadedFeed(R.drawable.thumbnail);
        feed[7] = new UploadedFeed(R.drawable.thumbnail);

        List<UploadedItem> items = new ArrayList<>();
        UploadedItem[] item = new UploadedItem[8];
        item[0] = new UploadedItem(R.drawable.thumbnail_product, "item name");
        item[1] = new UploadedItem(R.drawable.thumbnail_product, "item name");
        item[2] = new UploadedItem(R.drawable.thumbnail_product, "item name");
        item[3] = new UploadedItem(R.drawable.thumbnail_product, "item name");
        item[4] = new UploadedItem(R.drawable.thumbnail_product, "item name");
        item[5] = new UploadedItem(R.drawable.thumbnail_product, "item name");
        item[6] = new UploadedItem(R.drawable.thumbnail_product, "item name");
        item[7] = new UploadedItem(R.drawable.thumbnail_product, "item name");

        for(int i = 0; i < 8; i++) {
            feeds.add(feed[i]);
            items.add(item[i]);
        }

        myPageFeedAdapter = new MyPageFeedAdapter(this, feeds, R.layout.activity_my_page);
        myPageItemAdapter = new MyPageItemAdapter(this, items, R.layout.activity_my_page);
        rvUploadedFeed.setAdapter(myPageFeedAdapter);
        rvUploadedItem.setAdapter(myPageItemAdapter);

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
