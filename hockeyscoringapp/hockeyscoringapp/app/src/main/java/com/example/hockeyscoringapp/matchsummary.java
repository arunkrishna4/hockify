package com.example.hockeyscoringapp;

import android.os.Bundle;
import android.view.MenuItem; // Needed to handle the system back button click
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
// Imports are clean and efficient for this setup

public class matchsummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_matchsummary);

        // --- Action Bar Setup ---
        // Get a reference to the Action Bar
        if (getSupportActionBar() != null) {
            // 1. Set the Title that appears in the center
            getSupportActionBar().setTitle("Match Summary");

            // 2. Enable the built-in back (Up) button on the left
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // The previous findViewById(R.id.btnBack) is removed because the custom ImageButton
        // in the XML was also removed (or should be) to use the native Action Bar.
    }

    /**
     * Handles the click event for the system's Up/Back button in the Action Bar.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Check if the user clicked the Home/Up button (ID is android.R.id.home)
        if (item.getItemId() == android.R.id.home) {
            finish(); // Closes the current activity, navigating back
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
