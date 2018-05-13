package com.chaeniiz.colco;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class VoteTabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public VoteTabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                VoteTabCosmeticFragment voteTabCosmeticFragment = new VoteTabCosmeticFragment();
                return voteTabCosmeticFragment;
            case 1:
                VoteTabHairFragment voteTabHairFragment = new VoteTabHairFragment();
                return voteTabHairFragment;
            case 2:
                VoteTabFashionFragment voteTabFashionFragment = new VoteTabFashionFragment();
                return voteTabFashionFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
