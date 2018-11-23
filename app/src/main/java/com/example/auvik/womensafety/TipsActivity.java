package com.example.auvik.womensafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        Button health=(Button)findViewById(R.id.healthbtn);

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TipsActivity.this,HealthActivity.class));
            }
        });

        Button fitness = (Button) findViewById(R.id.fitnessbtn);

        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TipsActivity.this,FitnessActivity.class));
            }
        });


        Button pregnency = (Button) findViewById(R.id.pregnencybtn);

        pregnency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TipsActivity.this,PregnencyActivity.class));
            }
        });

        Button care = (Button) findViewById(R.id.carebtn);

        care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TipsActivity.this,BabyCareActivity.class));
            }
        });

    }
}
