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
    public int x= 0;
    private String[] mListValues;
    private String[] mListRegn;
    int[] indekser;
    String[] check, innverdi;
    private TextView resultTextView;
    EditText tekst_res;
    Button buttonNy, buttonOK, buttonHjelp, buttonSjekk, buttonFjern;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spill_aktivitet);



        Button butt0 = (Button) findViewById(R.id.button0);
        Button butt1 = (Button) findViewById(R.id.button1);
        Button butt2 = (Button) findViewById(R.id.button2);
        Button butt3 = (Button) findViewById(R.id.button3);
        Button butt4 = (Button) findViewById(R.id.button4);
        Button butt5 = (Button) findViewById(R.id.button5);
        Button butt6 = (Button) findViewById(R.id.button6);
        Button butt7 = (Button) findViewById(R.id.button7);
        Button butt8 = (Button) findViewById(R.id.button8);
        Button butt9 = (Button) findViewById(R.id.button9);

        butt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2]+ "0");
            }
        });

        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2]+ "1");
            }
        });

        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2]+ "2");
            }
        });
        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2]+ "3");
            }
        });

        butt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2]+ "4");
            }
        });

        butt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2]+ "5");
            }
        });

        butt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2]+ "6");
            }
        });

        butt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2]+ "7");
            }
        });

        butt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2]+ "8");
            }
        });

        butt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2]+ "9");
            }
        });


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

        buttonSjekk = (Button) findViewById(R.id.buttonCheck);
        buttonSjekk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                innverdi = tekst_res.getText().toString().split("=");
                String Str_innverdi = innverdi[1].trim();
                check = mListValues[randomIndex2].split("=");
                String Str_check = check[1].trim();
                resultTextView.setText(mListValues[randomIndex2]);
                Log.d("Check", Str_check);
                Log.d("Innverdi", Str_innverdi);

                if  (Str_check.equals(Str_innverdi)){
                    tekst_res.setText("Riktig!");
                }
                else {
                    tekst_res.setText("Feil!");
                }
            }
        });


        buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x= 0;
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