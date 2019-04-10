package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.objects.CounterStrikeMap;
import com.v0lky1.smoketrainer.objects.Smoke;
import com.v0lky1.smoketrainer.providers.MapProvider;

import java.util.List;

import static com.v0lky1.smoketrainer.activities.SelectMapActivity.CURRENT_MAP_KEY;
import static com.v0lky1.smoketrainer.activities.SmokeListActivity.CURRENT_SMOKE_KEY;

public class EditSmokeActivity extends AppCompatActivity {
    //instance variable calls
    private EditText urlEditText;
    private EditText spotEditText;
    private boolean newSmoke = false;
    private Smoke smoke;
    private CounterStrikeMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_smoke_activity);
        //only needed in the oncreate so local is better
        ImageView deleteButton;

        //init
        deleteButton = findViewById(R.id.deleteSmokeButton);
        urlEditText = findViewById(R.id.editTextMapName);
        spotEditText = findViewById(R.id.editTextLocation);

        //getting intent from smokelistactivity
        Intent intent = getIntent();
        //unique id since names can be duplicates
        int smokeId = intent.getIntExtra(CURRENT_SMOKE_KEY, -1);
        //getting current map
        int mapId = intent.getIntExtra(CURRENT_MAP_KEY, -1);

        //if our program did exceed in getting an id it didn't null (-1)
        //and the mapname doesn't null
        //we know our smokes exists.

        if (smokeId != -1 && mapId != -1) {
            //return map with param mapid since we know it exists
            map = MapProvider.returnById(mapId);
            //assign our instance smoke by id since we know it exists
            smoke = MapProvider.returnById(mapId).getSmokeById(smokeId);

            //load in the current url and title (of the smoke) in the edittexts
            urlEditText.setText(smoke.getUrl());
            spotEditText.setText(smoke.getTitle());

            //if our smoke already exists it should be delete-able
            deleteButton.setVisibility(View.VISIBLE);
        } else {
            //our smoke doesn't exist yet! Don't show the delete button.
            deleteButton.setVisibility(View.INVISIBLE);
            //since we know our doesn't exist yet we enable boolean "newsmoke" for use later.
            newSmoke = true;
            //our instance smoke is a new one, create it.
            smoke = new Smoke();
        }


    }

    public void sendAddSmokeHandler(View view) {
        //getting intent from smokelistactivity
        Intent intent = getIntent();
        //getting mapid
        int mapId = intent.getIntExtra(CURRENT_MAP_KEY, -1);
        //returning map with string param name
        CounterStrikeMap map = MapProvider.returnById(mapId);

        //getting smokes
        final List<Smoke> smokes = map.getSmokes();

        //setting the text in String location and url to the edittext contents
        String location = spotEditText.getText().toString();
        String url = urlEditText.getText().toString();

        //setting our current instance smoke title and url (edits and saves smoke)
        smoke.setTitle(location);
        smoke.setUrl(url);

        //asking our boolean if we're dealing with a new smoke, if so add it (adds the smoke).
        if (newSmoke) {
            smokes.add(smoke);
        }
        //shows a toast message with a happy message
        Toast.makeText(this, "Smoke has been added :)", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void deleteSmokeHandler(View view) {
        //since this button only shows when the smoke exists we know our app assigned the smoke to the instance
        //so we we can safely delete it (removes the smoke).
        map.getSmokes().remove(smoke);
        //we're done here, sending us back to the smokelistactivity.
        Intent intent = new Intent(this, SmokeListActivity.class);
        //we need to know what smokes to show and we're starting the activity properly.
        intent.putExtra(CURRENT_MAP_KEY, map.getMapId());
        finish();
        startActivity(intent);
    }
}
