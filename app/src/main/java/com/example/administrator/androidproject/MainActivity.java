package com.example.administrator.androidproject;


import android.os.Bundle;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.qf.Fragment.FragmentForum;
import com.qf.Fragment.FragmentInfo;
import com.qf.Fragment.FragmentPic;
import com.qf.Fragment.FragmentSetting;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup radioGroup;
    ViewPager viewPager;
    FragmentManager manager;
   FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          initView();
         manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        transaction.add(R.id.LinearLayoutId,new FragmentInfo());
        transaction.commit();

    }
    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.ridioGroupId);
        radioGroup.setOnCheckedChangeListener(this);
   }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioButton1Id:
                transaction=manager.beginTransaction();
                transaction.replace(R.id.LinearLayoutId,new FragmentInfo());
                transaction.commit();
                break;
            case R.id.radioButton2Id:
                transaction=manager.beginTransaction();
                transaction.replace(R.id.LinearLayoutId,new FragmentPic());
                transaction.commit();
                break;
            case R.id.radioButton3Id:
                transaction=manager.beginTransaction();
                transaction.replace(R.id.LinearLayoutId,new FragmentForum());
                transaction.commit();
                break;
            case R.id.radioButton4Id:
                transaction=manager.beginTransaction();
                transaction.replace(R.id.LinearLayoutId,new FragmentSetting());
                transaction.commit();
                break;
        }
    }





}
