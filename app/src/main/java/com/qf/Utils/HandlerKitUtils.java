package com.qf.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.qf.Bean.MyKit;
import com.qf.Bean.MySift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 16-9-6.
 */
public class HandlerKitUtils {
   List<MyKit.ListBean> list;
    Handler handler;

    public HandlerKitUtils(Handler handler) {
        this.handler = handler;
    }

    public static ExecutorService executor = Executors.newFixedThreadPool(20);

    public void downLoadString(final String url) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String jsonString = DownLoadUtils.getJsonString(url);
                Log.d("Qinsz", "jsonString2" + jsonString);
               Gson gson = new Gson();
                list=new ArrayList<MyKit.ListBean>();
               MyKit myKit=gson.fromJson(jsonString,MyKit.class);

                list=myKit.getList();

                if (list==null){return;}
                Message message = new Message();
                message.what = 2;
                message.obj = list;
                handler.sendMessage(message);
            }
        });

    }

    public static void downLoadImage(final String url, final Handler handler, final ImageView imageView) {
        //?线程池分配一个子线程

        executor.execute(new Runnable() {
        @Override
            public void run() {
                // TODO Auto-generated method stub
                final byte[] imageByte = DownLoadUtils.getImageByte(url);

                if (imageByte == null) {
                    return;
                }
              //  final Bitmap bitmap = BitmapFactory.
                   //     decodeByteArray(imageByte, 0, imageByte.length);

            final Bitmap bitmap= OptionBitmap.getOptionBitmap(imageByte);
             handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (imageView.getTag()!=null&&imageView.getTag().equals(url))
                        {
                 imageView.setImageBitmap(bitmap);}}

                });
            }
        });
    }
}