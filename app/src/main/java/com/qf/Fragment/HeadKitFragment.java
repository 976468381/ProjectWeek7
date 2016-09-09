package com.qf.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.Bean.MyHeadImage;
import com.qf.Utils.DownLoadUtils;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 16-9-7.
 */
public class HeadKitFragment extends Fragment {
    private  static final  String URL_STRING="http://api.fengniao.com/app_ipad//focus" +
            "_pic.php?appImei=000000000000000&" +
            "osType=Android&osVersion=4.1.1&mid=19929 ";
    private  static  int num;
    ImageView imageView;
    TextView textView;
Handler handler=new Handler();

    public HeadKitFragment getHeadKitFragment(int number){
        HeadKitFragment headKitFragment=new HeadKitFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("num",number);
        headKitFragment.setArguments(bundle);
        return  headKitFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentsift_head,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView= (ImageView) view.findViewById(R.id.imageSiftHead);
        textView= (TextView) view.findViewById(R.id.textTiftHead);
        final int num=getArguments().getInt("num");

        new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonString = DownLoadUtils.getJsonString(URL_STRING);
                Gson gson = new Gson();
                Type type=new TypeToken<List<MyHeadImage>>(){}.getType();
                List<MyHeadImage> myHeadImage=gson.fromJson(jsonString,type);
               /* int i=0;
                for (;i<myHeadImage.size();i++){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                if (myHeadImage==null){return;}
                 final String string=myHeadImage.get(num).getTitle();
                    final String imageUrl=myHeadImage.get(num).getPic_src();

                    byte[] bytes=DownLoadUtils.getImageByte(imageUrl);
                    final Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                    Log.d("ccc", "" + string);
                    Log.d("ccc", "" + imageUrl);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(string);
                            imageView.setImageBitmap(bitmap);
                        }
                    });

             //if (i==2){i=0;}



            }
        }).start();
 }
}
