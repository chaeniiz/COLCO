package com.chaeniiz.colco.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chaeniiz.colco.ui.fragment.FeedTabHottestFragment;
import com.chaeniiz.colco.ui.fragment.FeedTabLatestFragment;

public class FeedTabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public FeedTabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FeedTabHottestFragment feedTabHottestFragment = new FeedTabHottestFragment();
                return feedTabHottestFragment;
            case 1:
                FeedTabLatestFragment feedTabLatestFragment = new FeedTabLatestFragment();
                return feedTabLatestFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
