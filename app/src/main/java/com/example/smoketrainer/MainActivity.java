package com.example.smoketrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonGetStarted;
    private Button buttonChecklist;
    private Button buttonSelectMap;
    private Button buttonAddNewSmoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);

        buttonGetStarted = findViewById(R.id.buttonGetStarted);
        buttonChecklist = findViewById(R.id.buttonCheckList);
        buttonSelectMap = findViewById(R.id.buttonSelectMap);
        buttonAddNewSmoke = findViewById(R.id.buttonAddNewSmoke);

        List<CounterStrikeMap> maps = new ArrayList<>();
        List<String> mapNames = new ArrayList<>();


        buttonGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSmokeBrowser();
            }
        });

        buttonChecklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProgressionCheckList();
            }
        });

        buttonSelectMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelectMap();
            }
        });

        buttonAddNewSmoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddNewSmoke();
            }
        });


    }

    public void openSmokeBrowser() {
        Intent intent = new Intent(this, SmokeListActivity.class);
        startActivity(intent);
    }

    public void openProgressionCheckList() {
        Intent intent = new Intent(this, ProgressionCheckListActivity.class);
        startActivity(intent);
    }

    public void openSelectMap() {
        Intent intent = new Intent(this, SelectMapActivity.class);
        startActivity(intent);
    }

    public void openAddNewSmoke() {
        Intent intent = new Intent(this, AddNewSmokeActivity.class);
        startActivity(intent);
    }
}
