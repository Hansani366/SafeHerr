package com.example.miniproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Emergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency); // Ensure this matches your XML file

        // Initialize SOS Button
        Button btnSOS = findViewById(R.id.btnSOS);

        // Check if button is found (to avoid NullPointerException)
        if (btnSOS != null) {
            btnSOS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Emergency.this, "SOS Button Pressed!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            System.out.println("btnSOS is NULL! Check XML file for correct ID.");
        }
    }
}
