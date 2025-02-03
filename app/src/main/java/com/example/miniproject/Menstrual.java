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
        setContentView(R.layout.activity_menstrual);


        Button btnTrackCycle = findViewById(R.id.btnTrackCycle);


        Button btnSetReminder = findViewById(R.id.btnSetReminder);


        btnTrackCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Menstrual.this, "Tracking Menstrual Cycle...", Toast.LENGTH_SHORT).show();
            }
        });


        btnSetReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Menstrual.this, "Reminder Set!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
