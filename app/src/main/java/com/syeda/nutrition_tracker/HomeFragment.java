package com.syeda.nutrition_tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private Button btnLogNewMeal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the home screen layout
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize views
        btnLogNewMeal = view.findViewById(R.id.btnLogNewMeal);

        // Set click listener - switches to Log tab when clicked
        btnLogNewMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to Log Food tab
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).switchToTab(1); // Index 1 = Log tab
                }
            }
        });

        return view;
    }
}