package com.qf.Adapter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidproject.R;
import com.qf.Bean.MyKit;
import com.qf.Utils.HandlerUtils;
import com.qf.Utils.LruUtils;

import java.util.List;

/**
 * Created by Administrator on 16-9-6.
 */
public class MyKitAdapter extends BaseAdapter {
    List<MyKit.ListBean> list;
    Context context;
    LruUtils lruUtils;
   Handler khandler=new Handler();
    public MyKitAdapter( Context context,List<MyKit.ListBean> list) {

        this.context = context;
        this.list = list;
        lruUtils=new LruUtils();
        lruUtils.initLru();//初始化lru缓存

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
            convertView= LayoutInflater.from(context).inflate(R.layout.item_kit,null);

            viewHolder=new ViewHolder();
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.imageKitId);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.textKitId);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position).getTitle());
        String imageString=list.get(position).getPic_url();
        viewHolder.imageView.setTag(imageString);
        if (lruUtils.getImageBitmap(imageString)!=null){
            Log.d("zsp","进入缓存---"+lruUtils.getImageBitmap(imageString));
            viewHolder.imageView.setImageBitmap
                    (lruUtils.getImageBitmap(imageString));
        }else {
            HandlerUtils.downLoadImage(imageString,khandler,viewHolder.imageView);
        }


        return convertView;
    }
    class  ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
