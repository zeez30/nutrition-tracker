package com.syeda.nutrition_tracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Check if user is already logged in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // User is signed in, check if onboarding is complete
            SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            boolean onboardingComplete = prefs.getBoolean("onboarding_complete", false);

            if (onboardingComplete) {
                // Go straight to main app
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
                return;
            } else {
                // Go to onboarding
                startActivity(new Intent(WelcomeActivity.this, OnboardingActivity.class));
                finish();
                return;
            }
        }

        setContentView(R.layout.activity_welcome);

        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnSignUp = findViewById(R.id.btnSignUp);

        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        });

        btnSignUp.setOnClickListener(v -> {
            startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
        });
    }
}
