package com.example.smoketrainer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class SmokeListActivity extends AppCompatActivity {

    private class CounterStrikeSmokeWebView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smokebrowser);
        ListView lv = findViewById(R.id.listViewSmoke);

        Intent intent = getIntent();
        String name = intent.getExtras().getString(SelectMapActivity.MAP_ID_KEY);
        CounterStrikeMap map = MapProvider.returnMap(name);

        final List<Smoke> smokes =  SmokeProvider.getSmokes(map.getMapType());
        SmokeAdapter adapter = new SmokeAdapter(this, smokes);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WebView wb = (WebView) findViewById(R.id.webView1);
                wb.getSettings().setJavaScriptEnabled(true);
                wb.getSettings().setLoadWithOverviewMode(true);
                wb.getSettings().setUseWideViewPort(true);
                wb.getSettings().setBuiltInZoomControls(true);
                wb.setWebViewClient(new CounterStrikeSmokeWebView());
                wb.loadUrl(smokes.get(position).getUrl());

            }
        });
    }
}
