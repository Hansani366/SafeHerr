package com.example.miniproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);


        Button btnFindPoliceStation = findViewById(R.id.btnFindPoliceStation);


        Button btnShareLocation = findViewById(R.id.btnShareLocation);


        btnFindPoliceStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Location.this, "Finding Nearest Police Station...", Toast.LENGTH_SHORT).show();
            }
        });


        btnShareLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Location.this, "Location Shared via WhatsApp!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}