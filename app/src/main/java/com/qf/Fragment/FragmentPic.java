package com.qf.Fragment;

import android.graphics.Color;
import android.support.annotation.Nullable;


import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.androidproject.R;
import com.qf.Adapter.MyFragment1Adapter;
import java.util.ArrayList;
import java.util.List;


public class FragmentPic extends Fragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    ViewPager viewPager2;
    List<Fragment> datalists2;
    MyFragment1Adapter adapter;
    RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pic, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager2= (ViewPager) view.findViewById(R.id.viewPager1Id);
        radioGroup = (RadioGroup) view.findViewById(R.id.ridioGroup2Id);

        viewPager2.setOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        initdata();
        adapter = new MyFragment1Adapter(getChildFragmentManager(),
                datalists2);
        viewPager2.setAdapter(adapter);

    }

    private void initdata() {
        datalists2= new ArrayList<>();
        datalists2.add(new MyImageFragment2().getImageFragment("http://api.fengniao." +
                "com/app_ipad/pic_bbs_list_v2.php?" +
                "appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=101&page=1"));
        datalists2.add(new MySceneFragment2().getSceneFragment("http://api.fengniao.com/app_ipad/pic_bbs_list_v2" +
                ".php?appImei=0000000000000" +
                "00&osType=Android&osVersion=4.1.1&fid=125&page=1"));
        datalists2.add(new MyZoologyFragment2().getZoologyFragment("http://api.fengniao.com/app_ipad/pic_bb" +
                "s_list_v2.php?appImei=000000000000000&" +
                "osType=Android&osVersion=4.1.1&fid=16&page=1"));
        datalists2.add(new MyDigitalFragment2().getDigitalFragment("http://api.fengniao.com//app_ipad/pic_bbs_list_v2.ph" +
                "p?appImei=00000000000000" +
                "0&osType=Android&osVersion=4.1.1&fid=24&page=1"));
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton button;
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            button = (RadioButton) radioGroup.getChildAt(i);
            if (i == position) {
                button.setTextColor(Color.WHITE);
            } else {
                button.setTextColor(Color.BLACK);
            }

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioButton5Id:
                viewPager2.setCurrentItem(0);
                break;
            case R.id.radioButton6Id:
                viewPager2.setCurrentItem(1);
                break;
            case R.id.radioButton7Id:
                viewPager2.setCurrentItem(2);
                break;
            case R.id.radioButton8Id:
                viewPager2.setCurrentItem(3);
                break;

        }
    }
}