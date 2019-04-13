package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
                int mapId = MapProvider.getMaps().get(position).getMapId();

                Intent intent = new Intent(SelectMapActivity.this, SmokeListActivity.class);
                intent.putExtra(CURRENT_MAP_KEY, mapId);
                startActivity(intent);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int mapId = MapProvider.getMaps().get(position).getMapId();
                Intent intent = new Intent(SelectMapActivity.this, EditMapActivity.class);
                intent.putExtra(CURRENT_MAP_KEY, mapId);
                startActivity(intent);
                return true;
            }
        });
    }

    public void AddMapHandler(View view) {
        Intent intent = new Intent(this, EditMapActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
