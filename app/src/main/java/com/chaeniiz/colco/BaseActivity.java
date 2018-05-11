package com.chaeniiz.colco;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

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
                if(previousMenuId.getItemId() == R.id.menu_feed) {
                    startActivity(new Intent(this, FeedActivity.class));
                } else if(previousMenuId.getItemId() == R.id.menu_vote) {
                    startActivity(new Intent(this, VoteActivity.class));
                } else if(previousMenuId.getItemId() == R.id.menu_scrap) {
                    startActivity(new Intent(this, ScrapActivity.class));
                } else if(previousMenuId.getItemId() == R.id.menu_my_page) {
                    startActivity(new Intent(this, MyPageActivity.class));
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
