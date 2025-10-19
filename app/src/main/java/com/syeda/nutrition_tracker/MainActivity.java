package com.syeda.nutrition_tracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
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
                // TODO: Navigate to Log Food screen
                Toast.makeText(MainActivity.this,
                        "Log Food screen coming soon!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}