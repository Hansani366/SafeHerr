package com.example.miniproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Menstrual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menstrual);  // Ensure this matches your XML file

        // Initialize "Track My Cycle" Button
        Button btnTrackCycle = findViewById(R.id.btnTrackCycle);

        // Initialize "Set Reminder" Button
        Button btnSetReminder = findViewById(R.id.btnSetReminder);

        // Set click listener for the "Track My Cycle" Button
        btnTrackCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display Toast when button is clicked
                Toast.makeText(Menstrual.this, "Tracking Menstrual Cycle...", Toast.LENGTH_SHORT).show();
            }
        });

        // Set click listener for the "Set Reminder" Button
        btnSetReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display Toast when button is clicked
                Toast.makeText(Menstrual.this, "Reminder Set!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
