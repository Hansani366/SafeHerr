package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    // Declare buttons
    Button btnEmergency, btnLocationSharing,btnMenstrualCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard); // Assuming your XML is activity_dashboard.xml

        // Initialize buttons
        btnEmergency = findViewById(R.id.btnEmergency);
        btnLocationSharing = findViewById(R.id.btnLocationSharing);
        btnMenstrualCycle = findViewById(R.id.btnMenstrualCycle);


        // Set up onClick listeners for each button
        btnEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Emergency Info Activity
                Intent intent = new Intent(Dashboard.this, Emergency.class);
                startActivity(intent);
            }
        });

        btnLocationSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Location Sharing Activity
                Intent intent = new Intent(Dashboard.this, Location.class);
                startActivity(intent);
            }
        });

        btnMenstrualCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Menstrual Cycle Activity
                Intent intent = new Intent(Dashboard.this, Menstrual.class);
                startActivity(intent);
            }
        });

    }
}
