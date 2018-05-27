package com.chaeniiz.colco.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chaeniiz.colco.ui.fragment.VoteTabCosmeticFragment;
import com.chaeniiz.colco.ui.fragment.VoteTabFashionFragment;
import com.chaeniiz.colco.ui.fragment.VoteTabHairFragment;

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
