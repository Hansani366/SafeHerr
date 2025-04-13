package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Register extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText;
    private Button signupButton;
    private ProgressBar progressBar;
    private TextView loginTextView;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Use your XML filename

        nameEditText = findViewById(R.id.editTextName);
        emailEditText = findViewById(R.id.edtEmail);
        passwordEditText = findViewById(R.id.edtPassword);
        signupButton = findViewById(R.id.btnLogin); // button says "Signup"
        progressBar = findViewById(R.id.progressBar);
        loginTextView = findViewById(R.id.txtRegister);

        auth = FirebaseAuth.getInstance();

        signupButton.setOnClickListener(v -> registerUser());

        loginTextView.setOnClickListener(v -> {
            // Navigate to LoginActivity
            startActivity(new Intent(Register.this, Login.class));
            finish();
        });
    }

    private void registerUser() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    progressBar.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, Dashboard.class));
                        finish();
                    } else {
                        Toast.makeText(this, "Signup Failed" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
