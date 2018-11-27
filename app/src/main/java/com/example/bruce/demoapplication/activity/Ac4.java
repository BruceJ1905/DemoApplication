package com.example.bruce.demoapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.annotation.MyAnnotation;
import com.example.bruce.demoapplication.R;
import com.example.module4.Ac7;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

@MyAnnotation
public class Ac4 extends Activity {
    ImageView imageView;
    WebView webView;

    public static int CNT = 15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac4);

        EventBus.getDefault().register(this);


        CNT = 20;

        imageView = findViewById(R.id.imageView2);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
                return false;
            }
        });


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                webView.loadUrl("https://wenxue.iqiyi.com/");
//                webView.loadUrl("https://wwww.baidu.com/");

//                Intent intent = new Intent(Ac4.this, MyService.class);
//                startService(intent);

                Intent intent = new Intent(Ac4.this, com.example.module2.M2Ac2.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bitmap bitmap = activityShot(Ac4.this);
//                imageView.setImageBitmap(bitmap);

//                Intent intent = new Intent(Ac4.this, Ac5.class);
//                startActivity(intent);
            }
        });

//        int v1 = getIntent().getIntExtra("k1", -1);
//        String v2 = getIntent().getStringExtra("k2");
//        Log.d("intent", v1 + "");
//        Log.d("intent", v2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    public static Bitmap activityShot(Activity activity) {
        /*获取windows中最顶层的view*/
        View view = activity.getWindow().getDecorView();

        //允许当前窗口保存缓存信息
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();

        //获取状态栏高度
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;

        WindowManager windowManager = activity.getWindowManager();

        //获取屏幕宽和高
        DisplayMetrics outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;

        Bitmap src = view.getDrawingCache();
        Log.d("11", src.getWidth() + ", " + src.getHeight());
        Log.d("11", width + ", " + height);


        //去掉状态栏
//        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, statusBarHeight, width,
//                height-statusBarHeight);


        Bitmap bitmap = Bitmap.createScaledBitmap(src, src.getWidth() / 2, src.getHeight() / 2, false);
        Log.d("11", bitmap.getWidth() + ", " + bitmap.getHeight());




        //销毁缓存信息
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);

        return bitmap;
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Subscriber(tag = "m2")
    void onModule2Msg(String msg) {
        Log.d("11", "msg from module2 " + msg);

        Intent intent = new Intent(Ac4.this, Ac7.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("intent", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("intent", "onRestoreInstanceState");

    }
}
