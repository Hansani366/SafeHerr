package com.example.miniproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class help_request extends AppCompatActivity {

    private EditText helpMessage;
    private Button btnSendHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_request);

        helpMessage = findViewById(R.id.helpMessage);
        btnSendHelp = findViewById(R.id.btnSendHelp);

        btnSendHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = helpMessage.getText().toString().trim();
                if (!message.isEmpty()) {
                    Toast.makeText(help_request.this, "Help request sent!", Toast.LENGTH_SHORT).show();
                    // Implement further logic (e.g., send request to server or SMS)
                } else {
                    Toast.makeText(help_request.this, "Please enter a message!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
