package com.example.s336154_mappe1;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;




public class SpillAktivitet extends AppCompatActivity {


    public int randomIndex, randomIndex2;
    private String[] mListValues;
    private String[] mListRegn;
    private TextView resultTextView;
    EditText tekst_res;
    Button buttonNy, buttonOK, buttonHjelp, buttonSjekk, buttonFjern;
    Button button9, button8, button7, button6, button5;
    Button button4, button3, button2, button1, button0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spill_aktivitet);

        mListValues = getResources().getStringArray(R.array.listValues);
        resultTextView = findViewById(R.id.tekst_regnstykke);
        randomIndex = (int) (Math.random() * mListValues.length);
        resultTextView.setText(mListValues[randomIndex]);


        tekst_res = (EditText) findViewById(R.id.res_textView);
        mListRegn = getResources().getStringArray(R.array.listRegn);
        randomIndex2 = (int) (Math.random() * mListValues.length);
        if (randomIndex2 != randomIndex) {
            tekst_res.setText(mListRegn[randomIndex2]); }
        else {
            randomIndex2 = (int) (Math.random() * mListValues.length);
            tekst_res.setText(mListRegn[randomIndex2]);
        }


        buttonHjelp = (Button) findViewById(R.id.hjelpSpill);
        buttonHjelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    resultTextView.setText(mListValues[randomIndex2]);

            }
        });

        buttonNy = (Button) findViewById(R.id.buttonNy);
        buttonNy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomIndex2 = (int) (Math.random() * mListValues.length);
                if (randomIndex2 != randomIndex) {
                    tekst_res.setText(mListRegn[randomIndex2]); }
                else {
                    randomIndex2 = (int) (Math.random() * mListValues.length);
                    tekst_res.setText(mListRegn[randomIndex2]);
                }

            }
        });




        Button avsluttSpillet = findViewById(R.id.avsluttSpill);
        Intent i = new Intent(this, MainActivity.class);

        avsluttSpillet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(i);
            }
        });
    }

}





