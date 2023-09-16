package com.example.s336154_mappe1;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

public class SpillAktivitet extends AppCompatActivity {


    private String[] mListValues;
    private TextView resultTextView;
    EditText tekst_res;
    Button buttonNy, buttonOK;
    Button button9, button8, button7, button6, button5;
    Button button4, button3, button2, button1, button0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spill_aktivitet);

        /*
        Resources res = getResources();
        TypedArray regnstykker = res.obtainTypedArray(R.array.listValues);

        for(int i=0;i<regnstykker.length();i++){
            String regn = (String) regnstykker.getText(i); // 0 is the default color if not found
            resultTextView =  findViewById(R.id.tekst_regnstykke);
            resultTextView.setText(regn);
           regnstykker.recycle();
        }

         */

        // Get the string array from resources
        mListValues = getResources().getStringArray(R.array.listValues);

        // Get a reference to the TextView
        resultTextView = findViewById(R.id.tekst_regnstykke);

        // Generate a random index
        int randomIndex = (int) (Math.random() * mListValues.length);

        // Set the random item as the text of the TextView
        resultTextView.setText(mListValues[randomIndex]);


        tekst_res = (EditText) findViewById(R.id.res_textView);

        resultTextView = findViewById(R.id.res_textView);
        Log.d("I Spillet ", "oncreate Spillet");

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





