package com.v0lky1.smoketrainer.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.objects.CounterStrikeMap;
import com.v0lky1.smoketrainer.objects.Smoke;
import com.v0lky1.smoketrainer.providers.MapProvider;
import com.v0lky1.smoketrainer.providers.SmokeProvider;

import java.util.List;

import static com.v0lky1.smoketrainer.activities.SelectMapActivity.CURRENT_MAP_KEY;

public class AddNewSmokeActivity extends AppCompatActivity {
    EditText urlEditText;
    EditText spotEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_smoke_activity);


        urlEditText = findViewById(R.id.editTextURL);
        spotEditText = findViewById(R.id.editTextLocation);


    }

    public void sendAddSmokeHandler(View view) {
        Intent intent = getIntent();
        String name = intent.getExtras().getString(CURRENT_MAP_KEY);
        CounterStrikeMap map = MapProvider.returnMap(name);
        final List<Smoke> smokes = SmokeProvider.getSmokeMap().get(map.getMapType());


        String location = spotEditText.getText().toString();
        String url = urlEditText.getText().toString();

        smokes.add(new Smoke(location, url));
        Toast.makeText(this, "Smoke has been added :)", Toast.LENGTH_SHORT).show();

       Intent sendBackIntent = new Intent(this, SmokeListActivity.class);
        sendBackIntent.putExtra(CURRENT_MAP_KEY, name);
        setResult(RESULT_OK, sendBackIntent);
        finish();
    }
}
