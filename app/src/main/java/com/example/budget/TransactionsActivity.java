package com.example.budget;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class TransactionsActivity extends AppCompatActivity {

    private TextView tvDateHeader;
    private Button btnSelectDate, btnSyncBank, btnScanReceipt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transactions); // Ensure your XML file is named this

        // Initialize views
        tvDateHeader = findViewById(R.id.tv_date_header);
        btnSelectDate = findViewById(R.id.btn_select_date);
        btnSyncBank = findViewById(R.id.btn_sync_bank);
        btnScanReceipt = findViewById(R.id.btn_scan_receipt);

        // Handle Select Date button
        btnSelectDate.setOnClickListener(v -> showDatePicker());

        // Sync Bank mock behavior
        btnSyncBank.setOnClickListener(v -> {
            Toast.makeText(this, "Syncing bank data...", Toast.LENGTH_SHORT).show();
            // TODO: Add actual sync logic
        });

        // Scan Receipt mock behavior
        btnScanReceipt.setOnClickListener(v -> {
            Toast.makeText(this, "Opening camera to scan receipt...", Toast.LENGTH_SHORT).show();
            // TODO: Add scanning logic
        });

        // Set up bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menu_transactions);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    startActivity(new Intent(this, HomeActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.menu_transactions:
                    return true; // Already here
                case R.id.menu_settings:
                    startActivity(new Intent(this, SettingsActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                default:
                    return false;
            }
        });
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // 0-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (DatePicker view, int selectedYear, int selectedMonth, int selectedDay) -> {
                    String selectedDate = selectedDay + " " + getMonthName(selectedMonth) + " " + selectedYear;
                    tvDateHeader.setText("Transactions for " + selectedDate);
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    private String getMonthName(int monthIndex) {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return months[monthIndex];
    }
}
