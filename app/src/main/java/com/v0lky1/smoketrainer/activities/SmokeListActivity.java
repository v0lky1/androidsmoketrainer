package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.v0lky1.smoketrainer.compoundcontrollers.SmokeController;
import com.v0lky1.smoketrainer.objects.CounterStrikeMap;
import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.objects.Smoke;
import com.v0lky1.smoketrainer.adapters.SmokeAdapter;
import com.v0lky1.smoketrainer.providers.MapProvider;

import java.util.List;

public class SmokeListActivity extends AppCompatActivity {
    private SmokeAdapter adapter;
    public static String CURRENT_SMOKE_KEY = "smoke_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smokelist_activity);

        ListView lv = findViewById(R.id.listViewSmoke);
        final WebView wb = findViewById(R.id.webView1);
        wb.loadUrl("about: blank");

        final int mapId = getIntent().getIntExtra(SelectMapActivity.CURRENT_MAP_KEY, -1);
        CounterStrikeMap map = MapProvider.returnById(mapId);

        final List<Smoke> smokes = map.getSmokes();


        wb.getSettings();
        wb.setBackgroundColor(Color.TRANSPARENT);

        adapter = new SmokeAdapter(this, smokes);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new SmokeController(smokes, wb));
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SmokeListActivity.this, EditSmokeActivity.class);
                intent.putExtra(SelectMapActivity.CURRENT_MAP_KEY, mapId);
                intent.putExtra(CURRENT_SMOKE_KEY, smokes.get(position).getSmokeId());
                finish();
                startActivity(intent);
                return true;
            }
        });
    }

    public void clickHandler(View view) {
        String map = getIntent().getStringExtra(SelectMapActivity.CURRENT_MAP_KEY);
        Intent intent = new Intent(this, EditSmokeActivity.class);
        intent.putExtra(SelectMapActivity.CURRENT_MAP_KEY, map);
        finish();
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
