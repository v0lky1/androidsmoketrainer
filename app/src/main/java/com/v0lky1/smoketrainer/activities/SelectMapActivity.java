package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.v0lky1.smoketrainer.adapters.MapAdapter;
import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.providers.MapProvider;

public class SelectMapActivity extends AppCompatActivity {
    public static final String CURRENT_MAP_KEY = "map_id_key";
    private MapAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectmap_activity);



        ListView lv = findViewById(R.id.mapList);

        adapter = new MapAdapter(this, MapProvider.getMaps());
        lv.setAdapter(adapter);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mapName = MapProvider.getMaps().get(position).getName();

                Intent intent = new Intent(SelectMapActivity.this, SmokeListActivity.class);
                intent.putExtra(CURRENT_MAP_KEY, mapName);
                startActivity(intent);
            }
        });
    }

    public void AddMapHandler(View view) {
        Intent intent = new Intent(this, CreateMapActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
