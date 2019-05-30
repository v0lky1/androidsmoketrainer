package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.models.CounterStrikeMap;
import com.v0lky1.smoketrainer.providers.MapProvider;

import java.util.List;

import static com.v0lky1.smoketrainer.activities.SelectMapActivity.CURRENT_MAP_KEY;

public class EditMapActivity extends AppCompatActivity {
    private EditText nameEditText;
    private CounterStrikeMap csMap;
    private int mapId;
    private boolean newMap = false;
    private Button removeMapButton;
    private Button addEditMapButton;

    /**
     * Kijkt welke weergave van het scherm vertoond moet worden, afhankelijk van de staat van
     * de map zie je een verwijder knop of juist niet.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.edit_map_activity);


        nameEditText = findViewById(R.id.editTextMapName);
        removeMapButton = findViewById(R.id.removeMapButton);
        addEditMapButton = findViewById(R.id.buttonAddMap);


        mapId = getIntent().getIntExtra(CURRENT_MAP_KEY, -1);


        if (mapId != -1) {
            addEditMapButton.setText(R.string.edit);
            csMap = MapProvider.returnById(mapId);
            nameEditText.setText(csMap.getName());
            removeMapButton.setVisibility(View.VISIBLE);

        } else {
            newMap = true;
            removeMapButton.setVisibility(View.INVISIBLE);
            csMap = new CounterStrikeMap();
        }
    }

    /**
     * Deze functie zorgt ervoor dat de map ofwel word toegevoegd danwel gewijzigd.
     * @param view
     */
    public void sendAddMapHandler(View view) {

        List<CounterStrikeMap> maps = MapProvider.getMaps();

        String mapName = nameEditText.getText().toString();
        csMap.setName(mapName);

        if (newMap) {
            maps.add(csMap);
        }
        Toast.makeText(this, "Map has been added :)", Toast.LENGTH_SHORT).show();
        finish();
    }

    /**
     * verwijderd de map
     * @param view
     */
    public void deleteMapHandler(View view) {
        int mapId = getIntent().getIntExtra(CURRENT_MAP_KEY, -1);
        CounterStrikeMap map = MapProvider.returnById(mapId);
        MapProvider.removeCounterStrikeMap(map);

        Intent intent = new Intent(this, SelectMapActivity.class);
        finish();
        startActivity(intent);

    }
}
