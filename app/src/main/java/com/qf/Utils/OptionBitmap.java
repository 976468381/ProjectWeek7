package com.qf.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Administrator on 16-8-26.
 */
//二次采样的工具类
public class OptionBitmap {
    public  static Bitmap getOptionBitmap(byte[] bytes){
        int width=0;
        int height=0;
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        //第一次拿到图片的边缘
        BitmapFactory.decodeByteArray(bytes,0,bytes.length,options);
        //一次采样
        width=options.outWidth;
        height=options.outHeight;



        //使用宽高设置压缩比例；
       // options.inSampleSize=Math.max(width,height)/300;
        options.inSampleSize=5;
        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length,options);
    }
}
