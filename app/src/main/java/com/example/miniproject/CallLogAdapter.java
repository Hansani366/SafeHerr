package com.example.miniproject;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class CallLogAdapter extends RecyclerView.Adapter<CallLogAdapter.ViewHolder> {

    private Context context;
    private List<CallLogModel> callLogList;
    private DatabaseReference databaseRef;

    public CallLogAdapter(Context context, List<CallLogModel> callLogList) {
        this.context = context;
        this.callLogList = callLogList;
        this.databaseRef = FirebaseDatabase.getInstance().getReference("call_logs");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_call_log, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CallLogModel callLog = callLogList.get(position);
        holder.nameTextView.setText(callLog.name);
        holder.numberTextView.setText(callLog.number);
        holder.imageView.setImageResource(callLog.imageRes);

        holder.itemView.setOnClickListener(v -> showUpdateDialog(callLog, position));

        holder.itemView.setOnLongClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Delete Call Log")
                    .setMessage("Are you sure you want to delete this call log?")
                    .setPositiveButton("Delete", (dialog, which) -> {
                        if (callLog.id != null) {
                            databaseRef.child(callLog.id).removeValue()
                                    .addOnSuccessListener(aVoid -> {
                                        callLogList.remove(position);
                                        notifyItemRemoved(position);
                                        notifyItemRangeChanged(position, callLogList.size());
                                        Toast.makeText(context, "Call log deleted", Toast.LENGTH_SHORT).show();
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                        Log.e("Delete Error", "Error deleting call log", e);
                                    });
                        } else {
                            Toast.makeText(context, "Invalid call log ID", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
            return true;
        });
    }

    private void showUpdateDialog(CallLogModel callLog, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Update Call Log");

        View view = LayoutInflater.from(context).inflate(R.layout.activity_dialog_add_call_log, null);
        EditText nameInput = view.findViewById(R.id.editTextName);
        EditText numberInput = view.findViewById(R.id.editTextNumber);

        nameInput.setText(callLog.name);
        numberInput.setText(callLog.number);
        builder.setView(view);

        builder.setPositiveButton("Update", (dialog, which) -> {
            String updatedName = nameInput.getText().toString().trim();
            String updatedNumber = numberInput.getText().toString().trim();

            if (!updatedName.isEmpty() && !updatedNumber.isEmpty()) {
                if (callLog.id != null) {
                    databaseRef.child(callLog.id).child("name").setValue(updatedName);
                    databaseRef.child(callLog.id).child("number").setValue(updatedNumber)
                            .addOnSuccessListener(aVoid -> {
                                callLog.setName(updatedName);
                                callLog.setNumber(updatedNumber);
                                notifyItemChanged(position);
                                Toast.makeText(context, "Call log updated", Toast.LENGTH_SHORT).show();
                            })
                            .addOnFailureListener(e -> {
                                Toast.makeText(context, "Update failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                Log.e("Update Error", "Error updating call log", e);
                            });
                } else {
                    Toast.makeText(context, "Invalid call log ID", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    @Override
    public int getItemCount() {
        return callLogList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, numberTextView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.callLogName);
            numberTextView = itemView.findViewById(R.id.callLogNumber);
            imageView = itemView.findViewById(R.id.callLogImage);
        }
    }
}
