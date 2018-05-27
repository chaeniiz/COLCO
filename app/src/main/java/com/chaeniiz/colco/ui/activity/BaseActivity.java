package com.chaeniiz.colco.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.chaeniiz.colco.R;

public abstract class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    protected BottomNavigationView navigationView;
    MenuItem previousMenuId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateNavigationBarState();
        previousMenuId = navigationView.getMenu().findItem(navigationView.getSelectedItemId());
        Log.e("previousMenuId: ", String.valueOf(previousMenuId));
        Log.e("content view id: ", String.valueOf(getContentViewId()));
    }

    // Remove inter-activity transition to avoid screen tossing on tapping bottom navigation items
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        navigationView.postDelayed(() -> {
            int itemId = item.getItemId();
            if (itemId == R.id.menu_feed) {
                startActivity(new Intent(this, FeedActivity.class));
            } else if (itemId == R.id.menu_vote) {
                startActivity(new Intent(this, VoteActivity.class));
            } else if (itemId == R.id.menu_upload) {
                if(getContentViewId() == R.layout.activity_feed) {
                    startActivity(new Intent(this, FeedActivity.class));
                } else if(getContentViewId() == R.layout.activity_vote) {
                    startActivity(new Intent(this, VoteActivity.class));
                } else if(getContentViewId() == R.layout.activity_scrap) {
                    startActivity(new Intent(this, ScrapActivity.class));
                } else if(getContentViewId() == R.layout.activity_my_page) {
                    startActivity(new Intent(this, MyPageActivity.class));
                } else if(getContentViewId() == R.layout.activity_setting) {
                    startActivity(new Intent(this, SettingActivity.class));
                } else if(getContentViewId() == R.layout.activity_upload_feed) {
                    startActivity(new Intent(this, UploadFeedActivity.class));
                } else if(getContentViewId() == R.layout.activity_upload_item) {
                    startActivity(new Intent(this, UploadItemActivity.class));
                }
                startActivity(new Intent(this, UploadActivity.class));
            } else if (itemId == R.id.menu_scrap) {
                startActivity(new Intent(this, ScrapActivity.class));
            } else if (itemId == R.id.menu_my_page) {
                startActivity(new Intent(this, MyPageActivity.class));
            }
            finish();
        }, 300);
        return true;
    }

    private void updateNavigationBarState(){
        int actionId = getNavigationMenuItemId();
        selectBottomNavigationBarItem(actionId);
    }

    void selectBottomNavigationBarItem(int itemId) {
        MenuItem item = navigationView.getMenu().findItem(itemId);
        item.setChecked(true);
    }

    abstract int getContentViewId();

    abstract int getNavigationMenuItemId();

}
