package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.v0lky1.smoketrainer.compoundcontrollers.SmokeController;
import com.v0lky1.smoketrainer.models.CounterStrikeMap;
import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.models.Smoke;
import com.v0lky1.smoketrainer.adapters.SmokeAdapter;
import com.v0lky1.smoketrainer.providers.MapProvider;

import java.util.List;

import static com.v0lky1.smoketrainer.activities.SelectMapActivity.CURRENT_MAP_KEY;

public class SmokeListActivity extends AppCompatActivity {
    private SmokeAdapter adapter;
    public static String CURRENT_SMOKE_KEY = "smoke_key";

    /**
     * Laad de webview in en daarnaast luistert hij naar eventuele onclicks door gebruik
     * te maken van de SmokeController class. Hij heeft ook een longclick item listener die
     * de EditSmokeActivity zal starten.
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //scherm altijd aan omdat de app paraat moet staan snel een smoke te laten zien (je gebruikt de app tijdens het spelen)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.smokelist_activity);


        ListView lv = findViewById(R.id.listViewSmoke);
        TextView tv = findViewById(R.id.mapNameTextView);
        final WebView wb = findViewById(R.id.webView1);
        wb.loadUrl("about: blank");

        final int mapId = getIntent().getIntExtra(CURRENT_MAP_KEY, -1);
        CounterStrikeMap map = MapProvider.returnById(mapId);

        final List<Smoke> smokes = map.getSmokes();


        wb.getSettings();
        wb.setBackgroundColor(Color.TRANSPARENT);

        adapter = new SmokeAdapter(this, smokes);
        lv.setAdapter(adapter);
        tv.setText(map.getName());

        lv.setOnItemClickListener(new SmokeController(smokes, wb));
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SmokeListActivity.this, EditSmokeActivity.class);
                intent.putExtra(CURRENT_MAP_KEY, mapId);
                intent.putExtra(CURRENT_SMOKE_KEY, smokes.get(position).getSmokeId());
                startActivity(intent);
                return true;
            }
        });
    }

    /**
     * Opent een lege EditSmokeActivity.
     * @param view
     */
    public void clickHandler(View view) {
        int mapId = getIntent().getIntExtra(CURRENT_MAP_KEY, -1);
        Intent intent = new Intent(this, EditSmokeActivity.class);
        intent.putExtra(CURRENT_MAP_KEY, mapId);
        startActivity(intent);
    }

    /**
     * Controleert of er iets is toegevoegd bij het hervatten van deze activiteit.
     */
    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
