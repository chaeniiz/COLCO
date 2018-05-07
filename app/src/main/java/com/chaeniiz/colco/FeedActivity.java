package com.chaeniiz.colco;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

public class FeedActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("HOTTEST"));
        tabLayout.addTab(tabLayout.newTab().setText("LATEST"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        FeedTabPagerAdapter pagerAdapter = new FeedTabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_feed;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.menu_feed;
    }
}
