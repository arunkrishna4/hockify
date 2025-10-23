package com.example.hockeyscoringapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class matchsummary extends AppCompatActivity {

    private TableLayout statsTable;
    private MaterialButtonToggleGroup teamToggleGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_matchsummary);

        // --- Action Bar Setup ---
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Match Summary");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // --- Initialize Views ---
        statsTable = findViewById(R.id.statsTable);
        teamToggleGroup = findViewById(R.id.teamToggleGroup);

        // --- Default Team A Data ---
        loadTeamAData();

        // --- Toggle Listener ---
        teamToggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                if (checkedId == R.id.btnTeamA) {
                    loadTeamAData();
                } else if (checkedId == R.id.btnTeamB) {
                    loadTeamBData();
                }
            }
        });
    }

    // --- Team A Data ---
    private void loadTeamAData() {
        statsTable.removeAllViews();

        addHeaderRow();
        addPlayerRow("Arun Kumar", "3");
        addPlayerRow("Rohit Sharma", "2");
        addPlayerRow("Vikram Singh", "1");
    }

    // --- Team B Data ---
    private void loadTeamBData() {
        statsTable.removeAllViews();

        addHeaderRow();
        addPlayerRow("Ravi Teja", "4");
        addPlayerRow("Suresh Raina", "1");
        addPlayerRow("Manish Pandey", "2");
    }

    // --- Table Header ---
    private void addHeaderRow() {
        TableRow headerRow = new TableRow(this);
        headerRow.setBackgroundColor(0xFFF0F0F0);

        TextView nameHeader = createTextView("Player Name", true);
        TextView goalsHeader = createTextView("Goals", true);
        goalsHeader.setGravity(Gravity.END);

        headerRow.addView(nameHeader);
        headerRow.addView(goalsHeader);
        statsTable.addView(headerRow);
    }

    // --- Player Rows ---
    private void addPlayerRow(String player, String goals) {
        TableRow row = new TableRow(this);
        row.addView(createTextView(player, false));
        TextView goalsText = createTextView(goals, false);
        goalsText.setGravity(Gravity.END);
        row.addView(goalsText);
        statsTable.addView(row);
    }

    // --- Reusable TextView Builder ---
    private TextView createTextView(String text, boolean bold) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setPadding(20, 20, 20, 20);
        tv.setTextSize(16);
        tv.setGravity(Gravity.START);
        if (bold) tv.setTypeface(null, android.graphics.Typeface.BOLD);
        return tv;
    }

    // --- Handle Back Button in Action Bar ---
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
