package com.example.administrator.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 16-9-7.
 */
public class MyActivity extends Activity {
    WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.my_actavity);
  webView= (WebView) findViewById(R.id.webViewId);
        Intent itent=getIntent();
        String url = itent.getStringExtra("urlString");
        Log.d("aaa","url"+url);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }


}
