package com.qf.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 16-9-7.
 */
public class MyHeadFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public MyHeadFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("ccc", "" + list.get(position));
        return list.get(position);

    }

    @Override
    public int getCount() {
        return list.size();
    }
}
