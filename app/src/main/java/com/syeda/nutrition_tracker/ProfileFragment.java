package com.syeda.nutrition_tracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    // UI Elements
    private EditText etAge, etHeight, etWeight;
    private Spinner spinnerActivityLevel, spinnerPrimaryGoal, spinnerSecondaryGoal;
    private Button btnSaveProfile;

    // SharedPreferences for storing data
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "UserProfile";
    private static final String KEY_AGE = "age";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_ACTIVITY = "activity";
    private static final String KEY_PRIMARY_GOAL = "primary_goal";
    private static final String KEY_SECONDARY_GOAL = "secondary_goal";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize SharedPreferences
        sharedPreferences = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Initialize views
        etAge = view.findViewById(R.id.etAge);
        etHeight = view.findViewById(R.id.etHeight);
        etWeight = view.findViewById(R.id.etWeight);
        spinnerActivityLevel = view.findViewById(R.id.spinnerActivityLevel);
        spinnerPrimaryGoal = view.findViewById(R.id.spinnerPrimaryGoal);
        spinnerSecondaryGoal = view.findViewById(R.id.spinnerSecondaryGoal);
        btnSaveProfile = view.findViewById(R.id.btnSaveProfile);

        // Setup spinners
        setupSpinners();

        // Load existing data if any
        loadProfileData();

        // Save button click listener
        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfileData();
            }
        });

        return view;
    }

    private void setupSpinners() {
        // Activity Level options
        String[] activityLevels = {
                "Select Activity Level",
                "Sedentary (Little to no exercise)",
                "Lightly Active (Exercise 1-3 days/week)",
                "Moderately Active (Exercise 3-5 days/week)",
                "Very Active (Exercise 6-7 days/week)",
                "Extremely Active (Physical job + exercise)"
        };

        // Primary Goal options
        String[] primaryGoals = {
                "Select Primary Goal",
                "Lose Weight",
                "Gain Weight",
                "Maintain Weight"
        };

        // Secondary Goal options
        String[] secondaryGoals = {
                "Select Secondary Goal",
                "None",
                "Increase Protein",
                "Reduce Sodium",
                "Increase Fiber",
                "Boost Iron Intake",
                "Increase Vitamins",
                "Healthy Fats",
                "Decrease Carbs"
        };

        // Create adapters
        ArrayAdapter<String> activityAdapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                activityLevels
        );
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActivityLevel.setAdapter(activityAdapter);

        ArrayAdapter<String> primaryGoalAdapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                primaryGoals
        );
        primaryGoalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrimaryGoal.setAdapter(primaryGoalAdapter);

        ArrayAdapter<String> secondaryGoalAdapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                secondaryGoals
        );
        secondaryGoalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSecondaryGoal.setAdapter(secondaryGoalAdapter);
    }

    private void saveProfileData() {
        // Get input values
        String ageStr = etAge.getText().toString().trim();
        String heightStr = etHeight.getText().toString().trim();
        String weightStr = etWeight.getText().toString().trim();

        // Validation
        if (ageStr.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (spinnerActivityLevel.getSelectedItemPosition() == 0) {
            Toast.makeText(getContext(), "Please select an activity level", Toast.LENGTH_SHORT).show();
            return;
        }

        if (spinnerPrimaryGoal.getSelectedItemPosition() == 0) {
            Toast.makeText(getContext(), "Please select a primary goal", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_AGE, ageStr);
        editor.putString(KEY_HEIGHT, heightStr);
        editor.putString(KEY_WEIGHT, weightStr);
        editor.putInt(KEY_ACTIVITY, spinnerActivityLevel.getSelectedItemPosition());
        editor.putInt(KEY_PRIMARY_GOAL, spinnerPrimaryGoal.getSelectedItemPosition());
        editor.putInt(KEY_SECONDARY_GOAL, spinnerSecondaryGoal.getSelectedItemPosition());
        editor.apply();

        Toast.makeText(getContext(), "Profile saved successfully!", Toast.LENGTH_SHORT).show();
    }

    private void loadProfileData() {
        // Load saved data
        String age = sharedPreferences.getString(KEY_AGE, "");
        String height = sharedPreferences.getString(KEY_HEIGHT, "");
        String weight = sharedPreferences.getString(KEY_WEIGHT, "");
        int activityPos = sharedPreferences.getInt(KEY_ACTIVITY, 0);
        int primaryGoalPos = sharedPreferences.getInt(KEY_PRIMARY_GOAL, 0);
        int secondaryGoalPos = sharedPreferences.getInt(KEY_SECONDARY_GOAL, 0);

        // Set values if they exist
        if (!age.isEmpty()) etAge.setText(age);
        if (!height.isEmpty()) etHeight.setText(height);
        if (!weight.isEmpty()) etWeight.setText(weight);

        spinnerActivityLevel.setSelection(activityPos);
        spinnerPrimaryGoal.setSelection(primaryGoalPos);
        spinnerSecondaryGoal.setSelection(secondaryGoalPos);
    }
}