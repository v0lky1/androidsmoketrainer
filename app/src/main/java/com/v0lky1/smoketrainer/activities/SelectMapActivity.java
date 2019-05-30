package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.v0lky1.smoketrainer.adapters.MapAdapter;
import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.providers.MapProvider;


public class SelectMapActivity extends AppCompatActivity {
    public static final String CURRENT_MAP_KEY = "map_id_key";
    private MapAdapter adapter;

    /**
     * Regelt dat de listview functionaliteit heeft
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.selectmap_activity);

        ListView lv = findViewById(R.id.mapList);

        adapter = new MapAdapter(this, MapProvider.getMaps());
        lv.setAdapter(adapter);


        /**
         * Haalt het MapId op van het geklikte item
         * zodat we het mee kunnen geven aan een nieuwe intent die het
         * tweede lijstje ophaalt: de smokes.
         */
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int mapId = MapProvider.getMaps().get(position).getMapId();

                Intent intent = new Intent(SelectMapActivity.this, SmokeListActivity.class);
                intent.putExtra(CURRENT_MAP_KEY, mapId);
                startActivity(intent);
            }
        });

        /**
         * Haalt wederom het MapId op om hem door te sturen naar de editmap activity.
         */
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

    /**
     * Onclick van onze ImageView die verwijst naar de editmapactivity class.
     * @param view
     */
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
