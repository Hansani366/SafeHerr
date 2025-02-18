package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.view.GravityCompat;

public class Dashboard extends AppCompatActivity {

    // Declare buttons
    Button btnEmergency, btnLocationSharing, btnMenstrualCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize buttons
        btnEmergency = findViewById(R.id.btnEmergency);
        btnLocationSharing = findViewById(R.id.btnLocationSharing);
        btnMenstrualCycle = findViewById(R.id.btnMenstrualCycle);

        // Set onClick listeners for buttons
        btnEmergency.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, Emergency.class);
            startActivity(intent);
        });

        btnLocationSharing.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, Location.class);
            startActivity(intent);
        });

        btnMenstrualCycle.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, Menstrual.class);
            startActivity(intent);
        });

        // User profile icon click listener
        ImageView userProfileIcon = findViewById(R.id.userProfileIcon);
        userProfileIcon.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, profile.class);
            startActivity(intent);
        });

        // DrawerLayout and menu icon initialization
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ImageView menuIcon = findViewById(R.id.menuIcon);

        // Open the navigation drawer when menu icon is clicked
        menuIcon.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });
    }
}
