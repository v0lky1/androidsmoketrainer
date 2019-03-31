package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

import com.v0lky1.smoketrainer.objects.CounterStrikeMap;
import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.objects.Smoke;
import com.v0lky1.smoketrainer.adapters.SmokeAdapter;
import com.v0lky1.smoketrainer.providers.MapProvider;
import com.v0lky1.smoketrainer.providers.SmokeProvider;

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
        setContentView(R.layout.smokelist_activity);
        ListView lv = findViewById(R.id.listViewSmoke);


        String name = getIntent().getExtras().getString(SelectMapActivity.CURRENT_MAP_KEY);
        CounterStrikeMap map = MapProvider.returnMap(name);
        setTitle(map.getName().toUpperCase());


        final List<Smoke> smokes = SmokeProvider.getSmokeMap().get(map.getMapType());
        final WebView wb = findViewById(R.id.webView1);

        wb.getSettings();
        wb.setBackgroundColor(Color.TRANSPARENT);

        SmokeAdapter adapter = new SmokeAdapter(this, smokes);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                wb.getSettings().setJavaScriptEnabled(true);
                wb.getSettings().setLoadWithOverviewMode(true);
                wb.getSettings().setUseWideViewPort(true);
                wb.getSettings().setBuiltInZoomControls(true);
                wb.setWebViewClient(new CounterStrikeSmokeWebView());
                wb.loadUrl(smokes.get(position).getUrl());

            }
        });
    }

    public void clickHandler(View view) {
        String map = getIntent().getExtras().getString(SelectMapActivity.CURRENT_MAP_KEY);

        Intent intent = new Intent(this, AddNewSmokeActivity.class);
        intent.putExtra(SelectMapActivity.CURRENT_MAP_KEY, map);
        startActivity(intent);
    }
}
