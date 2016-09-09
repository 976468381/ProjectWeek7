package com.qf.Utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by Administrator on 16-8-26.
 */
//初始化lruCache
public class LruUtils {
    LruCache<String,Bitmap> lruCache;
    public LruCache initLru(){
        int maxSize=4*1024*1024;
       return lruCache=new LruCache<>(maxSize);
};


    //从缓存中取图片
   public Bitmap getImageBitmap(String url) {
       if (lruCache != null) {
           return lruCache.get(url);
       }
       return  null;

   }
    //将图片存入缓存
    public void saveImageBitmap(String url,Bitmap bitmap) {
        if (getImageBitmap(url) == null) {
            lruCache.put(url, bitmap);
        }

    }
   public void deleteImageBitmap(String url){
       if (getImageBitmap(url)!= null) {
           lruCache.remove(url);
       }
   }
}