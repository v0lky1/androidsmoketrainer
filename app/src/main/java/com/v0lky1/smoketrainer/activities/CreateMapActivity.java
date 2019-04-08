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

public class CreateMapActivity extends AppCompatActivity {
    EditText nameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_map_activity);

        nameEditText = findViewById(R.id.editTextMapName);
    }

    public void sendAddMapHandler(View view) {
        List<CounterStrikeMap> maps = MapProvider.getMaps();
        String mapName = nameEditText.getText().toString();

        maps.add(new CounterStrikeMap(mapName));
        Toast.makeText(this, "Map has been added :)", Toast.LENGTH_SHORT).show();

        Intent sendBackIntent = new Intent(this, SelectMapActivity.class);
        setResult(RESULT_OK, sendBackIntent);
        finish();
    }
}
