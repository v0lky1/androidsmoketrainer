package com.example.smoketrainer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SelectMapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectmap);

        ListView lv = findViewById(R.id.mapList);

        MapAdapter adapter = new MapAdapter(this, MapProvider.getMaps());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mapName = MapProvider.getMaps().get(position).getName();
                Toast.makeText(SelectMapActivity.this, mapName, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(
            }
        });
    }
}
