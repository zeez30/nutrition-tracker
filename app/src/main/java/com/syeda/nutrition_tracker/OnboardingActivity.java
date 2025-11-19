package com.syeda.nutrition_tracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class OnboardingActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView tvProgress, tvQuestion;
    private LinearLayout step1Layout, step2Layout, step3Layout, step4Layout, step5Layout, step6Layout;
    private Button btnNext, btnBack, btnFinish;

    // Step 1: Age
    private TextInputEditText etAge;

    // Step 2: Height
    private TextInputEditText etHeight;

    // Step 3: Weight
    private TextInputEditText etWeight;

    // Step 4: Activity Level
    private AutoCompleteTextView spinnerActivity;

    // Step 5: Primary Goal
    private AutoCompleteTextView spinnerPrimaryGoal;

    // Step 6: Secondary Goal
    private AutoCompleteTextView spinnerSecondaryGoal;

    private int currentStep = 1;
    private final int TOTAL_STEPS = 6;

    private String[] activityLevels = {
            "Sedentary (little to no exercise)",
            "Lightly Active (1-3 days/week)",
            "Moderately Active (3-5 days/week)",
            "Very Active (6-7 days/week)",
            "Extremely Active (athlete/physical job)"
    };

    private String[] goals = {
            "Lose Weight",
            "Gain Weight",
            "Maintain Weight",
            "Build Muscle",
            "Improve Overall Health",
            "Increase Energy",
            "Better Sleep",
            "Reduce Stress"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        // Initialize views
        progressBar = findViewById(R.id.progressBar);
        tvProgress = findViewById(R.id.tvProgress);
        tvQuestion = findViewById(R.id.tvQuestion);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        btnFinish = findViewById(R.id.btnFinish);

        // Step layouts
        step1Layout = findViewById(R.id.step1Layout);
        step2Layout = findViewById(R.id.step2Layout);
        step3Layout = findViewById(R.id.step3Layout);
        step4Layout = findViewById(R.id.step4Layout);
        step5Layout = findViewById(R.id.step5Layout);
        step6Layout = findViewById(R.id.step6Layout);

        // Step 1 fields
        etAge = findViewById(R.id.etAge);

        // Step 2 fields
        etHeight = findViewById(R.id.etHeight);

        // Step 3 fields
        etWeight = findViewById(R.id.etWeight);

        // Step 4 fields
        spinnerActivity = findViewById(R.id.spinnerActivity);
        ArrayAdapter<String> activityAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, activityLevels);
        spinnerActivity.setAdapter(activityAdapter);

        // Step 5 fields
        spinnerPrimaryGoal = findViewById(R.id.spinnerPrimaryGoal);
        ArrayAdapter<String> goalAdapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, goals);
        spinnerPrimaryGoal.setAdapter(goalAdapter1);

        // Step 6 fields
        spinnerSecondaryGoal = findViewById(R.id.spinnerSecondaryGoal);
        ArrayAdapter<String> goalAdapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, goals);
        spinnerSecondaryGoal.setAdapter(goalAdapter2);

        // Button listeners
        btnNext.setOnClickListener(v -> nextStep());
        btnBack.setOnClickListener(v -> previousStep());
        btnFinish.setOnClickListener(v -> finishOnboarding());

        updateUI();
    }

    private void nextStep() {
        if (validateCurrentStep()) {
            currentStep++;
            updateUI();
        }
    }

    private void previousStep() {
        if (currentStep > 1) {
            currentStep--;
            updateUI();
        }
    }

    private boolean validateCurrentStep() {
        switch (currentStep) {
            case 1:
                String age = etAge.getText().toString().trim();
                if (TextUtils.isEmpty(age)) {
                    etAge.setError("Age is required");
                    return false;
                }
                try {
                    int ageInt = Integer.parseInt(age);
                    if (ageInt < 13 || ageInt > 120) {
                        etAge.setError("Please enter a valid age (13-120)");
                        return false;
                    }
                } catch (NumberFormatException e) {
                    etAge.setError("Please enter a valid number");
                    return false;
                }
                return true;

            case 2:
                String height = etHeight.getText().toString().trim();
                if (TextUtils.isEmpty(height)) {
                    etHeight.setError("Height is required");
                    return false;
                }
                return true;

            case 3:
                String weight = etWeight.getText().toString().trim();
                if (TextUtils.isEmpty(weight)) {
                    etWeight.setError("Weight is required");
                    return false;
                }
                return true;

            case 4:
                String activity = spinnerActivity.getText().toString();
                if (TextUtils.isEmpty(activity)) {
                    Toast.makeText(this, "Please select an activity level", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;

            case 5:
                String primaryGoal = spinnerPrimaryGoal.getText().toString();
                if (TextUtils.isEmpty(primaryGoal)) {
                    Toast.makeText(this, "Please select a primary goal", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;

            case 6:
                String secondaryGoal = spinnerSecondaryGoal.getText().toString();
                if (TextUtils.isEmpty(secondaryGoal)) {
                    Toast.makeText(this, "Please select a secondary goal", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
        }
        return true;
    }

    private void updateUI() {
        // Update progress
        int progress = (currentStep * 100) / TOTAL_STEPS;
        progressBar.setProgress(progress);
        tvProgress.setText("Step " + currentStep + " of " + TOTAL_STEPS);

        // Hide all steps
        step1Layout.setVisibility(View.GONE);
        step2Layout.setVisibility(View.GONE);
        step3Layout.setVisibility(View.GONE);
        step4Layout.setVisibility(View.GONE);
        step5Layout.setVisibility(View.GONE);
        step6Layout.setVisibility(View.GONE);

        // Show current step
        switch (currentStep) {
            case 1:
                step1Layout.setVisibility(View.VISIBLE);
                tvQuestion.setText("How old are you?");
                break;
            case 2:
                step2Layout.setVisibility(View.VISIBLE);
                tvQuestion.setText("What's your height?");
                break;
            case 3:
                step3Layout.setVisibility(View.VISIBLE);
                tvQuestion.setText("What's your weight?");
                break;
            case 4:
                step4Layout.setVisibility(View.VISIBLE);
                tvQuestion.setText("How active are you?");
                break;
            case 5:
                step5Layout.setVisibility(View.VISIBLE);
                tvQuestion.setText("What's your primary goal?");
                break;
            case 6:
                step6Layout.setVisibility(View.VISIBLE);
                tvQuestion.setText("What's your secondary goal?");
                break;
        }

        // Update button visibility
        btnBack.setVisibility(currentStep == 1 ? View.INVISIBLE : View.VISIBLE);

        if (currentStep == TOTAL_STEPS) {
            btnNext.setVisibility(View.GONE);
            btnFinish.setVisibility(View.VISIBLE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
            btnFinish.setVisibility(View.GONE);
        }
    }

    private void finishOnboarding() {
        if (!validateCurrentStep()) {
            return;
        }

        // Save all data to SharedPreferences
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("age", etAge.getText().toString().trim());
        editor.putString("height", etHeight.getText().toString().trim());
        editor.putString("weight", etWeight.getText().toString().trim());

        // Get position in array
        String activityText = spinnerActivity.getText().toString();
        int activityPos = 0;
        for (int i = 0; i < activityLevels.length; i++) {
            if (activityLevels[i].equals(activityText)) {
                activityPos = i;
                break;
            }
        }
        editor.putInt("activity_level", activityPos);

        String primaryGoalText = spinnerPrimaryGoal.getText().toString();
        int primaryGoalPos = 0;
        for (int i = 0; i < goals.length; i++) {
            if (goals[i].equals(primaryGoalText)) {
                primaryGoalPos = i;
                break;
            }
        }
        editor.putInt("primary_goal", primaryGoalPos);

        String secondaryGoalText = spinnerSecondaryGoal.getText().toString();
        int secondaryGoalPos = 0;
        for (int i = 0; i < goals.length; i++) {
            if (goals[i].equals(secondaryGoalText)) {
                secondaryGoalPos = i;
                break;
            }
        }
        editor.putInt("secondary_goal", secondaryGoalPos);

        editor.putBoolean("onboarding_complete", true);
        editor.apply();

        // Go to main app
        Toast.makeText(this, "Profile setup complete!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(OnboardingActivity.this, MainActivity.class));
        finish();
    }
}

