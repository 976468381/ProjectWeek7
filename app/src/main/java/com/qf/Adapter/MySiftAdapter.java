package com.qf.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidproject.MyActivity;
import com.example.administrator.androidproject.R;
import com.qf.Bean.MySift;
import com.qf.Utils.HandlerUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-9-5.
 */
public class MySiftAdapter extends BaseAdapter {
    Context context;

    List<Map<String, MySift.HeadlineBean>> headline;
    List<MySift.ContentBean> content;
    Handler mhandler = new Handler();

    public MySiftAdapter(Context context, List<Map<String, MySift.HeadlineBean>> headline, List<MySift.ContentBean> content) {
        this.context = context;
        this.headline = headline;
        this.content = content;
        Log.d("lc", "content====" + content.size());
        Log.d("lc", "headline====" + headline.size());
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 5 == 0) {
            return 0;
        } else {
            return 1;
        }
    }


    @Override
    public int getCount() {

        return headline.size() + content.size();
    }

    @Override
    public Object getItem(int position) {
        if (position % 5 == 0) {
            return headline.get(position / 5);
        } else {
            return content.get(position - 1 - (position / 5));
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        if (convertView == null) {
            switch (type) {
                case 0:
                    viewHolder1 = new ViewHolder1();
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_sift1, null);
                    viewHolder1.textView1 = (TextView) convertView.findViewById(R.id.text1Id);
                    viewHolder1.textView2 = (TextView) convertView.findViewById(R.id.text2Id);
                    viewHolder1.imageView1 = (ImageView) convertView.findViewById(R.id.image1Id);
                    viewHolder1.imageView2 = (ImageView) convertView.findViewById(R.id.image2Id);
                    convertView.setTag(viewHolder1);
                    break;
                case 1:
                    viewHolder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_sift2, null);
                    viewHolder2.textView3 = (TextView) convertView.findViewById(R.id.text3Id);
                    viewHolder2.textView4 = (TextView) convertView.findViewById(R.id.text4Id);
                    viewHolder2.imageView3 = (ImageView) convertView.findViewById(R.id.image3Id);
                    convertView.setTag(viewHolder2);
                    break;
            }

        } else {
            switch (type) {
                case 0:
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                    break;
                case 1:
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    break;
            }
        }
        switch (type) {
            case 0:
                viewHolder1.textView1.setText(headline.get(position / 5).get("left").getTitle());
                Log.d("Qinsz", " " + headline.get(position / 5).get("left").getTitle());

                viewHolder1.textView2.setText(headline.get(position / 5).get("right").getTitle());
                String imageString1 = headline.get(position / 5).get("left").getPic_url();
                String imageString2 = headline.get(position / 5).get("right").getPic_url();
                HandlerUtils.downLoadImage(imageString1, mhandler, viewHolder1.imageView1);
                HandlerUtils.downLoadImage(imageString2, mhandler, viewHolder1.imageView2);
                viewHolder1.imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case R.id.image1Id:
                                Intent intent = new Intent(context, MyActivity.class);
                                // intent.setAction("com.qf.kit");
                                intent.putExtra("urlString", headline.get(position).get("left").getDoc_url());
                                context.startActivity(intent);
                                break;

                        }
                    }
                });
                viewHolder1.imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {

                            case R.id.image2Id:
                                Intent intent2 = new Intent(context, MyActivity.class);
                                // intent.setAction("com.qf.kit");
                                intent2.putExtra("urlString", headline.get(position).get("right").getDoc_url());
                                context.startActivity(intent2);
                                break;
                        }
                    }
                });

                break;

            case 1:
                viewHolder2.textView3.setText(content.get(position - 1 - (position / 5)).getTitle());
                viewHolder2.textView4.setText(content.get(position - 1 - (position / 5)).getDate());
                String imageString3 = content.get(position - 1 - (position / 5)).getPic_url();
                HandlerUtils.downLoadImage(imageString3, mhandler, viewHolder2.imageView3);

        }
        return convertView;
    }


    class ViewHolder1 {
        ImageView imageView1, imageView2;
        TextView textView1, textView2;
    }

    class ViewHolder2 {
        ImageView imageView3;
        TextView textView3, textView4;
    }
}
