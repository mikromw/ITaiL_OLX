package com.example.asus.olxtest.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.asus.olxtest.fragment.ExploreFragment;
import com.example.asus.olxtest.fragment.FriendFragment;

/**
 * Created by ASUS on 11/25/2017.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        return new FriendFragment();
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 4;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return"Chat";

            case 1:
                return"Berita OLX";

            case 2:
                return"Aktivitas";

            default:
                return null;
        }
    }

}