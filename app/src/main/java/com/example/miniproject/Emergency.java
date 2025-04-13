package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class Emergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        // Get references to the UI components from the XML
        Button btnCancelSOS = findViewById(R.id.btnCancelSOS);
        Button btnSkipCountdown = findViewById(R.id.btnSkipCountdown);
        Button btnCallLogs = findViewById(R.id.btnCallLogs);  // New button for Call Logs
        TextView tvStatus = findViewById(R.id.tvStatus);
        TextView tvNotify = findViewById(R.id.tvNotify);
        ImageView ivSosIcon = findViewById(R.id.ivSosIcon);

        // Set the image resource for the SOS icon
        if (ivSosIcon != null) {
            ivSosIcon.setImageResource(R.drawable.b2);
        } else {
            System.out.println("ivSosIcon is NULL! Check XML file for correct ID.");
        }

        // Cancel SOS Button Click Listener
        if (btnCancelSOS != null) {
            btnCancelSOS.setOnClickListener(v -> {
                Toast.makeText(Emergency.this, "SOS Cancelled!", Toast.LENGTH_SHORT).show();
                tvStatus.setText("I'M SAFE");
                tvNotify.setText("Notifying your SOS contacts in");
            });
        }

        // Skip Countdown Button Click Listener
        if (btnSkipCountdown != null) {
            btnSkipCountdown.setOnClickListener(v -> {
                Toast.makeText(Emergency.this, "Countdown Skipped!", Toast.LENGTH_SHORT).show();
                tvStatus.setText("I'M SAFE");
                tvNotify.setText("Notifying your SOS contacts in");
            });
        }

        // Call Logs Button Click Listener
        if (btnCallLogs != null) {
            btnCallLogs.setOnClickListener(v -> {
                Intent intent = new Intent(Emergency.this, call_logs.class);
                startActivity(intent);
            });
        }
    }
}
