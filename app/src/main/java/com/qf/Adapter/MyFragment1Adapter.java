package com.qf.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;


import java.util.List;


public class MyFragment1Adapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public MyFragment1Adapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("ccc", "" +list.get(position));
        return list.get(position);

    }

    @Override
    public int getCount() {
        return list.size();
    }
}
