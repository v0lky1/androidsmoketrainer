package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.models.CounterStrikeMap;
import com.v0lky1.smoketrainer.models.Smoke;
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

    /**
     * haalt smoke en map op, als deze bestaan dan zet deze de tekst in de edittexts en hij laat de delete knop zien
     * als het een nieuwe smoke betreft laat de delete knop niet zien, zet boolean newSmoke op true en maak de smoke aan.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_smoke_activity);

        ImageView deleteButton;

        deleteButton = findViewById(R.id.deleteSmokeButton);
        urlEditText = findViewById(R.id.editTextMapName);
        spotEditText = findViewById(R.id.editTextLocation);

        Intent intent = getIntent();
        int smokeId = intent.getIntExtra(CURRENT_SMOKE_KEY, -1);
        int mapId = intent.getIntExtra(CURRENT_MAP_KEY, -1);

        if (smokeId != -1 && mapId != -1) {
            map = MapProvider.returnById(mapId);
            smoke = MapProvider.returnById(mapId).getSmokeById(smokeId);

            urlEditText.setText(smoke.getUrl());
            spotEditText.setText(smoke.getTitle());

            deleteButton.setVisibility(View.VISIBLE);
        } else {
            deleteButton.setVisibility(View.INVISIBLE);
            newSmoke = true;
            smoke = new Smoke();
        }


    }

    /**
     * als een smoke bestaat voegt ie hem toe, als hij niet bestaat dan wijzigt ie hem
     * @param view
     */
    public void sendAddSmokeHandler(View view) {
        Intent intent = getIntent();
        int mapId = intent.getIntExtra(CURRENT_MAP_KEY, -1);
        CounterStrikeMap map = MapProvider.returnById(mapId);

        final List<Smoke> smokes = map.getSmokes();

        String location = spotEditText.getText().toString();
        String url = urlEditText.getText().toString();

        smoke.setTitle(location);
        smoke.setUrl(url);

        if (newSmoke) {
            smokes.add(smoke);
            Toast.makeText(this, "Smoke has been added :)", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    /**
     * deletes smoke en stuurt ons vervolgens netjes terug naar de smokelistactivity.
     * @param view
     */

    public void deleteSmokeHandler(View view) {
        map.getSmokes().remove(smoke);

        Intent intent = new Intent(this, SmokeListActivity.class);
        intent.putExtra(CURRENT_MAP_KEY, map.getMapId());
        finish();
        startActivity(intent);
    }
}
