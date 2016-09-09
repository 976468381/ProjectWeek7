package com.qf.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.androidproject.R;
import com.qf.interfaces.OnGetNum;

public class FragmentForum extends Fragment  {
    FragmentManager manager;
    FragmentTransaction transaction;

    FragmentForumRight forumRight;
    ListView listView;
    String[] left={"全部论坛","题材作品区","全部摄影区",
            "二手交易区","全国分站区","器材讨论区","论坛服务区"};
    ArrayAdapter<String> adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forum,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView= (ListView) view.findViewById(R.id.listViewLeft);
        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout
                .simple_dropdown_item_1line,left);
        listView.setAdapter(adapter);

        manager=getFragmentManager();
        transaction=manager.beginTransaction();
        forumRight=new FragmentForumRight().getRightFragment(0);
        transaction.add(R.id.rightId,forumRight);
        transaction.commit();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                transaction=manager.beginTransaction();
                forumRight=new FragmentForumRight().getRightFragment(position);
                transaction.replace(R.id.rightId,forumRight);
                transaction.commit();
            }
        });
    }


}