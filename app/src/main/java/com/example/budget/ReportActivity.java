package com.example.budget;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class ReportActivity extends AppCompatActivity {

    private TextView tvIncome, tvExpenses, tvSavings, tvDebtTimer;
    private ProgressBar debtProgressBar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_report); // Make sure this matches your XML filename

        // Bind views
        tvIncome = findViewById(R.id.tv_income);
        tvExpenses = findViewById(R.id.tv_expenses);
        tvSavings = findViewById(R.id.tv_savings);
        tvDebtTimer = findViewById(R.id.tv_debt_timer);
        debtProgressBar = findViewById(R.id.debtProgressBar);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        setupBottomNavigation();
        startDebtCountdown();

        // Example static data — Replace with real calculations from database if needed
        tvIncome.setText("Income: R5000.00");
        tvExpenses.setText("Expenses: R2000.00");
        tvSavings.setText("Savings: R3000.00");
    }

    @SuppressLint("NonConstantResourceId")
    private void setupBottomNavigation() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    startActivity(new Intent(this, HomeActivity.class));
                    return true;
                case R.id.nav_report:
                    // Stay on current page
                    return true;
                case R.id.nav_settings:
                    startActivity(new Intent(this, SettingsActivity.class));
                    return true;
                default:
                    return false;
            }
        });
    }

    private void startDebtCountdown() {
        CountDownTimer timer = new CountDownTimer(10 * 60 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                long minutes = (millisUntilFinished / 1000) / 60;
                long seconds = (millisUntilFinished / 1000) % 60;
                String time = String.format(Locale.getDefault(), "Time remaining: %02d:%02d", minutes, seconds);
                tvDebtTimer.setText(time);
            }

            public void onFinish() {
                tvDebtTimer.setText("Time's up!");
            }
        };
        timer.start();
    }
}
