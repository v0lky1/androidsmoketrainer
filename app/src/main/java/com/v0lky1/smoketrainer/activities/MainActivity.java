package com.v0lky1.smoketrainer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.v0lky1.smoketrainer.R;


public class MainActivity extends AppCompatActivity {

    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.imageViewSmokeTrainer);


        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelectMap();
            }
        });
    }

    public void openSelectMap() {
        Intent intent = new Intent(this, SelectMapActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Logo courtesy of Rezji", Toast.LENGTH_SHORT).show();
    }
}
