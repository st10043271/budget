package com.example.budget;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.budget.databinding.ActivityAddGoalBinding;

public class AddGoalActivity extends AppCompatActivity {

    private ActivityAddGoalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddGoalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSaveGoal.setOnClickListener(v -> {
            String name = binding.etGoalName.getText().toString().trim();
            String minGoalStr = binding.etMinGoal.getText().toString().trim();
            String maxGoalStr = binding.etMaxGoal.getText().toString().trim();

            if (name.isEmpty() || minGoalStr.isEmpty() || maxGoalStr.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double minGoal = Double.parseDouble(minGoalStr);
                double maxGoal = Double.parseDouble(maxGoalStr);

                if (minGoal < 0 || maxGoal < 0 || minGoal > maxGoal) {
                    Toast.makeText(this, "Invalid min/max values", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save to DB (or pass back to main activity)
                Toast.makeText(this,
                        "Goal saved:\n" +
                                "Name: " + name + "\n" +
                                "Min: R" + minGoal + "\n" +
                                "Max: R" + maxGoal,
                        Toast.LENGTH_LONG).show();

                finish(); // return to previous activity
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
