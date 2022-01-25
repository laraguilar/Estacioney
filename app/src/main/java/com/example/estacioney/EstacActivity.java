package com.example.estacioney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EstacActivity extends AppCompatActivity {
    String idEstac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estac);

        Intent i = getIntent();
        idEstac = i.getStringExtra("idEstac");


    }
}