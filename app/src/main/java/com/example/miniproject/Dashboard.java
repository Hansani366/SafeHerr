package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Dashboard extends AppCompatActivity {

    // Declare the 5 feature cards
    CardView cardEmergency, cardLocation, cardMenstrual, cardHelpRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize feature cards
        cardEmergency = findViewById(R.id.cardEmergency);
        cardLocation = findViewById(R.id.cardLocation);
        cardMenstrual = findViewById(R.id.cardMenstrual);
        cardHelpRequest = findViewById(R.id.cardHelpRequest);

        // Profile icon click - Go to Profile screen
        ImageView userProfileIcon = findViewById(R.id.userProfileIcon);
        userProfileIcon.setOnClickListener(v -> startActivity(new Intent(Dashboard.this, profile.class)));

        // Menu icon to open navigation drawer
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ImageView menuIcon = findViewById(R.id.menuIcon);
        menuIcon.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // Card click listeners
        cardEmergency.setOnClickListener(v -> startActivity(new Intent(Dashboard.this, Emergency.class)));

        cardLocation.setOnClickListener(v -> startActivity(new Intent(Dashboard.this, Location.class)));

        cardMenstrual.setOnClickListener(v -> startActivity(new Intent(Dashboard.this, Menstrual.class)));

        cardHelpRequest.setOnClickListener(v -> startActivity(new Intent(Dashboard.this, help_request.class)));
    }
}