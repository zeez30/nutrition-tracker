package com.syeda.nutrition_tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class LogFoodFragment extends Fragment {

    private CardView cardBarcodeScanner;
    private CardView cardFoodSearch;
    private CardView cardAIMealBuilder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the log food layout
        View view = inflater.inflate(R.layout.fragment_log_food, container, false);

        // Initialize views
        cardBarcodeScanner = view.findViewById(R.id.cardBarcodeScanner);
        cardFoodSearch = view.findViewById(R.id.cardFoodSearch);
        cardAIMealBuilder = view.findViewById(R.id.cardAIMealBuilder);

        // Set click listeners
        cardBarcodeScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Barcode Scanner coming soon!", Toast.LENGTH_SHORT).show();
            }
        });

        cardFoodSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Food Search coming soon!", Toast.LENGTH_SHORT).show();
            }
        });

        cardAIMealBuilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "AI Meal Builder coming soon!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}