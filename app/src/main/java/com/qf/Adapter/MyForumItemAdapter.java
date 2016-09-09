package com.qf.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidproject.R;
import com.qf.Bean.MyForum;
import com.qf.Utils.HandlerUtils;

import java.util.List;

/**
 * Created by Administrator on 16-9-8.
 */
public class MyForumItemAdapter extends BaseAdapter {
    List<MyForum.ListBean> list;
    Context context;

    public MyForumItemAdapter(Context context, List<MyForum.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_forum,null);

            viewHolder=new ViewHolder();

            viewHolder.textView1= (TextView) convertView.findViewById(R.id.textViewItem1);
            viewHolder.textView2= (TextView) convertView.findViewById(R.id.textViewItem2);
            viewHolder.textView3= (TextView) convertView.findViewById(R.id.textViewItem3);
            viewHolder.textView4= (TextView) convertView.findViewById(R.id.textViewItem4);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView1.setText(list.get(position).getTitle());
        viewHolder.textView2.setText(list.get(position).getAuthor());
        viewHolder.textView3.setText("帖子： "+list.get(position).getViews());
        viewHolder.textView4.setText("回复： "+list.get(position).getReply());
        return convertView;
    }
    class  ViewHolder{

        TextView textView1,textView2,textView3,textView4;
    }
    }

