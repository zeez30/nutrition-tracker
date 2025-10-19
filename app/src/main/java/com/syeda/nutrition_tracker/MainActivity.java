package com.syeda.nutrition_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLogNewMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        btnLogNewMeal = findViewById(R.id.btnLogNewMeal);

        // Set click listener for Log New Meal button
        btnLogNewMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Log Food screen
                Intent intent = new Intent(MainActivity.this, LogFoodActivity.class);
                startActivity(intent);
            }
        });
    }
}