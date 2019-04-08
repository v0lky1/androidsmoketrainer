package com.v0lky1.smoketrainer.views;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CounterStrikeSmokeWebView extends WebViewClient {


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }
}