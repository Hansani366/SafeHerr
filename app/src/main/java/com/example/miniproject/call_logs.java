package com.example.miniproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class call_logs extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CallLogAdapter adapter;
    private List<CallLogModel> callLogList;
    private Button addNumberButton;
    private DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_logs);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addNumberButton = findViewById(R.id.btn_add_number);

        callLogList = new ArrayList<>();
        adapter = new CallLogAdapter(this, callLogList);
        recyclerView.setAdapter(adapter);

        databaseRef = FirebaseDatabase.getInstance().getReference("call_logs");

        loadCallLogs(); // Load existing call logs

        addNumberButton.setOnClickListener(v -> showAddCallLogDialog());
    }

    private void showAddCallLogDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Call Log");

        View view = LayoutInflater.from(this).inflate(R.layout.activity_dialog_add_call_log, null);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText nameInput = view.findViewById(R.id.editTextName);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText numberInput = view.findViewById(R.id.editTextNumber);
        builder.setView(view);

        builder.setPositiveButton("Save", (dialog, which) -> {
            String name = nameInput.getText().toString().trim();
            String number = numberInput.getText().toString().trim();

            if (!name.isEmpty() && !number.isEmpty()) {
                saveCallLog(name, number);
            } else {
                Toast.makeText(this, "Both fields are required", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void loadCallLogs() {
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                callLogList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String id = dataSnapshot.getKey();
                    String name = dataSnapshot.child("name").getValue(String.class);
                    String number = dataSnapshot.child("number").getValue(String.class);

                    callLogList.add(new CallLogModel(id, name, number, R.drawable.call1));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(call_logs.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveCallLog(String name, String number) {
        String id = databaseRef.push().getKey();

        if (id != null) {
            CallLogModel callLog = new CallLogModel(id, name, number, R.drawable.call1);
            databaseRef.child(id).setValue(callLog)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(this, "Call Log Added!", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        }
    }
}
