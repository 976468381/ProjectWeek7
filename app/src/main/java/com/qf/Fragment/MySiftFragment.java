package com.qf.Fragment;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.administrator.androidproject.MyActivity;
import com.example.administrator.androidproject.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qf.Adapter.MyFragment1Adapter;
import com.qf.Adapter.MyHeadFragmentAdapter;
import com.qf.Adapter.MySiftAdapter;
import com.qf.Bean.MySift;
import com.qf.Utils.DownLoadUtils;
import com.qf.Utils.HandlerUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.internal.framed.FrameReader;


/**
 * Created by Administrator on 16-9-3.
 */
public class MySiftFragment extends Fragment {

   MyHeadFragmentAdapter myHeadFragmentAdapter;
    private  static final  String URL_STRING="http://api.fengniao.com/app_ipad/" +
            "news_jingxuan.php?appImei" +
            "=000000000000000&osType=Android&osVersion=4.1.1&page=1";
    private  static  int page=1;
    PullToRefreshListView pullToRefreshListView;
    Map<String, MySift.HeadlineBean> headlineBeanMap;
    List<Map<String, MySift.HeadlineBean>> headline;
    List<MySift.ContentBean> content;
    Map<String, Object> map;
    HandlerUtils handlerUtils;
    MySiftAdapter adapter;
   Handler handler2=new Handler();
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    map = new HashMap<>();
                    map = (Map<String, Object>) msg.obj;
                    headlineBeanMap = new HashMap<>();
                    headlineBeanMap=(Map<String, MySift.HeadlineBean>) map.get("headline");
                    Log.d("lc","headlinebeanamap==="+headlineBeanMap.size());
                    headline.add(headlineBeanMap);
                    Log.d("Qinsz", "headline" + headline.get(0).get("left").getTitle());
                    content.addAll((List<MySift.ContentBean>)map.get("content"));
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };


       public MySiftFragment getSiftFragment(String url) {
        MySiftFragment mySiftFragment = new MySiftFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        mySiftFragment.setArguments(bundle);
        return mySiftFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1_sift, null);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.listView1Id);
        headline = new ArrayList<>();
        content=new ArrayList<>();
        initData();
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),MyActivity.class);
                intent.putExtra("urlString",content.get(position - 1 - (position / 5)).getDoc_url());
               startActivity(intent);
            }
        });


      // ImageView imageView=new ImageView(getActivity().getApplicationContext());
    // imageView.setImageResource(R.drawable.bmi_logo);
     //pullToRefreshListView.getRefreshableView().addHeaderView(imageView);


        List<Fragment> dataheads=new ArrayList<>();
        View view1=LayoutInflater.from(getContext()).inflate(R.layout.item_viewpager,null);
        ViewPager viewPager = (ViewPager) view1.findViewById(R.id.viewPagerHead1Id);
        dataheads.add(new HeadSiftFragment().getHeadSiftFragment(0));
        dataheads.add(new HeadSiftFragment().getHeadSiftFragment(1));
        dataheads.add(new HeadSiftFragment().getHeadSiftFragment(2));

        Log.d("ccc", "" + dataheads.size());
        myHeadFragmentAdapter=new MyHeadFragmentAdapter(getChildFragmentManager(),dataheads);
        viewPager.setAdapter(myHeadFragmentAdapter);

        pullToRefreshListView.getRefreshableView().addHeaderView(view1);
        adapter = new MySiftAdapter(getActivity(), headline, content);
        pullToRefreshListView.setAdapter(adapter);



        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                 page++;
                handlerUtils.downLoadString(URL_STRING+page);
                adapter.notifyDataSetChanged();
                pullToRefreshListView.onRefreshComplete();
            }
        });


        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Intent intent=new Intent(getActivity(), MyActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initData() {
        String urlString = getArguments().getString("url");

        handlerUtils = new HandlerUtils(handler);
        handlerUtils.downLoadString(urlString);

    }

}
