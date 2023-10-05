package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);

        // Receive the emiResult value from the intent
        double emiResult = getIntent().getDoubleExtra("emiResult", 0.0);

        // Now you can use emiResult as needed in this activity
        TextView resultTextView = findViewById(R.id.textViewResult);
        resultTextView.setText("Your monthly EMI is: $" + String.format("%.2f", emiResult));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the navigation icon click listener
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event (e.g., go back to the main page)
                Intent intent = new Intent(ResultsPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
