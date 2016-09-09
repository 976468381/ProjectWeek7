package com.example.administrator.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.qf.Adapter.MyForumItemAdapter;
import com.qf.Bean.*;
import com.qf.Bean.MyForum;
import com.qf.Utils.DownLoadUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-9-8.
 */
public class MyActivity2 extends Activity {
    private  static final  String URL_STRING="http://api.fengniao.com/app_ipad/bbs_all_hot." +
            "php?appImei=000000000000000&osType=Android&osVersion=4.1.1&page= ";

    ListView listView;
    List<MyForum.ListBean> datalists;
    MyForumItemAdapter adapter;
    Handler handler=new Handler();
    static  int number;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.fragment_forumitem);
       listView= (ListView) findViewById(R.id.listViewItemId);
        Intent intent=getIntent();
         number=intent.getIntExtra("num",1);
        Log.d("SSS","number"+number);
        initData();

        adapter=new MyForumItemAdapter(getApplicationContext(),datalists);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MyActivity2.this,MyActivity.class);
                intent.putExtra("urlString",datalists.get(position).getDoc_url());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        datalists=new ArrayList<>();
     new Thread(new Runnable() {
            @Override
            public void run() {
           String jsonString = DownLoadUtils.getJsonString(URL_STRING+number);
                Log.d("SSS","jsonString"+jsonString);
                Gson gson = new Gson();

              MyForum myForum=gson.fromJson(jsonString,MyForum.class);
                datalists.addAll(myForum.getList());
                Log.d("SSS","datalists"+datalists);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                     adapter.notifyDataSetChanged();
                    }
                });
                // final int num=intent.getIntExtra("num",1);
 }
        }).start();

    }

}
