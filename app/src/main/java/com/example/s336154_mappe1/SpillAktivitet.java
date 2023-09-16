package com.example.s336154_mappe1;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SpillAktivitet extends AppCompatActivity {

    private TextView resultTextView;
    private String currentInput = "";
    private double firstValue = Double.NaN;
    private String operator = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spill_aktivitet);
        resultTextView = findViewById(R.id.resultTextView);
        Log.d("I Spillet ", "oncreate Spillet");

        Button avsluttSpillet = findViewById(R.id.avsluttSpill);
        Intent i=new Intent(this, MainActivity.class);

        avsluttSpillet.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                finish(); startActivity(i);
            } }); }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        currentInput += button.getText().toString();
        updateResultText();
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        if (!currentInput.isEmpty()) {
            firstValue = Double.parseDouble(currentInput);
            currentInput = "";
        }
    }

    public void onClearClick(View view) {
        currentInput = "";
        firstValue = Double.NaN;
        operator = "";
        updateResultText();
    }

    public void onEqualClick(View view) {
        if (!Double.isNaN(firstValue) && !currentInput.isEmpty()) {
            double secondValue = Double.parseDouble(currentInput);
            double result = calculateResult(firstValue, secondValue, operator);
            currentInput = String.valueOf(result);
            operator = "";
            firstValue = Double.NaN;
            updateResultText();
        }
    }

    private double calculateResult(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return Double.NaN; // Handle division by zero
                }
            default:
                return num2;
        }
    }

    private void updateResultText() {
        resultTextView.setText(currentInput);
    }
}


