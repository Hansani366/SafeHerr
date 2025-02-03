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
        setContentView(R.layout.activity_dashboard);

        // Initialize buttons
        btnEmergency = findViewById(R.id.btnEmergency);
        btnLocationSharing = findViewById(R.id.btnLocationSharing);
        btnMenstrualCycle = findViewById(R.id.btnMenstrualCycle);



        btnEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this, Emergency.class);
                startActivity(intent);
            }
        });

        btnLocationSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this, Location.class);
                startActivity(intent);
            }
        });

        btnMenstrualCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this, Menstrual.class);
                startActivity(intent);
            }
        });

    }
}
