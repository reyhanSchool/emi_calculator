package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextprincipalValue, editTextInterestRate, editTextAmotorizationPeriod;
    Button calculateButton;
    TextView resultTextView;
    public double emiResult = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextprincipalValue = findViewById(R.id.editTextprincipalValue);
        editTextInterestRate = findViewById(R.id.editTextInterestRate);
        editTextAmotorizationPeriod = findViewById(R.id.editTextAmotorizationPeriod);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> {
            double principal = Double.parseDouble(editTextprincipalValue.getText().toString());
            int tenure = Integer.parseInt(editTextAmotorizationPeriod.getText().toString());
            double interestRate = Double.parseDouble(editTextInterestRate.getText().toString());

            // Convert interest rate from annual to monthly and percentage to decimal
            interestRate = interestRate / 1200;
            tenure = tenure * 12;

            // Calculate monthly EMI
            emiResult = (principal * interestRate * Math.pow(1 + interestRate, tenure)) /
                    (Math.pow(1 + interestRate, tenure) - 1);

            // Create an intent to start the destination activity
            Intent intent = new Intent(MainActivity.this, ResultsPage.class);
            intent.putExtra("emiResult", emiResult); // Pass the emiResult value

            startActivity(intent);
        });
    }
}