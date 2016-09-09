package com.qf.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.androidproject.R;
import com.qf.Adapter.MyFragment1Adapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentInfo extends Fragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    ViewPager viewPager1;
    List<Fragment> datalists;
    MyFragment1Adapter adapter;
    RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);

        viewPager1= (ViewPager) view.findViewById(R.id.viewPager1Id);
        radioGroup= (RadioGroup) view.findViewById(R.id.ridioGroup2Id);
        viewPager1.setOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        initdata();
        adapter=new MyFragment1Adapter(getChildFragmentManager(),
                datalists);
        viewPager1.setAdapter(adapter);

 }
   private void initdata() {
        datalists=new ArrayList<>();
        datalists.add(new MySiftFragment().getSiftFragment("http:" +
                "//api.fengniao.com/app_ipad/news_jingxuan.php?" +
                "appImei=000000000000000&osType=Android&osVersion=4.1.1&page=1%20"));
        datalists.add(new MykitFragment().getkitFragment("http://api.fengniao.com" +
                "/app_ipad/news_list.php?appImei=000000000000000&osType=" +
                "Android&osVersion=4.1.1&cid=296&page=1"));
        datalists.add(new MyEffectFragment().getEffectFragment("http://api.fengniao." +
                "com/app_ipad/news_list.php?" +
                "appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=192&page=1"));
        datalists.add(new MyCollegeFragment().getCollegeFragment("http://api.fengniao.com/app_ipad/news_list." +
                "php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=190&page=1 "));

    }
 @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton button;
        for (int i = 0; i <radioGroup.getChildCount() ; i++) {
             button= (RadioButton) radioGroup.getChildAt(i);
            if (i==position){
                button.setTextColor(Color.WHITE);
            }else {
                button.setTextColor(Color.BLACK);
            }

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
       switch (checkedId){
           case R.id.radioButton5Id:
               viewPager1.setCurrentItem(0);
               break;
           case R.id.radioButton6Id:
               viewPager1.setCurrentItem(1);
               break;
           case R.id.radioButton7Id:
               viewPager1.setCurrentItem(2);
               break;
           case R.id.radioButton8Id:
               viewPager1.setCurrentItem(3);
               break;

       }
    }
}