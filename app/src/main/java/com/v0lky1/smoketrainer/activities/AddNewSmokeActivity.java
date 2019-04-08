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

public class AddNewSmokeActivity extends AppCompatActivity {
    private EditText urlEditText;
    private EditText spotEditText;
    private boolean newSmoke = false;
    private Smoke smoke;
    private ImageView deleteButton;
    private CounterStrikeMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_smoke_activity);
        deleteButton = findViewById(R.id.deleteSmokeButton);
        urlEditText = findViewById(R.id.editTextMapName);
        spotEditText = findViewById(R.id.editTextLocation);


        Intent intent = getIntent();
        int smokeId = intent.getIntExtra(CURRENT_SMOKE_KEY, -1);
        String mapName = intent.getStringExtra(CURRENT_MAP_KEY);

        if (smokeId != -1 && mapName != null){
            map = MapProvider.returnMap(mapName);
            smoke = MapProvider.returnMap(mapName).getSmokeById(smokeId);
            urlEditText.setText(smoke.getUrl());
            spotEditText.setText(smoke.getTitle());
            deleteButton.setVisibility(View.VISIBLE);
        } else {
            deleteButton.setVisibility(View.INVISIBLE);
            newSmoke = true;
            smoke = new Smoke();
        }


    }

    public void sendAddSmokeHandler(View view) {
        Intent intent = getIntent();
        String name = intent.getStringExtra(CURRENT_MAP_KEY);
        CounterStrikeMap map = MapProvider.returnMap(name);

        final List<Smoke> smokes = map.getSmokes();
        String location = spotEditText.getText().toString();
        String url = urlEditText.getText().toString();

        smoke.setTitle(location);
        smoke.setUrl(url);
        if(newSmoke) {
            smokes.add(smoke);
        }

        Toast.makeText(this, "Smoke has been added :)", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void deleteSmokeHandler(View view){
        map.getSmokes().remove(smoke);
        Intent intent = new Intent (this, SmokeListActivity.class);
        intent.putExtra(CURRENT_MAP_KEY, map.getName());
        finish();
        startActivity(intent);
    }
}
