package com.example.hockeyscoringapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    // 1. NEW: Interface to handle click events outside the adapter
    public interface OnPlayerClickListener {
        void onPlayerClick(Player player);
    }

    private final List<Player> originalPlayerList;
    private List<Player> filteredPlayerList;
    private final OnPlayerClickListener onPlayerClickListener; // 2. NEW: Listener field

    // 3. UPDATED: Constructor now accepts the listener
    public PlayerAdapter(List<Player> playerList, OnPlayerClickListener listener) {
        this.originalPlayerList = playerList;
        this.filteredPlayerList = new ArrayList<>(playerList);
        this.onPlayerClickListener = listener; // Store the listener properly
    }


    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = filteredPlayerList.get(position); // Use filtered list

        // Set name on the button
        holder.playerNameButton.setText(player.getName());

        // 4. UPDATED: Replace Toast with click listener call for navigation
        holder.playerNameButton.setOnClickListener(v -> {
            if (onPlayerClickListener != null) {
                onPlayerClickListener.onPlayerClick(player);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredPlayerList.size(); // Count from filtered list
    }

    // =========================================================
    // Filtering Method (Existing)
    // =========================================================
    public void filter(String query) {
        // Make sure we always compare in a case-insensitive way
        String prefix = query.trim().toLowerCase(Locale.ROOT);

        filteredPlayerList.clear();

        if (prefix.isEmpty()) {
            filteredPlayerList.addAll(originalPlayerList);
        } else {
            for (Player p : originalPlayerList) {
                if (p.getName().toLowerCase(Locale.ROOT).startsWith(prefix)) {
                    filteredPlayerList.add(p);
                }
            }
        }
        notifyDataSetChanged();
    }

    // =========================================================

    static class PlayerViewHolder extends RecyclerView.ViewHolder {
        ImageView playerPhotoImageView;
        Button playerNameButton;

        PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            // Assuming IDs inside card_player are correct
            playerPhotoImageView = itemView.findViewById(R.id.playerPhotoImageView);
            playerNameButton = itemView.findViewById(R.id.playerNameButton);
        }
    }
}
// Assuming this Player class is in the same file or a separate Player.java file
class   Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}