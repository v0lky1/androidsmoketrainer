package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_map_activity);

        //initializing our attributes
        nameEditText = findViewById(R.id.editTextMapName);
        removeMapButton = findViewById(R.id.removeMapButton);
        addEditMapButton = findViewById(R.id.buttonAddMap);

        //setting our instance mapId to the current map
        mapId = getIntent().getIntExtra(CURRENT_MAP_KEY, -1);


        //checking if our mapId is -1 if so we're dealing with a new map
        if (mapId != -1) {
            //renaming our button through the strings.xml
            addEditMapButton.setText(R.string.edit);
            //map exists to fetch it from the mapprovider
            csMap = MapProvider.returnById(mapId);
            //getting the mapId from selectmapactivity
            //setting the current text field of "name" to the current already existing map
            nameEditText.setText(csMap.getName());
            //since our map exists we should be able to delete it, so set the remove button to visible.
            removeMapButton.setVisibility(View.VISIBLE);

        } else {
            //so our mapId = null, which means we are dealing with a new map, set our boolean that checks that to true
            newMap = true;
            //it's a new map! You shouldn't be able to delete something that doesn't exist yet, disable the visibility of the
            //remove button.
            removeMapButton.setVisibility(View.INVISIBLE);
            //since we know our instance map is a new one, create it.
            csMap = new CounterStrikeMap();
    }
    }

    public void sendAddMapHandler(View view) {
        //getting the list of maps
        List<CounterStrikeMap> maps = MapProvider.getMaps();

        //getting the input from the user
        String mapName = nameEditText.getText().toString();

        //setting the mapname of our instance map
        csMap.setName(mapName);

        //usage of our boolean to see if we're dealing with a new map or
        //if we need to edit an existing one.
        if (newMap) {
            maps.add(csMap);
        }
        //happy message to show our action has succeeded
        Toast.makeText(this, "Map has been added :)", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void deleteMapHandler(View view) {
        int mapId= getIntent().getIntExtra(CURRENT_MAP_KEY, -1);
        CounterStrikeMap map = MapProvider.returnById(mapId);
        MapProvider.removeCounterStrikeMap(map);

        Intent intent = new Intent(this, SelectMapActivity.class);
        finish();
        startActivity(intent);

    }
}
