package com.qf.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.administrator.androidproject.MyActivity;
import com.example.administrator.androidproject.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.qf.Adapter.MyKitAdapter;
import com.qf.Bean.MyKit;
import com.qf.Utils.HandlerKitUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-9-3.
 */
public class MyCollegeFragment extends Fragment {
    private  static final  String URL_STRING="http://api.fengniao.com/app_ipad/" +
            "news_list.php?appImei=000000000000000" +
            "&osType=Android&osVersion=4.1.1&cid=190&page=1 ";
    private  static  int page=1;

    PullToRefreshGridView pullToRefreshGridView;
    List<MyKit.ListBean> datalist;
    HandlerKitUtils handlerKitUtils;
    MyKitAdapter adapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 2:

                    datalist.addAll((List<MyKit.ListBean>) msg.obj);

                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    public MyCollegeFragment getCollegeFragment(String url) {
        MyCollegeFragment myCollegeFragment= new MyCollegeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        myCollegeFragment.setArguments(bundle);
        return myCollegeFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1_kit,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pullToRefreshGridView= (PullToRefreshGridView) view.findViewById(R.id.gridView1Id);

        datalist=new ArrayList<>();

        initData();
        adapter=new MyKitAdapter(getActivity(),datalist);
        pullToRefreshGridView.setAdapter(adapter);
        pullToRefreshGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Intent intent=new Intent(getActivity(), MyActivity.class);
                Intent intent=new Intent(getActivity(),MyActivity.class);
                // intent.setAction("com.qf.kit");
                intent.putExtra("urlString",datalist.get(position).getDoc_url());
                Log.d("aaa",""+datalist.get(position).getDoc_url());
                startActivity(intent);
            }
        });

        pullToRefreshGridView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                page++;
                handlerKitUtils.downLoadString(URL_STRING+page);
                adapter.notifyDataSetChanged();
                pullToRefreshGridView.onRefreshComplete();
            }
        });
    }
    private void initData() {
        String stringUrl=getArguments().getString("url");
        handlerKitUtils=new HandlerKitUtils(handler);
        handlerKitUtils.downLoadString(stringUrl);
    }
}
