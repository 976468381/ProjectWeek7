package com.qf.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.androidproject.MyActivity;
import com.example.administrator.androidproject.MyActivity2;
import com.example.administrator.androidproject.R;
import com.qf.Bean.MyForum;

/**
 * Created by Administrator on 16-9-8.
 */
public class FragmentForumRight extends Fragment {
    FragmentManager manager;
    FragmentTransaction transaction;
    ListView listView;
    static int number=0;
    String[][] right={{"热帖","精华帖","最新帖子","最新回复"}
            ,{"人像","风光","纪实","人体","儿童","人体","建筑","生态","宠物"},
            {"商业","女性视觉","新手","数码","黑白","实验","生活摄影","高校","手机","葡萄酒"},
            {"交易警示","二手交易","器材维修"},
            {"北京","上海","武汉"},
            {"单反和镜头","大中画幅","便携数码"},
            {"活动区","网友服务","蜂鸟茶馆"}};
    ArrayAdapter<String> adapter;

    public FragmentForumRight getRightFragment(int num) {
        FragmentForumRight fragmentForumRight = new FragmentForumRight();
        Bundle bundle = new Bundle();
        bundle.putInt("num",num);
        fragmentForumRight.setArguments(bundle);
        return fragmentForumRight;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forumright,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentForumRight fragmentForumRight=new FragmentForumRight();
        listView= (ListView) view.findViewById(R.id.listViewLeft);
         number=getArguments().getInt("num");
         adapter=new ArrayAdapter<String>(getActivity(),android.R.layout
                    .simple_dropdown_item_1line,right[number]);
            listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (number){
                    case 0:
                        Intent intent=new Intent(getActivity(),MyActivity2.class);
                        intent.putExtra("num",position+1);
                        Log.d("SSS",""+position);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent(getActivity(),MyActivity2.class);
                        intent1.putExtra("num",position+5);
                        Log.d("SSS",""+position);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent(getActivity(),MyActivity2.class);
                        intent2.putExtra("num",position+14);
                        Log.d("SSS",""+position);
                        startActivity(intent2);
                        break;
         }

       }
        });
    }
}
