package com.syeda.nutrition_tracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class LogFoodActivity extends AppCompatActivity {

    private CardView cardBarcodeScanner;
    private CardView cardFoodSearch;
    private CardView cardAIMealBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_food);

        // Initialize views
        cardBarcodeScanner = findViewById(R.id.cardBarcodeScanner);
        cardFoodSearch = findViewById(R.id.cardFoodSearch);
        cardAIMealBuilder = findViewById(R.id.cardAIMealBuilder);

        // Set click listeners
        cardBarcodeScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Navigate to Barcode Scanner screen
                Toast.makeText(LogFoodActivity.this,
                        "Barcode Scanner coming soon!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        cardFoodSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Navigate to Food Search screen
                Toast.makeText(LogFoodActivity.this,
                        "Food Search coming soon!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        cardAIMealBuilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Navigate to AI Meal Builder screen
                Toast.makeText(LogFoodActivity.this,
                        "AI Meal Builder coming soon!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}