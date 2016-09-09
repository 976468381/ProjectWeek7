package com.qf.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 16-9-8.
 */
public class MyHeadKitFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public MyHeadKitFragmentAdapter(FragmentManager fm, List<Fragment> list) {
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
