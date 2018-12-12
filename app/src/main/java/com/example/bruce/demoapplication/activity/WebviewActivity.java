package com.example.bruce.demoapplication.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.bruce.demoapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebviewActivity extends AppCompatActivity {

    @BindView(R.id.button) Button button;
    @BindView(R.id.button2) Button button2;
    @BindView(R.id.button3) Button button3;
    @BindView(R.id.webview) WebView webView;

    String url = "https://www.html5case.com.cn/case/iqiyi/2/";
//    String url = "https://wenxue.iqiyi.com/";
//String url = "https://www.baidu.com/";

    WebSettings webSettings;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_webview);
        ButterKnife.bind(this);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
                return false;
            }
        });

        webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
//        webSettings.setLightTouchEnabled(true);
        webSettings.setBlockNetworkImage(false);

        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
//        webSettings.setBlockNetworkImage(true);
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);

        webSettings.setAppCacheEnabled(true);
        String appCaceDir = this.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
        webSettings.setAppCachePath(appCaceDir);

        webSettings.setAppCacheMaxSize(8 * 1024 * 1024);   //缓存最多可以有8M
        webSettings.setAllowFileAccess(true);   // 可以读取文件缓存(manifest生效)



        webSettings.setUseWideViewPort(true);

        button.setOnClickListener( v-> webView.loadUrl(url));

        webView.setOnLongClickListener(v -> {
            WebView.HitTestResult result = webView.getHitTestResult();
            String extra = result.getExtra();
            switch (result.getType()) {
                case WebView.HitTestResult.IMAGE_TYPE:
                    byte[] bytes = Base64.decode("", Base64.DEFAULT);
                    break;
                case WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE:

                    break;
            }
            return true;
        });

//        webView.loadUrl("https://www.baidu.com/");
    }
}
