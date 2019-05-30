package com.v0lky1.smoketrainer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.v0lky1.smoketrainer.R;


public class MainActivity extends AppCompatActivity {

    private ImageView logo;

    /**
     * het startpunt van de app. Als je op het logo klikt word je verwezen naar het map selectie scherm.
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //intiele settings voor de app. Zorgt voor fullscreen gedrag.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.imageViewSmokeTrainer);


        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectMapActivity.class);
                startActivity(intent);
            }
        });
    }
}
