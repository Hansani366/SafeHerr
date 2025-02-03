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
        setContentView(R.layout.activity_location); // Ensure this matches your XML file

        // Initialize "Find Nearest Police Station" Button
        Button btnFindPoliceStation = findViewById(R.id.btnFindPoliceStation);

        // Initialize "Share Location via WhatsApp" Button
        Button btnShareLocation = findViewById(R.id.btnShareLocation);

        // Set click listener for the "Find Nearest Police Station" Button
        btnFindPoliceStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display Toast when button is clicked
                Toast.makeText(Location.this, "Finding Nearest Police Station...", Toast.LENGTH_SHORT).show();
            }
        });

        // Set click listener for the "Share Location via WhatsApp" Button
        btnShareLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display Toast when button is clicked
                Toast.makeText(Location.this, "Location Shared via WhatsApp!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
