package com.qf.Utils;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.Bean.MyHeadImage;
import com.qf.Bean.MySift;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlerUtils {
    List<MySift> list;
    Handler handler;
    Map<String,MySift.HeadlineBean> headline;
    List<MySift.ContentBean> content;
    Map<String,Object> map;
    Handler handler2=new Handler();

    public HandlerUtils(Handler handler) {
        this.handler = handler;
    }

    public  static ExecutorService executor= Executors.newFixedThreadPool(30);
 public  void downLoadString(final String url) {
      final List<MySift> datas = new ArrayList<>();
      executor.execute(new Runnable() {
         @Override
         public void run() {
            String jsonString = DownLoadUtils.getJsonString(url);
            Log.d("Qinsz", "jsonString" + jsonString);
            String str = jsonString.replace("280280", "headline");
            String str2= str.replace("160120", "content");
             Gson gson = new Gson();
             MySift mySift = gson.fromJson(str2,MySift.class);
             headline=new HashMap<String, MySift.HeadlineBean>();
             headline.put("left",mySift.getHeadline().get(0));
             Log.d("Qinsz", "left" + mySift.getHeadline().get(0));
             headline.put("right",mySift.getHeadline().get(1));
                content=new ArrayList<MySift.ContentBean>();
             content=mySift.getContent();
             Message message=new Message();
             map=new HashMap<>();
             map.put("headline",headline);
             map.put("content",content);
             message.what=1;
             message.obj=map;
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
                final Bitmap bitmap = BitmapFactory.
                        decodeByteArray(imageByte, 0, imageByte.length);
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        });

    }

}
