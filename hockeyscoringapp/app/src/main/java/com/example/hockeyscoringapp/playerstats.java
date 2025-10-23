package com.example.hockeyscoringapp;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

// Note: If your actual file is named PlayerStats.java, update the class name accordingly.
public class playerstats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Ensure you change R.layout.activity_playerstats to your actual layout file name
        setContentView(R.layout.activity_playerstats);

        // --- Action Bar Setup for Player Stats ---
        if (getSupportActionBar() != null) {
            // 1. Set the Title
            getSupportActionBar().setTitle("Player Stats");

            // 2. Enable the built-in back (Up) button on the left
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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
