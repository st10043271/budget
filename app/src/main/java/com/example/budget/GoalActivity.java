package com.example.budget;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.budget.adapter.GoalAdapter;
import com.example.budget.databinding.ActivityGoalBinding;
import com.example.budget.model.Goal;
import com.example.budget.viewmodel.GoalViewModel;
import java.util.List;

public class GoalActivity extends AppCompatActivity {

    private ActivityGoalBinding binding;
    private GoalViewModel goalViewModel;
    private GoalAdapter goalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Setup RecyclerView
        goalAdapter = new GoalAdapter();
        binding.goalsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.goalsRecyclerView.setAdapter(goalAdapter);

        // ViewModel
        goalViewModel = new ViewModelProvider(this).get(GoalViewModel.class);
        goalViewModel.getAllGoals().observe(this, goals -> {
            goalAdapter.setGoals(goals);
            updateSavingsProgress(goals);
        });

        // Reports Button
        binding.btnReports.setOnClickListener(v -> {
            Intent intent = new Intent(GoalActivity.this, ReportsActivity.class);
            startActivity(intent);
        });

        // Add Goal Button
        binding.btnAddGoal.setOnClickListener(v -> {
            Intent intent = new Intent(GoalActivity.this, AddGoalActivity.class);
            startActivity(intent);
        });
    }

    // Method to update the savings progress bar
    private void updateSavingsProgress(List<Goal> goals) {
        double totalTarget = 0;
        double totalSaved = 0;

        for (Goal goal : goals) {
            totalTarget += goal.getTargetAmount();
            totalSaved += goal.getCurrentAmount();
        }

        int progress = totalTarget == 0 ? 0 : (int) ((totalSaved / totalTarget) * 100);
        binding.savingsProgressBar.setProgress(progress);
    }
}

